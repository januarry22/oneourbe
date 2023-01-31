package com.api.oneourbe.api.service.auth;


import com.api.oneourbe.api.domain.member.MemberInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface AuthService {

    public MemberInfoDAO userCheck(MemberInfoDAO memberInfoDAO);
}
