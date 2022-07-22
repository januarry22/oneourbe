package com.api.oneourbe.api.domain.company;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDAO {

    private long company_seq;
    private String name;
    private String ceo;
    private String addr;
    private String email;
    private String tel;
}
