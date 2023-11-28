package com.go.together.Mapper;

import com.go.together.Dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    public int insertProduct(ProductDto productDto);

    public ProductDto selectProduct(Long productNumber);

    public List<ProductDto> selectAllProduct();

    public int delete(Long productNumber);

    public void update(ProductDto productDto);


}
