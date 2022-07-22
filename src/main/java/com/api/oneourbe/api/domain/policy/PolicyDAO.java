package com.api.oneourbe.api.domain.policy;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PolicyDAO {

    private long cp_policy_seq;
    private String type;
    private String title;
    private String content;
}
