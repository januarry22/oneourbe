package com.api.oneourbe.config.aop;

import com.api.oneourbe.util.ApiPrintUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

@Aspect
@Component
public class logAop {

    /*요청(전체) 포인트컷*/
    @Around("execution(* com.api.oneourbe.api.controller..*.*(..)) ")
    public Object requestAll(ProceedingJoinPoint joinPoint) throws Throwable { //
        // request, response 객체 얻어오기
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        // request에 담겨온 url, 파라미터 콘솔에출력
        System.out.println("##########################################################################################################");
        System.out.println("protocol    :  " + request.getProtocol());
        System.out.println("URL         :  " + request.getRequestURL());
        System.out.println("method      :  " + request.getMethod());
        System.out.println("referer     :  " + request.getHeader("referer"));
        System.out.println("##########################################################################################################");
        return joinPoint.proceed();
    }

    /*GET 포인트컷*/
    @Pointcut("execution(* com.api.oneourbe.api.controller.*.*RestController.*(..)) && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void requestGet(){}

    /*GET 컨트롤러 실행전*/
    @Before("requestGet()")
    public void doBeforeGet(JoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Enumeration params = request.getParameterNames();
        int index = 1;
        String str = "";
        System.out.println("############################################      Request(요청) Param     #################################");
        while (params.hasMoreElements()) {
            String name = (String) params.nextElement();
            System.out.println("param [" + (index++) + "]   :  " + name + " - " + request.getParameter(name));
            str += name+"="+request.getParameter(name)+"&";
        }
        System.out.println("############################################      Request(요청) Param     #################################");
    //    this.reqSave(str);
    }
    /*GET 리턴시*/
    @AfterReturning(returning = "result", pointcut = "requestGet()")
    public void doAfterReturningGet(Object result) throws Throwable {
        ApiPrintUtil.returnPrint(ApiPrintUtil.mapToJson(result));
    }



    /*POST 포인트컷*/
    @Pointcut("execution(* com.api.oneourbe.api.controller.*.*RestController.*(..)) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void requestPost(){}

    /*POST 컨트롤러 실행전*/
    @Before("requestPost() && args(.., @RequestBody body)")
    public void  doBeforePost(JoinPoint joinPoint, final Object body) throws Throwable {
        ApiPrintUtil.reqPrint(ApiPrintUtil.mapToJson(body));
    }

    /*POST 리턴시*/
    @AfterReturning(returning = "result", pointcut = "requestPost()")
    public void doAfterReturningPost(Object result) throws Throwable {
        ApiPrintUtil.returnPrint(ApiPrintUtil.mapToJson(result));
    }

}
