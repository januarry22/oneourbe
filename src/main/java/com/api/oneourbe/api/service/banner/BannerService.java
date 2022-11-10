package com.api.oneourbe.api.service.banner;


import com.api.oneourbe.api.domain.banner.BannerDAO;
import com.api.oneourbe.api.mapper.slave.banner.BannerSlaveMapper;
import com.api.oneourbe.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin
public class BannerService {

    @Autowired
    BannerSlaveMapper bannerSlaveMapper;


    @Transactional(rollbackFor = Exception.class )
    public List<BannerDAO> bannerList() throws Exception {

        List<BannerDAO> bannerList = bannerSlaveMapper.bannerList();

        return bannerList;
    }

}
