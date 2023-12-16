package com.go.together.Controller;


import com.go.together.Service.CartService;
import com.go.together.Service.FileService;
import com.go.together.Vo.CartVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor


public class CartController {
    private final CartService cartService;
    private final FileService fileService;



@PostMapping("/addCart")
    public int addCart( @RequestBody CartVo cartVo){
    int result =cartService.registerCart(cartVo);
    return result;
}

@PostMapping("/userCart")
    public List<CartVo> userCart(@RequestBody CartVo cartvo){
    Integer userNumber=cartvo.getUserNumber();

    List<CartVo> userCartInfo = cartService.userCartList(userNumber);
    return userCartInfo;

}

    @PostMapping("/plusCount")
    public int plusCount(@RequestBody CartVo cartVo) {
    Long cartNumber=cartVo.getCartNumber() ;
    int result=cartService.upCount(cartNumber);
    return result;
    }

    @PostMapping("/changeCount")
    public int changeCount(@RequestBody CartVo cartVo){
        int result=cartService.updateCount(cartVo);
        return result;
    }




}