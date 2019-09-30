package com.j4h.mall.mapper.systemManageMapper;

import com.j4h.mall.model.systemBean.AdminOfSystemManage;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/9/30 21:18
 */
public interface AdminMapper {

    // 查找所有的admin
    List<AdminOfSystemManage> queryAllAdmin();
}
