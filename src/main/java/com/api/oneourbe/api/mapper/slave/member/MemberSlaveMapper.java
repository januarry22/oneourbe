package com.api.oneourbe.api.mapper.slave.member;


import com.api.oneourbe.api.domain.member.MemberInfoDAO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberSlaveMapper {

    MemberInfoDAO userCheck(MemberInfoDAO memberInfoDAO);
}
