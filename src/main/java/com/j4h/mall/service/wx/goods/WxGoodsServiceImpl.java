package com.j4h.mall.service.wx.goods;

import com.github.pagehelper.PageHelper;
import com.j4h.mall.mapper.extension.GrouponMapper;
import com.j4h.mall.mapper.extension.GrouponRulesMapper;
import com.j4h.mall.mapper.goods.GoodsMapper;
import com.j4h.mall.mapper.mall.BrandMapper;
import com.j4h.mall.mapper.mall.CategoryMapper;
import com.j4h.mall.mapper.mall.IssueMapper;
import com.j4h.mall.mapper.user.UserMapper;
import com.j4h.mall.model.extension.groupon.BeanForDatabase.Groupon;
import com.j4h.mall.model.extension.groupon.BeanForDatabase.GrouponRules;
import com.j4h.mall.model.goods.*;
import com.j4h.mall.model.mall.brand.Brand;
import com.j4h.mall.model.mall.category.CategoryInfo;
import com.j4h.mall.model.mall.issue.Issue;
import com.j4h.mall.model.wx.catalog.WxCategory;
import com.j4h.mall.model.wx.goods.*;
import com.j4h.mall.vo.goods.BeanForGoodsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class WxGoodsServiceImpl implements WxGoodsService {

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    GrouponMapper grouponMapper;
    @Autowired
    IssueMapper issueMapper;
    @Autowired
    BrandMapper brandMapper;
    @Autowired
    GrouponRulesMapper grouponRulesMapper;

    @Override
    public WxGoodsCount queryGoodsCountForWx() {
        return goodsMapper.queryGoodsCountForWx();
    }

    @Override
    public GoodsListData queryGoodsList(BeanForGoodsPage beanForGoodsPage) {
        int page = beanForGoodsPage.getPage();
        int size = beanForGoodsPage.getSize();
        Integer categoryId = beanForGoodsPage.getCategoryId();
        Integer brandId = beanForGoodsPage.getBrandId();
        PageHelper.startPage(page, size);
        List<Goods> goodsList = goodsMapper.queryGoodsByCondition(categoryId, brandId);
        List<CategoryInfo> allL2Category = categoryMapper.getAllL2CategoryInfo();
        GoodsListData goodsListData = new GoodsListData();
        goodsListData.setCount(goodsList.size());
        goodsListData.setFilterCategoryList(allL2Category);
        goodsListData.setGoodsList(goodsList);
        return goodsListData;
    }

    @Override
    public CategoryDate queryCategory(int categoryId) {
        CategoryDate categoryDate = new CategoryDate();
        WxCategory parentCategory;
        WxCategory currentCategory;
        List<WxCategory> brotherCategory;
        WxCategory category = categoryMapper.queryCurrentCategoryForWx(categoryId);
        int pid = category.getPid();
        int id = category.getId();
        if(pid != 0) {
            currentCategory = category;
            parentCategory = categoryMapper.queryCurrentCategoryForWx(pid);
            brotherCategory = categoryMapper.queryCategoryListForWxIndex(pid);
        }else {
            brotherCategory = categoryMapper.queryCategoryListForWxIndex(id);
            parentCategory = category;
            currentCategory = brotherCategory.get(0);
        }
        categoryDate.setBrotherCategory(brotherCategory);
        categoryDate.setCurrentCategory(currentCategory);
        categoryDate.setParentCategory(parentCategory);
        return categoryDate;
    }

    @Override
    public GoodsDetail queryGoodsDetail(int goodsId) {
        GoodsDetail goodsDetail = new GoodsDetail();
        List<GoodsAttribute> goodsAttribute = goodsMapper.getGoodsAttributeByGid(goodsId);
        Goods goods = goodsMapper.getGoodsById(goodsId);
        Brand brand = brandMapper.brandSearchById(goods.getBrandId());
        CommentData comment = new CommentData();
        List<GoodsComment> commentList = goodsMapper.queryGoodsComment(goodsId);
        comment.setCount(commentList.size());
        comment.setData(commentList);
        List<GrouponRules> grouponRulesList = grouponRulesMapper.queryGrouponRulesByCondition(goodsId);
        List<Groupon> grouponList = new ArrayList<>();
        if(grouponRulesList.size() != 0) {
            for (GrouponRules grouponRules : grouponRulesList) {
                int rulesId = grouponRules.getId();
                Groupon groupon = grouponMapper.queryGrouponByRuleId(rulesId);
                grouponList.add(groupon);
            }
        }
        List<Issue> issue = issueMapper.queryIssueList(null);
        List<SpecificationItem> specificationItemList = new ArrayList<>();
        List<GoodsProduct> productList = goodsMapper.getGoodsProductByGid(goodsId);
        List<GoodsSpecification> specificationList = goodsMapper.getGoodsSpecificationByGid(goodsId);
        for (GoodsSpecification goodsSpecification : specificationList) {
            SpecificationItem specificationItem = new SpecificationItem();
            specificationItem.setName(specificationList.get(0).getSpecification());
            ArrayList<GoodsSpecification> goodsSpecifications = new ArrayList<>();
            goodsSpecifications.add(goodsSpecification);
            specificationItem.setValueList(goodsSpecifications);
            specificationItemList.add(specificationItem);
        }

        goodsDetail.setAttributeList(goodsAttribute);
        goodsDetail.setBrand(brand);
        goodsDetail.setComment(comment);
        goodsDetail.setGroupon(grouponList);
        goodsDetail.setInfo(goods);
        goodsDetail.setIssue(issue);
        goodsDetail.setProductList(productList);
        goodsDetail.setSpecificationList(specificationItemList);
        goodsDetail.setUserHasCollect(10);
        return goodsDetail;
    }

    @Override
    public GoodsList queryRelatedGoods(int goodsId) {
        GoodsList goodsList = new GoodsList();
        Goods goods = goodsMapper.getGoodsById(goodsId);
        int categoryId = goods.getCategoryId();
        List<Goods> goodsList1 = goodsMapper.queryGoodsByCondition(categoryId,null);
        goodsList1.removeIf(goods1 -> goods1.getId() == goodsId);
        return goodsList;
    }
}
