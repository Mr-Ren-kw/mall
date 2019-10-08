package com.j4h.mall.service.extension.coupon;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.extension.CouUserMapper;
import com.j4h.mall.mapper.extension.CouponMapper;
import com.j4h.mall.model.extension.coupon.BeanForDatabase.Coupon;
import com.j4h.mall.model.extension.coupon.BeanForDatabase.CouponUser;
import com.j4h.mall.vo.extension.BeanForData.PageData;
import com.j4h.mall.vo.extension.BeanForRequest.CouUserPageRequest;
import com.j4h.mall.vo.extension.BeanForRequest.CouponPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    CouponMapper couponMapper;
    @Autowired
    CouUserMapper couUserMapper;

    @Override
    public PageData queryCouponByPage(CouponPageRequest couponPageRequest) {
        String name = couponPageRequest.getName();
        Integer status = couponPageRequest.getStatus();
        Integer type = couponPageRequest.getType();
        if(name != null) {
            name = "%" + name + "%";
        }
        PageData couponPageData = new PageData<Coupon>();
        String orderBy = couponPageRequest.getSort() + " " + couponPageRequest.getOrder();
        PageHelper.startPage(couponPageRequest.getPage(), couponPageRequest.getLimit(), orderBy);
        List<Coupon> couponList = couponMapper.queryCouponByCondition(name, status, type);
        PageInfo<Coupon> couponPageInfo = new PageInfo<>(couponList);
        long total = couponPageInfo.getTotal();
        couponPageData.setItems(couponList);
        couponPageData.setTotal((int)total);
        return couponPageData;
    }

    @Override
    public Coupon addCoupon(Coupon coupon) {
        couponMapper.insertCoupon(coupon);
        return couponMapper.queryCouponById(coupon.getId());
    }

    @Override
    public Coupon queryCouponById(int id) {
        return couponMapper.queryCouponById(id);
    }

    @Override
    public PageData queryCouUserByPage(CouUserPageRequest couUserPageRequest) {
        PageData couUserPageData = new PageData<CouponUser>();
        Integer couponId = couUserPageRequest.getCouponId();
        Integer status = couUserPageRequest.getStatus();
        Integer userId = null;
        if(couUserPageRequest.getUserId() != null && !"".equals(couUserPageRequest.getUserId())) {
            try {
                userId = Integer.parseInt(couUserPageRequest.getUserId());
            } catch (NumberFormatException e) {
                return couUserPageData;
            }
        }
        String orderBy = couUserPageRequest.getSort() + " " + couUserPageRequest.getOrder();
        PageHelper.startPage(couUserPageRequest.getPage(), couUserPageRequest.getLimit(), orderBy);
        List<CouponUser> couponUsers = couUserMapper.queryCouUserByCondition(couponId, userId, status);
        PageInfo<CouponUser> couponPageInfo = new PageInfo<>(couponUsers);
        long total = couponPageInfo.getTotal();
        couUserPageData.setItems(couponUsers);
        couUserPageData.setTotal((int)total);
        return couUserPageData;
    }

    @Override
    public Coupon updateCoupon(Coupon coupon) {
        couponMapper.updateCoupon(coupon);
        return couponMapper.queryCouponById(coupon.getId());
    }

    @Override
    public void deleteCoupon(Coupon coupon) {
        couponMapper.deleteCouponById(coupon.getId());
    }
}
