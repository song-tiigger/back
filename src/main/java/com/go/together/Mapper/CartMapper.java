package com.go.together.Mapper;

import com.go.together.Vo.CartVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {

    //    장바구니 등록
    public int insertCart(CartVo cartVo);

    //   유저 넘버에 해당하는 장바구니 조회
    public List<CartVo> userCartList(int userNumber);

    //    장바구니 수량 증가
    public int addCart(CartVo cartVo);

    //    장바구니 수량 변경
    public int updateCartPlus(CartVo cartVo);

    //    장바구니 수량 감소
    public int minusCart(CartVo cartVo);

    //    장바구니 상품 삭제
    public int deleteCart(Long cartNumber);


}
