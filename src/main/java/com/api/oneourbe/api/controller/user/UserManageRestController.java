package com.api.oneourbe.api.controller.user;


import com.api.oneourbe.api.domain.member.MemberInfoDAO;
import com.api.oneourbe.api.service.auth.AuthService;
import com.api.oneourbe.api.service.user.UserManageService;
import com.api.oneourbe.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class UserManageRestController {

    @Autowired
    UserManageService userManageService;

    @PostMapping("/api/v1/user/join")
    public ApiResponse login(HttpServletRequest httpRequest, @RequestBody MemberInfoDAO memberInfoDAO) {

        ApiResponse apiRes = new ApiResponse();

        apiRes.setAlert(true);
        apiRes.setData(userManageService.userJoin(memberInfoDAO));
        apiRes.setSuccess(true);
        return apiRes;
    }


}
