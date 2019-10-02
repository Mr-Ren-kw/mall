package com.j4h.mall.mapper.reports;

import com.j4h.mall.model.reports.Rows;

import java.util.List;

public interface StatMapper {
    List<Rows> queryStatUser();

    List<Rows> queryStatOrder();

    List<Rows> queryStatGoods();

}
