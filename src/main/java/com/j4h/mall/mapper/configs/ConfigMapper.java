package com.j4h.mall.mapper.configs;

import com.j4h.mall.model.configs.MallSystemExpressMsg;
import com.j4h.mall.model.configs.MallSystemMsg;
import com.j4h.mall.model.configs.MallSystemOrderMsg;
import com.j4h.mall.model.configs.MallSystemWxMsg;
import org.apache.ibatis.annotations.Param;

public interface ConfigMapper {

    String getMallSystemName();

    String getMallSystemAddress();

    String getMallSystemPhone();

    String getMallSystemQQ();

    int updateMallSystemName(@Param("mallSystemMsg") MallSystemMsg mallSystemMsg);

    int updateMallSystemAddress(@Param("mallSystemMsg") MallSystemMsg mallSystemMsg);

    int updateMallSystemPhone(@Param("mallSystemMsg") MallSystemMsg mallSystemMsg);

    int updateMallSystemQQ(@Param("mallSystemMsg") MallSystemMsg mallSystemMsg);

    String getMallSystemExpressFreightMin();

    String getMallSystemExpressFreightValue();

    int updateMallSystemExpressFreightMin(@Param("mallSystemExpressMsg") MallSystemExpressMsg mallSystemExpressMsg);

    int updateMallSystemExpressFreightValue(@Param("mallSystemExpressMsg") MallSystemExpressMsg mallSystemExpressMsg);

    String getMallSystemOrderComment();

    String getMallSystemOrderUnconfirm();

    String getMallSystemOrderUnpaid();

    int updateMallSystemOrderComment(@Param("mallSystemOrderMsg") MallSystemOrderMsg mallSystemOrderMsg);

    int updateMallSystemOrderUnconfirm(@Param("mallSystemOrderMsg") MallSystemOrderMsg mallSystemOrderMsg);

    int updateMallSystemOrderUnpaid(@Param("mallSystemOrderMsg") MallSystemOrderMsg mallSystemOrderMsg);

    String getMallSystemWxCatlogGoods();

    String getMallSystemWxCatlogList();

    String getMallSystemWxIndexBrand();

    String getMallSystemWxIndexHot();

    String getMallSystemWxIndexNew();

    String getMallSystemWxIndexTopic();

    String getMallSystemWxShare();

    int updateMallSystemWxCatlogGoods(@Param("mallSystemWxMsg") MallSystemWxMsg mallSystemWxMsg);

    int updateMallSystemWxCatlogList(@Param("mallSystemWxMsg") MallSystemWxMsg mallSystemWxMsg);

    int updateMallSystemWxIndexBrand(@Param("mallSystemWxMsg") MallSystemWxMsg mallSystemWxMsg);

    int updateMallSystemWxIndexHot(@Param("mallSystemWxMsg") MallSystemWxMsg mallSystemWxMsg);

    int updateMallSystemWxIndexNew(@Param("mallSystemWxMsg") MallSystemWxMsg mallSystemWxMsg);

    int updateMallSystemWxIndexTopic(@Param("mallSystemWxMsg") MallSystemWxMsg mallSystemWxMsg);

    int updateMallSystemWxShare(@Param("mallSystemWxMsg") MallSystemWxMsg mallSystemWxMsg);
}
