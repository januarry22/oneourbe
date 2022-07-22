package com.api.oneourbe.api.controller.category;


import com.api.oneourbe.api.service.category.CategoryService;
import com.api.oneourbe.api.service.company.CompanyService;
import com.api.oneourbe.util.ApiResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class CategoryRestController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/api/v1/category/main")
    @ApiOperation(value = "메인 카테고리 리스트")
    public ApiResponse catregoryMainList(HttpServletRequest httpRequest) throws Exception {

        ApiResponse apiRes = new ApiResponse();


        apiRes.setAlert(true);
        apiRes.setData(categoryService.categoryMainList());
        apiRes.setSuccess(true);
        return apiRes;
    }

}
