package com.j4h.mall.mapper.extension;

import com.j4h.mall.model.extension.groupon.BeanForDatabase.Groupon;
import com.j4h.mall.model.extension.groupon.BeanForDatabase.GrouponUser;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface GrouponMapper {

    GrouponUser[] queryParticipanter(@Param("id") int creatorUserId);

    Groupon queryGrouponByRuleId(@Param("id") Integer rulesId);
}
