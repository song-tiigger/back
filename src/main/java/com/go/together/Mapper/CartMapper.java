package com.go.together.Mapper;

import com.go.together.Vo.CartVo;

import java.util.List;

public interface CartMapper {

    //    장바구니 등록
    public int insertCart(CartVo cartVo);

    //    장바구니 조회
    public List<CartVo> UserCart(CartVo cartVo);

    //    장바구니 수량 증가
    public int addCart(CartVo cartVo);

    //    장바구니 수량 변경
    public int updateCartPlus(CartVo cartVo);

    //    장바구니 수량 감소
    public int minusCart(CartVo cartVo);

    //    장바구니 상품 삭제
    public int deleteCart(Long cartNumber);


}
