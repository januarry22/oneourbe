package com.api.oneourbe.api.controller.login;


import com.api.oneourbe.util.ApiResponse;
import com.api.oneourbe.api.domain.member.MemberInfoDAO;
import com.api.oneourbe.api.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class LoginRestController {

    @Autowired
    AuthService authService;

    @PostMapping("/api/v1/login")
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
