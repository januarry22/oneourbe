package com.api.oneourbe.api.mapper.slave.category;


import com.api.oneourbe.api.domain.banner.BannerDAO;
import com.api.oneourbe.api.domain.category.CategoryDAO;
import com.api.oneourbe.api.domain.company.CompanyDAO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategorySlaveMapper {

    List<CategoryDAO> categoryMainList();
}
