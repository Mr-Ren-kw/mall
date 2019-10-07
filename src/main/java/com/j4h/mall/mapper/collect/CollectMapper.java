package com.j4h.mall.mapper.collect;

import com.j4h.mall.model.wx.collect.Collect;
import com.j4h.mall.model.wx.collect.CollectInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {

    Collect getCollectByUidValueIdType(@Param("uid") Integer userId, @Param("gid") int valueId, @Param("type") int type);

    void insertCollect(@Param("uid") Integer userId, @Param("gid") int valueId, @Param("type") int type);

    void deleteCollect(@Param("uid") Integer userId, @Param("gid") int valueId, @Param("type") int type);

    List<CollectInfo> getCollectsByUidType(@Param("uid") Integer userId, @Param("type") int type);

}
