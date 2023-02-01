package com.api.oneourbe.api.impl.auth;


import com.api.oneourbe.api.domain.member.MemberInfoDAO;
import com.api.oneourbe.api.mapper.slave.member.MemberSlaveMapper;
import com.api.oneourbe.api.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    MemberSlaveMapper memberSlaveMapper;

    @Override
    public MemberInfoDAO userCheck(MemberInfoDAO memberInfoDAO) {
        MemberInfoDAO memberInfoRequest = new MemberInfoDAO();
        memberInfoRequest.setEmail(memberInfoDAO.getEmail());
        return memberSlaveMapper.userCheck(memberInfoRequest);
    }
}
