package com.api.oneourbe.api.mapper.master.user;

import com.api.oneourbe.api.domain.member.MemberInfoDAO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserManageMapper {

    MemberInfoDAO userJoin(MemberInfoDAO memberInfoDAO);

    MemberInfoDAO userInfo(MemberInfoDAO member_seq);

    int userJoinValidate(MemberInfoDAO memberInfoDAO);
}
