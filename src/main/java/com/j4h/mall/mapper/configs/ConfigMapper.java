package com.j4h.mall.mapper.configs;

import com.j4h.mall.model.configs.MallSystemMsg;
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

    int updateMallSystemExpressFreightMin(@Param("mallSystemMsg") MallSystemMsg mallSystemMsg);

    int updateMallSystemExpressFreightValue(@Param("mallSystemMsg") MallSystemMsg mallSystemMsg);

    String getMallSystemOrderComment();

    String getMallSystemOrderUnconfirm();

    String getMallSystemOrderUnpaid();

    int updateMallSystemOrderComment(@Param("mallSystemMsg") MallSystemMsg mallSystemMsg);

    int updateMallSystemOrderUnconfirm(@Param("mallSystemMsg") MallSystemMsg mallSystemMsg);

    int updateMallSystemOrderUnpaid(@Param("mallSystemMsg") MallSystemMsg mallSystemMsg);

    String getMallSystemWxCatlogGoods();

    String getMallSystemWxCatlogList();

    String getMallSystemWxIndexBrand();

    String getMallSystemWxIndexHot();

    String getMallSystemWxIndexNew();

    String getMallSystemWxIndexTopic();

    String getMallSystemWxShare();

    int updateMallSystemWxCatlogGoods(@Param("mallSystemMsg") MallSystemMsg mallSystemMsg);

    int updateMallSystemWxCatlogList(@Param("mallSystemMsg") MallSystemMsg mallSystemMsg);

    int updateMallSystemWxIndexBrand(@Param("mallSystemMsg") MallSystemMsg mallSystemMsg);

    int updateMallSystemWxIndexHot(@Param("mallSystemMsg") MallSystemMsg mallSystemMsg);

    int updateMallSystemWxIndexNew(@Param("mallSystemMsg") MallSystemMsg mallSystemMsg);

    int updateMallSystemWxIndexTopic(@Param("mallSystemMsg") MallSystemMsg mallSystemMsg);

    int updateMallSystemWxShare(@Param("mallSystemMsg") MallSystemMsg mallSystemMsg);
}
