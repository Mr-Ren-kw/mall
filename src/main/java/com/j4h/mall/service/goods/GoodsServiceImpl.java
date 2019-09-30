package com.j4h.mall.service.goods;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.goods.GoodsMapper;
import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.goods.Category;
import com.j4h.mall.model.goods.GoodItem;
import com.j4h.mall.vo.goods.Brand;
import com.j4h.mall.vo.goods.CatAndBrandVo;
import com.j4h.mall.vo.goods.GoodsItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements  GoodsService{

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public PageBean getGoodsInfo(int page, int limit, String sort, String order, Integer goodsSn, String name) {
        PageHelper.startPage(page, limit, sort + " " + order);
        if(name != null) {
            name = "%" + name + "%";
        }
        List<GoodItem> items = goodsMapper.getGoodsInfo(goodsSn, name);
        PageInfo goodItemPageInfo = new PageInfo(items);
        long total = goodItemPageInfo.getTotal();
        PageBean goodInfo = new PageBean();
        goodInfo.setItems(items);
        goodInfo.setTotal(total);
        return goodInfo;
    }

    @Override
    public void createGoods(GoodsItemVo goodsItemVo) {
        goodsMapper.insertGoods(goodsItemVo.getGoods());
        goodsMapper.insertGoodsSpecifications(goodsItemVo.getGoods().getId(), goodsItemVo.getSpecifications());
        goodsMapper.insertGoodsProducts(goodsItemVo.getGoods().getId(), goodsItemVo.getProducts());
        goodsMapper.insertGoodsAttributes(goodsItemVo.getGoods().getId(), goodsItemVo.getAttributes());
    }

    @Override
    public CatAndBrandVo getAllCatAndBrand() {
        List<Category> categoryList = goodsMapper.getAllCategory();
        List<Brand> brandList = goodsMapper.getAllBrand();
        CatAndBrandVo catAndBrandVo = new CatAndBrandVo();
        catAndBrandVo.setCategoryList(categoryList);
        catAndBrandVo.setBrandList(brandList);
        return catAndBrandVo;
    }

}
