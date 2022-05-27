package com.api.oneourbe.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class ApiResponse<T> {

    private boolean success = true;
    private boolean alert = false;
    private String errCode;
    private String errMsg;
    private String sessionId;
    private String timestamp;
    private T data;

    public ApiResponse(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        this.sessionId = session.getId();
        this.timestamp = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss").format(new Date());
    }

}
