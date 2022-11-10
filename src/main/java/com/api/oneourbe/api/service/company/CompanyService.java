package com.api.oneourbe.api.service.company;


import com.api.oneourbe.api.domain.company.CompanyDAO;
import com.api.oneourbe.api.mapper.slave.company.CompanySlaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

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
