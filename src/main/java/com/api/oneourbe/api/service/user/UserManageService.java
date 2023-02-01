package com.api.oneourbe.api.service.user;


import com.api.oneourbe.api.domain.member.MemberInfoDAO;


public interface UserManageService {

    public MemberInfoDAO userJoin(MemberInfoDAO memberInfoDAO);
    MemberInfoDAO userInfo(int member_seq);
    public int userJoinValidate(MemberInfoDAO memberInfoDAO);

}
