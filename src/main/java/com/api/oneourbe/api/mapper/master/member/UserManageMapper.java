package com.api.oneourbe.api.mapper.master.member;

import com.api.oneourbe.api.domain.member.MemberInfoDAO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserManageMapper {

    int userJoin(MemberInfoDAO memberInfoDAO);
}
