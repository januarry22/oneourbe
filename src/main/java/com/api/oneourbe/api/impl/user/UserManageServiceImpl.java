package com.api.oneourbe.api.impl.user;


import com.api.oneourbe.api.domain.member.MemberInfoDAO;
import com.api.oneourbe.api.mapper.master.member.UserManageMapper;
import com.api.oneourbe.api.mapper.slave.member.MemberSlaveMapper;
import com.api.oneourbe.api.service.auth.AuthService;
import com.api.oneourbe.api.service.user.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManageServiceImpl implements UserManageService {
    @Autowired
    UserManageMapper userManageMapper;

    @Override
    public int userJoin(MemberInfoDAO memberInfoDAO) {
        return userManageMapper.userJoin(memberInfoDAO);
    }
}
