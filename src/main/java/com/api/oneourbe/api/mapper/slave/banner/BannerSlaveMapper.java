package com.api.oneourbe.api.mapper.slave.banner;


import com.api.oneourbe.api.domain.banner.BannerDAO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerSlaveMapper {

    List<BannerDAO> bannerList();
}
