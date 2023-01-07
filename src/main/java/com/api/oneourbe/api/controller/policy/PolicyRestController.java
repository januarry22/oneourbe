package com.api.oneourbe.api.controller.policy;


import com.api.oneourbe.api.service.company.CompanyService;
import com.api.oneourbe.api.service.policy.PolicyService;
import com.api.oneourbe.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class PolicyRestController {

    @Autowired
    PolicyService policyService;

    @GetMapping("/api/v1/policy")
    public ApiResponse policy(HttpServletRequest httpRequest) throws Exception {

        ApiResponse apiRes = new ApiResponse();


        apiRes.setAlert(true);
        apiRes.setData(policyService.policy());
        apiRes.setSuccess(true);
        return apiRes;
    }

}
