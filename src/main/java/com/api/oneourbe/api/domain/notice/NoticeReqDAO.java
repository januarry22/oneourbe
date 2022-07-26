package com.api.oneourbe.api.domain.notice;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeReqDAO {

    private long cp_noti_seq;
    private String type;
    private String title;
    private String content;
    private long view_cnt;
}
