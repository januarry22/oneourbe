package com.api.oneourbe.api.mapper.slave.notice;


import com.api.oneourbe.api.domain.notice.FooterNoticeDAO;
import com.api.oneourbe.api.domain.notice.NoticeDAO;
import com.api.oneourbe.api.domain.notice.NoticeReqDAO;
import com.api.oneourbe.api.domain.policy.PolicyDAO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeSlaveMapper {

    List<FooterNoticeDAO> footerNotice();
    List<NoticeDAO> noticeList(NoticeReqDAO noticeReqDAO);
}
