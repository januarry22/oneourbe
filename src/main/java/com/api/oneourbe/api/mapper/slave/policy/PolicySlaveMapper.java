package com.api.oneourbe.api.mapper.slave.policy;


import com.api.oneourbe.api.domain.company.CompanyDAO;
import com.api.oneourbe.api.domain.policy.PolicyDAO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PolicySlaveMapper {

    List<PolicyDAO> policy();
}
