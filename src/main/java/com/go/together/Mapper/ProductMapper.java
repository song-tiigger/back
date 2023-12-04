package com.go.together.Mapper;

import com.go.together.Dto.ProductDto;
import com.go.together.Vo.CartVo;
import com.go.together.Vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

//    게시글 등록
    public int insertProduct(ProductDto productDto);

//    게시글 VIEW
    public ProductVo selectProduct(Long productNumber);

//    게시글 리스트
    public List<ProductVo> selectAllProduct();


    public int delete(Long productNumber);

    public void updateProduct(ProductDto productDto);

//    장바구니

//    장바구니 등록
    public int insertCart(CartVo cartVo);

//    장바구니 조회






}
