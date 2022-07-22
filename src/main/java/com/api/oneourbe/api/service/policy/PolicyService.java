package com.api.oneourbe.api.service.policy;


import com.api.oneourbe.api.domain.company.CompanyDAO;
import com.api.oneourbe.api.domain.policy.PolicyDAO;
import com.api.oneourbe.api.mapper.slave.company.CompanySlaveMapper;
import com.api.oneourbe.api.mapper.slave.policy.PolicySlaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin
public class PolicyService {

    @Autowired
    PolicySlaveMapper policySlaveMapper;


    @Transactional(rollbackFor = Exception.class )
    public List<PolicyDAO> policy() throws Exception {

        return policySlaveMapper.policy();
    }

}
