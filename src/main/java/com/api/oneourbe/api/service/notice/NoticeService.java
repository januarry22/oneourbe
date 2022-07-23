package com.api.oneourbe.api.service.notice;


import com.api.oneourbe.api.domain.notice.FooterNoticeDAO;
import com.api.oneourbe.api.domain.policy.PolicyDAO;
import com.api.oneourbe.api.mapper.slave.notice.NoticeSlaveMapper;
import com.api.oneourbe.api.mapper.slave.policy.PolicySlaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin
public class NoticeService {

    @Autowired
    NoticeSlaveMapper noticeSlaveMapper;


    @Transactional(rollbackFor = Exception.class )
    public List<FooterNoticeDAO> footerNotice() throws Exception {

        return noticeSlaveMapper.footerNotice();
    }

}
