package com.api.oneourbe.api.domain.notice;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDAO {

    private long cp_noti_seq;
    private String type;
    private String title;
    private String content;
    private long view_cnt;
}
