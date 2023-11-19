package com.go.together.Mapper;

import com.go.together.Dto.ProductDto;
import com.go.together.Vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    public int insertProduct(ProductDto productDto);

    public ProductDto selectProduct(Long productBoardNumber);

    public List<ProductVo> selectAllProduct();

}
