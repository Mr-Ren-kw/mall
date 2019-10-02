package com.j4h.mall.mapper.homepage;


public interface DashboardMapper {

    // 查询goods表
    int getGoodsTotal();

    // 查询order表
    int getOrderTotal();

    // 查询product表
    int getProductTotal();

    // 查询user表
    int getUserTotal();
}
