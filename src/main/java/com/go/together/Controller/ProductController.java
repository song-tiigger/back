
package com.go.together.Controller;

import com.go.together.Dto.ProductDto;
import com.go.together.Service.FileService;
import com.go.together.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor



public class ProductController {
    private final ProductService productService;
    private final FileService fileService;

    @PostMapping("/registerProduct")
    public int registerProduct(@RequestBody ProductDto productDto, @RequestParam("productFile") List<MultipartFile> files) {

        //        String userId = productDto.getUserId();
//        if (!"admin".equals(userId)) {
//            throw new IllegalArgumentException("admin 아이디가 없습니다");
//        }

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
    public List<ProductDto> fileList(@RequestBody ProductDto productDto) {
        String userId = productDto.getUserId();
        if (!"admin".equals(userId)) {
            throw new IllegalArgumentException("admin 아이디가 없습니다");
        }

        // 원하는 로직을 추가하여 productVo를 처리할 수 있습니다.
        // productService를 호출하여 필요한 비즈니스 로직을 수행하고,
        // 결과를 List<ProductVo> 형태로 반환합니다.
        List<ProductDto> productVoList = productService.findAllProduct(productDto);
        System.out.println(productDto + "리스트값이 잘 들어오는지 !!!!!!!!!!!!!!");

        return productVoList;
    }

    @PostMapping("productDelete")
    public int productDelete(@RequestParam Long productNumber) {
        int result = productService.remove(productNumber);
        if(result != 1){
            throw new IllegalArgumentException("오류발생 !");
        }
        return result;
    }


}

