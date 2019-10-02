package com.j4h.mall.mapper.mall;

import com.j4h.mall.model.mall.brand.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    List<Brand> brandList(@Param("id") Integer id,@Param("name") String name);

    int brandCreate(@Param("brand")Brand brand);

    Brand brandSearchById(@Param("id")int id);

    int brandUpdate(@Param("brand") Brand brand);

    int brandDelete(@Param("id") int id);
}
