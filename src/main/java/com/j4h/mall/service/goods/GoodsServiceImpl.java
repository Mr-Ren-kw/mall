package com.j4h.mall.service.goods;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.goods.GoodsMapper;
import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.goods.*;
import com.j4h.mall.vo.goods.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public PageBean getGoodsInfo(int page, int limit, String sort, String order, Integer goodsSn, String name) {
        PageHelper.startPage(page, limit, sort + " " + order);
        if (name != null) {
            name = "%" + name + "%";
        }
        List<Goods> items = goodsMapper.getGoodsInfo(goodsSn, name);
        PageInfo goodItemPageInfo = new PageInfo(items);
        long total = goodItemPageInfo.getTotal();
        PageBean goodInfo = new PageBean();
        goodInfo.setItems(items);
        goodInfo.setTotal(total);
        return goodInfo;
    }

    @Override
    public int createGoods(GoodsItemVo goodsItemVo) {
        Goods goods = goodsItemVo.getGoods();
        if(goods.getName() == null || goods.getGoodsSn() == null || "".equals(goods.getName()) || "".equals(goods.getGoodsSn())) {
            return 2;
        }
//        if("".equals(goods.getCounterPrice().trim()))
        List<Goods> goodsList = goodsMapper.getGoodsByName(goods.getName());
        if (goodsList == null || goodsList.isEmpty()) {
            goodsMapper.insertGoods(goodsItemVo.getGoods());
            //spec 的Url不能为空
            goodsMapper.insertGoodsSpecifications(goodsItemVo.getGoods().getId(), goodsItemVo.getSpecifications());
            goodsMapper.insertGoodsProducts(goodsItemVo.getGoods().getId(), goodsItemVo.getProducts());
            if (goodsItemVo.getAttributes() != null && goodsItemVo.getAttributes().size() > 0) {
                goodsMapper.insertGoodsAttributes(goodsItemVo.getGoods().getId(), goodsItemVo.getAttributes());
            }
            return 0;
        }
        //说明有同名商品，返回1
        return 1;
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

    @Override
    public GoodsItemVo getGoodsDetail(int id) {
        Goods goods = goodsMapper.getGoodsById(id);
        List<GoodsSpecification> goodsSpecification = goodsMapper.getGoodsSpecificationByGid(id);
        List<GoodsProduct> goodsProduct = goodsMapper.getGoodsProductByGid(id);
        List<GoodsAttribute> goodsAttribute = goodsMapper.getGoodsAttributeByGid(id);
        // 这里detail要返回的CategoryIds是是数组类型，第一个是父分类的id，第二个是子分类的id，但是一次查询不能生成一个数组，所以单独处理
        GoodsItemVo goodsItemVo = new GoodsItemVo();
        Integer childCategoryId = goodsMapper.getChildCategoryIdByGid(id);
        List<Integer> categoryIds = new ArrayList<>();
        if (childCategoryId != null) {
            Integer fatherCategoryId = goodsMapper.getFatherCategoryIdByGid(childCategoryId);
            categoryIds.add(fatherCategoryId);
            categoryIds.add(childCategoryId);
            if (fatherCategoryId != null) {
                goodsItemVo.setCategoryIds(categoryIds);
            }
        }
        goodsItemVo.setGoods(goods);
        goodsItemVo.setAttributes(goodsAttribute);
        goodsItemVo.setProducts(goodsProduct);
        goodsItemVo.setSpecifications(goodsSpecification);
        return goodsItemVo;
    }

    @Override
    public int updateGoods(GoodsItemVo goodsItemVo) {
        // 和添加商品类似
        Goods goods = goodsItemVo.getGoods();
        if(goods.getName() == null || goods.getGoodsSn() == null || "".equals(goods.getName()) || "".equals(goods.getGoodsSn())) {
            return 2;
        }
        List<Goods> goodsList = goodsMapper.getGoodsByNameExceptId(goods.getName(), goods.getId());
        // 如果没有重复商品，则更新商品
        if (goodsList == null || goodsList.isEmpty()) {
            goodsMapper.updateGoods(goodsItemVo.getGoods());
            // 对这些List的更新的操作步骤是，先把数据库原来的逻辑删除，然后插入新的数据
            //删除
            goodsMapper.deleteGoodsSpecifications(goodsItemVo.getGoods().getId());
            goodsMapper.deleteGoodsProducts(goodsItemVo.getGoods().getId());
            goodsMapper.deleteGoodsAttributes(goodsItemVo.getGoods().getId());
            //插入操作
            if (goodsItemVo.getSpecifications() != null && goodsItemVo.getSpecifications().size() > 0) {
                goodsMapper.insertGoodsSpecifications(goodsItemVo.getGoods().getId(), goodsItemVo.getSpecifications());
            }
            if (goodsItemVo.getProducts() != null && goodsItemVo.getProducts().size() > 0) {
                goodsMapper.insertGoodsProducts(goodsItemVo.getGoods().getId(), goodsItemVo.getProducts());
            }
            if (goodsItemVo.getAttributes() != null && goodsItemVo.getAttributes().size() > 0) {
                goodsMapper.insertGoodsAttributes(goodsItemVo.getGoods().getId(), goodsItemVo.getAttributes());
            }
            return 0;
        }
        return 1;
    }

    @Override
    public void deleteGoods(int id) {
        goodsMapper.deleteGoods(id);
        goodsMapper.deleteGoodsAttributes(id);
        goodsMapper.deleteGoodsProducts(id);
        goodsMapper.deleteGoodsSpecifications(id);
    }

    @Override
    public PageBean<GoodsComment> getAllGoodsComment(int page, int limit, String sort, String order, Integer userId, Integer valueId) {
        PageHelper.startPage(page, limit, sort + " " + order);
        List<GoodsComment> items = goodsMapper.getGoodsComments(userId, valueId);
        PageInfo<GoodsComment> goodItemPageInfo = new PageInfo<>(items);
        long total = goodItemPageInfo.getTotal();
        PageBean<GoodsComment> goodInfo = new PageBean<>();
        goodInfo.setItems(items);
        goodInfo.setTotal(total);
        return goodInfo;
    }

    @Override
    public void deleteComment(int id) {
        goodsMapper.deleteCommentById(id);
    }

}
