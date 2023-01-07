package com.api.oneourbe.api.controller.company;


import com.api.oneourbe.api.service.banner.BannerService;
import com.api.oneourbe.api.service.company.CompanyService;
import com.api.oneourbe.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class CompanyRestController {

    @Autowired
    CompanyService companyService;


    @GetMapping("/api/v1/company")
    public ApiResponse companyInfo(HttpServletRequest httpRequest) throws Exception {

        ApiResponse apiRes = new ApiResponse();


        apiRes.setAlert(true);
        apiRes.setData(companyService.companyInfo());
        apiRes.setSuccess(true);
        return apiRes;
    }

}
