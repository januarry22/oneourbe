package com.api.oneourbe.api.service.company;


import com.api.oneourbe.api.domain.banner.BannerDAO;
import com.api.oneourbe.api.domain.company.CompanyDAO;
import com.api.oneourbe.api.mapper.slave.banner.BannerSlaveMapper;
import com.api.oneourbe.api.mapper.slave.company.CompanySlaveMapper;
import com.api.oneourbe.api.service.banner.BannerBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin
public class CompanyService {

    @Autowired
    CompanySlaveMapper companySlaveMapper;


    @Transactional(rollbackFor = Exception.class )
    public CompanyDAO companyInfo() throws Exception {

        return companySlaveMapper.companyInfo();
    }

}
