package com.j4h.mall.mapper.extension;

import com.j4h.mall.model.extension.groupon.BeanForDatabase.Groupon;
import com.j4h.mall.model.extension.groupon.BeanForDatabase.GrouponUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GrouponMapper {
    List<Groupon> queryGrouponByCondition(@Param("goodsId") int goodsId);

    GrouponUser[] queryParticipanter(@Param("id") int creatorUserId);
}
