package com.api.oneourbe.api.impl.user;


import com.api.oneourbe.api.domain.member.MemberInfoDAO;
import com.api.oneourbe.api.mapper.master.user.UserManageMapper;
import com.api.oneourbe.api.mapper.slave.member.MemberSlaveMapper;
import com.api.oneourbe.api.service.user.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserManageServiceImpl implements UserManageService {
    @Autowired
    UserManageMapper userManageMapper;

    @Override
    @Transactional
    public MemberInfoDAO userJoin(MemberInfoDAO memberInfoDAO) {
        if(userJoinValidate(memberInfoDAO)>0){
            return null;
        }
        MemberInfoDAO member_seq = userManageMapper.userJoin(memberInfoDAO);
        MemberInfoDAO requestMemberInfo = userManageMapper.userInfo(member_seq);
        return requestMemberInfo;
    }

    @Override
    public MemberInfoDAO userInfo(MemberInfoDAO member_seq){
        return userManageMapper.userInfo(member_seq);
    }

    @Override
    public int userJoinValidate(MemberInfoDAO memberInfoDAO) {
        return userManageMapper.userJoinValidate(memberInfoDAO);
    }
}
