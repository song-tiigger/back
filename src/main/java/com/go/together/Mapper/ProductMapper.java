package com.go.together.Mapper;

import com.go.together.Dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    public int insert(ProductDto productDto);


}
