package com.j4h.mall.mapper.extension;

import com.j4h.mall.model.extension.ad.BeanForDatabase.Advertise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdMapper {

    List<Advertise> queryAdsByCondition(@Param("name") String name, @Param("content") String content);

    void updateAd(@Param("ad") Advertise advertise);

    Advertise queryAdById(@Param("id") int adId);

    void deleteAdById(@Param("id") int adId);

    void insertAd(@Param("ad") Advertise advertise);
}
