package com.api.oneourbe.api.controller.notice;


import com.api.oneourbe.api.service.notice.NoticeService;
import com.api.oneourbe.api.service.policy.PolicyService;
import com.api.oneourbe.util.ApiResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class NoticeRestController {

    @Autowired
    NoticeService noticeService;

    @GetMapping("/api/v1/footer/noti")
    @ApiOperation(value = "footer 섹션 공지 ")
    public ApiResponse footerNotice(HttpServletRequest httpRequest) throws Exception {

        ApiResponse apiRes = new ApiResponse();


        apiRes.setAlert(true);
        apiRes.setData(noticeService.footerNotice());
        apiRes.setSuccess(true);
        return apiRes;
    }

}
