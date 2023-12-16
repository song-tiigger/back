package com.go.together.Service;

import com.go.together.Mapper.CartMapper;
import com.go.together.Mapper.FileMapper;
import com.go.together.Mapper.ProductMapper;
import com.go.together.Vo.CartVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartMapper cartMapper;



    public int registerCart(CartVo cartVo){
        if(cartVo == null){
           throw new IllegalArgumentException("등록한 cart정보 x");
        }
        int res=cartMapper.insertCart(cartVo);





        return res;
    }

    public List<CartVo> userCartList(Integer userNumber){
        if(userNumber== null){
            throw new IllegalArgumentException("사용자 번호가없어요!");
        }
        return cartMapper.userCartList(userNumber);
    }

    public int upCount(Long cartNumber) {
        return cartMapper.addCart(cartNumber);
    }



    public int updateCount(CartVo cartVo) {
        return cartMapper.changeCartCount(cartVo);
    }




}
