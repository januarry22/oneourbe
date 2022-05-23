package com.api.oneourbe.config.aop;

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
import java.util.Map;

@Aspect
@Component
public class logAop {

    static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    /*요청(전체) 포인트컷*/
    @Around("execution(* com.api.oneourbe.controller..*.*(..)) ")
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


    /*POST 포인트컷*/
    @Pointcut("execution(* com.api.oneourbe.controller.*.*RestController.*(..)) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void requestPost(){}

    /*POST 컨트롤러 실행전*/
    @Before("requestPost() && args(.., @RequestBody body)")
    public void  doBeforePost(JoinPoint joinPoint, final Object body) throws Throwable {
        reqPrint(mapToJson(body));
    }

    /*POST 리턴시*/
    @AfterReturning(returning = "result", pointcut = "requestPost()")
    public void doAfterReturningPost(Object result) throws Throwable {
        returnPrint(mapToJson(result));
    }

    public void reqPrint(String str){
        try{
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(str);
            str = gson.toJson(je);
            System.out.println("############################################      Request(요청) Param     #################################");
            System.out.println(str);
            System.out.println("############################################      Request(요청) Param     #################################");
        //    this.reqSave(str);
        }catch(Exception e){
            //errorCode.save(e);
        }
    }
    public void returnPrint(String str){
        try{
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(str);
            str = gson.toJson(je);

            System.out.println("############################################      Response(응답) Param     ################################");
            System.out.println(str);
            System.out.println("############################################      Response(응답) Param     ################################");
          //  this.resSave(str);
        }catch(Exception e){
            //errorCode.save(e);
        }
    }

    public static String mapToJson(Object obj){
        try{
            String ss = "";
            ObjectMapper objectMapper = new ObjectMapper();
            Map map = objectMapper.convertValue(obj, Map.class);
            ss += gson.toJson(map);
            return ss;
        }catch(Exception e){
            return null;
        }

    }
}
