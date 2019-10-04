package com.j4h.mall.mapper.system;

import com.j4h.mall.model.system.LogVo;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/3 23:21
 */
public interface LogMapper {
    List<LogVo> queryLogByName(String name);
}
