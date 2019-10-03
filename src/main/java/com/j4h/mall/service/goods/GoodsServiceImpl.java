package com.j4h.mall.service.goods;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.goods.GoodsMapper;
import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.goods.*;
import com.j4h.mall.vo.goods.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Goods> items = goodsMapper.getGoodsInfo(goodsSn, name);
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

    @Override
    public GoodsItemVo getGoodsDetail(int id) {
        Goods goods = goodsMapper.getGoodsById(id);
        List<GoodsSpecification> goodsSpecification = goodsMapper.getGoodsSpecificationByGid(id);
        List<GoodsProduct> goodsProduct = goodsMapper.getGoodsProductByGid(id);
        List<GoodsAttribute> goodsAttribute = goodsMapper.getGoodsAttributeByGid(id);
        // 这里detail要返回的CategoryIds是是数组类型，第一个是父分类的id，第二个是子分类的id，但是一次查询不能生成一个数组，所以单独处理
        int childCategoryId = goodsMapper.getChildCategoryIdByGid(id);
        int fatherCategoryId = goodsMapper.getFatherCategoryIdByGid(childCategoryId);
        List<Integer> categoryIds = new ArrayList<>();
        categoryIds.add(fatherCategoryId);
        categoryIds.add(childCategoryId);
        GoodsItemVo goodsItemVo = new GoodsItemVo();
        goodsItemVo.setGoods(goods);
        goodsItemVo.setAttributes(goodsAttribute);
        goodsItemVo.setProducts(goodsProduct);
        goodsItemVo.setSpecifications(goodsSpecification);
        goodsItemVo.setCategoryIds(categoryIds);
        return goodsItemVo;
    }

    @Override
    public void updateGoods(GoodsItemVo goodsItemVo) {
        goodsMapper.updateGoods(goodsItemVo.getGoods());
        // 对这些List的更新的操作步骤是，先把数据库原来的逻辑删除，然后插入新的数据
        //删除
        goodsMapper.deleteGoodsSpecifications(goodsItemVo.getGoods().getId());
        goodsMapper.deleteGoodsProducts(goodsItemVo.getGoods().getId());
        goodsMapper.deleteGoodsAttributes(goodsItemVo.getGoods().getId());
        //插入操作
        goodsMapper.insertGoodsAttributes(goodsItemVo.getGoods().getId(), goodsItemVo.getAttributes());
        goodsMapper.insertGoodsSpecifications(goodsItemVo.getGoods().getId(), goodsItemVo.getSpecifications());
        goodsMapper.insertGoodsProducts(goodsItemVo.getGoods().getId(), goodsItemVo.getProducts());
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
