package com.api.oneourbe.api.controller.banner;


import com.api.oneourbe.api.service.banner.BannerService;
import com.api.oneourbe.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class BannerRestController {

    @Autowired
    BannerService bannerService;

    @GetMapping("/api/v1/banner")
    public ApiResponse bannerList(HttpServletRequest httpRequest) throws Exception {

        ApiResponse apiRes = new ApiResponse();


        apiRes.setAlert(true);
        apiRes.setData(bannerService.bannerList());
        apiRes.setSuccess(true);
        return apiRes;
    }

}
