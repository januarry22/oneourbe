package com.api.oneourbe.api.domain.banner;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BannerDAO {

    private long banner_seq;
    private String link_url;
    private String img_url;
    private String comment;
    private String alt;
}
