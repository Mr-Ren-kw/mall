package com.j4h.mall.mapper.footprint;

import org.apache.ibatis.annotations.Param;

public interface FootprintMapper {

    void insertFootprint(@Param("uid") Integer userId, @Param("gid") int goodsId);

}
