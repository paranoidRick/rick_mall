package com.youchuan.mall.tiny.service;


import com.youchuan.mall.tiny.mbg.model.PmsBrand;

import java.util.List;

/**
 * PmsBrandService
 * Created by macro on 2019/4/19.
 */
public interface PmsBrandService {
    // 列出所有的品牌
    List<PmsBrand> listAllBrand();

    // 创建新品牌
    int createBrand(PmsBrand brand);

    // 更新品牌
    int updateBrand(Long id, PmsBrand brand);

    // 删除品牌
    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
