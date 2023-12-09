
package com.go.together.Controller;

import com.go.together.Dto.ProductDto;
import com.go.together.Service.FileService;
import com.go.together.Service.ProductService;
import com.go.together.Vo.ProductVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor



public class ProductController {
    private final ProductService productService;
    private final FileService fileService;

    @PostMapping("/registerProduct")
    public int registerProduct(ProductDto productDto, @RequestPart("productFile") List<MultipartFile> files) {
        int result = productService.registerProduct(productDto);
        System.out.println(productDto + "상품 입력 값 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        if (files != null) {
            try {
                fileService.registerAndSaveFiles(files, productDto.getProductNumber());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    @PostMapping("/fileList")
    public List<ProductVo> fileList(@RequestBody ProductVo productVo) {
        Integer userNumber = productVo.getUserNumber();
        if (userNumber == null) {
            throw new IllegalArgumentException("유저아이디가 없습니다");
        }
//        String userId = productDto.getUserId();
//        System.out.println("아이디 받아오는지 !!@@@@@@@@@@@@@@@@@!!"+userId);
//        if (!"admin".equals(userId)) {
//            throw new IllegalArgumentException("admin 아이디가 없습니다");
//        }

        // 원하는 로직을 추가하여 productVo를 처리할 수 있습니다.
        // productService를 호출하여 필요한 비즈니스 로직을 수행하고,
        // 결과를 List<ProductVo> 형태로 반환합니다.
        System.out.println("유저번호 !!!!!!!" + userNumber);
        List<ProductVo> productVoList = productService.findAllProduct(productVo);
        return productVoList;
    }


    @PostMapping("/productView")
    public List<ProductVo> productView(@RequestBody ProductVo productVo){
        Long productNumber = productVo.getProductNumber();


        List<ProductVo> result =productService.findOneProduct(productNumber);
        System.out.println(productNumber + "상품 번호확인 !!!");

        return result;

    }



    @GetMapping("/productDelete")
    public int productDelete(@RequestParam Long productNumber) {


        int result = productService.remove(productNumber);
        System.out.println(result + "1이 나오면 성공");
        return result;
    }


@PostMapping("/productDelete")
public List<Integer> productDelete(@RequestParam(value = "productNumber", required = false) List<Long> productNumbers) {
    List<Integer> results = new ArrayList<>();

    for(Long productNumber : productNumbers){
        int result = productService.remove(productNumber);
        results.add(result);
    }
    System.out.println(results+ " 1이 나오면 성공 ");
    return results;
}


    @PostMapping("/productUpdate")
    public int productUpdate(ProductDto productDto, @RequestPart("productFile") List<MultipartFile> files) {
        Long productNumber=productDto.getProductNumber();
        if (productNumber == null) {
            throw new IllegalArgumentException("유저번호가 x");
        }
        try {
            productService.modify(productDto , files);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }




    
    
    


}








