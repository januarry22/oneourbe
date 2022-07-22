package com.api.oneourbe.api.domain.category;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDAO {

    private long ct_total_seq;
    private String type;
    private String name;
    private String comment;
    private String code;
}
