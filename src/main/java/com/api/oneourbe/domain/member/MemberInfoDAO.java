package com.api.oneourbe.domain.member;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberInfoDAO {

    private long member_seq;
    private String email;
    private String name;
    private String user_role;
}
