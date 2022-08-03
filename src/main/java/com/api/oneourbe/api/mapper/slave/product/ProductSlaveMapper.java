package com.api.oneourbe.api.mapper.slave.product;


import com.api.oneourbe.api.domain.policy.PolicyDAO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductSlaveMapper {

    List<PolicyDAO> policy();
}
