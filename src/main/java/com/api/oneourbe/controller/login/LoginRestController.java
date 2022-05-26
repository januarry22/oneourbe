package com.api.oneourbe.controller.login;


import com.api.oneourbe.domain.api.ApiResponse;
import com.api.oneourbe.domain.member.MemberInfoDAO;
import com.api.oneourbe.service.auth.AuthService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@RestController
@RequiredArgsConstructor
public class LoginRestController {

    @Autowired
    AuthService authService;

    @PostMapping("/api/v1/login")
    @ApiOperation(value = "로그인")
    public ApiResponse login(HttpServletRequest httpRequest, @RequestBody MemberInfoDAO memberInfoDAO) {

        ApiResponse apiRes = new ApiResponse();

        MemberInfoDAO memberInfoDAO1 = new MemberInfoDAO();
        memberInfoDAO1.setMember_seq(1);
        memberInfoDAO1.setEmail("tlswldnjs8865@gmail.com");

        apiRes.setAlert(true);
        apiRes.setData(memberInfoDAO1);
        apiRes.setSuccess(true);
        return apiRes;
    }

    @GetMapping("/api/v1/login/{id}")
    @ApiOperation(value = "로그인 Get")
    public ApiResponse loginGet(HttpServletRequest httpRequest, @PathVariable long id) {

        ApiResponse apiRes = new ApiResponse();

        MemberInfoDAO memberInfoDAO1 = new MemberInfoDAO();
        memberInfoDAO1.setMember_seq(1);
        memberInfoDAO1.setEmail(httpRequest.getHeader("authToken"));

        apiRes.setAlert(true);
        apiRes.setData(memberInfoDAO1);
        apiRes.setSuccess(true);
        return apiRes;
    }
}
