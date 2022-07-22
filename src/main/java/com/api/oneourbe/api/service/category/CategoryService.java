package com.api.oneourbe.api.service.category;


import com.api.oneourbe.api.domain.category.CategoryDAO;
import com.api.oneourbe.api.domain.company.CompanyDAO;
import com.api.oneourbe.api.mapper.slave.category.CategorySlaveMapper;
import com.api.oneourbe.api.mapper.slave.company.CompanySlaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin
public class CategoryService {

    @Autowired
    CategorySlaveMapper categorySlaveMapper;


    @Transactional(rollbackFor = Exception.class )
    public List<CategoryDAO> categoryMainList() throws Exception {

        return categorySlaveMapper.categoryMainList();
    }

}
