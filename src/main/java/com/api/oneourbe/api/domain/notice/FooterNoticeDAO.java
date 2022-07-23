package com.api.oneourbe.api.domain.notice;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FooterNoticeDAO {

    private long cp_footer_noti_seq;
    private String type;
    private String title;
    private String content;
    private String link_url;
    private String icon_img;
}
