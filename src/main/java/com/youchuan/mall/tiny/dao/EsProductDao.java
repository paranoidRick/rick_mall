package com.youchuan.mall.tiny.dao;

import com.youchuan.mall.tiny.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 搜索系统中的商品管理自定义Dao
 * Created by youchuan on 2018/6/19.
 */
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
