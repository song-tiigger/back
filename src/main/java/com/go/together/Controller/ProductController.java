
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
import java.util.Map;

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


//@PostMapping("/productDelete")
//public List<Integer> productDelete(@RequestBody List<Long> productNumbers) {
//        List<Integer> results = new ArrayList<>();
//
//
//
////    for(int i = 0; i < productNumbers.size(); i++){
////        Long productNumber = productNumbers.get(i); 아래와 같은거임.,
//        for(Long productNumber : productNumbers){
//            int result = productService.remove(productNumber);
//            results.add(result);
//        }
//        System.out.println(results+ " 1이 나오면 성공 ");
//        return results;
//}

    @PostMapping("/productDelete")
    public List<Integer> productDelete(@RequestBody Map<String, List<Long>> Array) {
        List<Long> productNumbers = Array.get("productNumber");
        List<Integer> results = new ArrayList<>();

        for(Long productNumber : productNumbers){
            int result = productService.remove(productNumber);
            results.add(result);
        }

        System.out.println(results + " 1이 나오면 성공 ");
        return results;
    }
    /*
    Map<String, List<Long>>에서 String은 Map의 키(key)의 데이터 타입을 나타냅니다.
    이 경우, 클라이언트에서 보내는 JSON 데이터가 { "productNumbers": [/상품 번호 배열 ] } 형태이므로, 키는 "productNumbers"라는 문자열입니다.

    List<Long>은 Map의 값(value)의 데이터 타입을 나타냅니다. 여기서는 상품 번호의 배열을 나타내므로 Long 타입의 리스트입니다.

    따라서 Map<String, List<Long>>은 "문자열을 키로 하고, Long 타입의 리스트를 값으로 하는 Map"을 의미합니다.
    이 Map에서 "productNumbers"라는 키로 상품 번호의 리스트를 가져올 수 있습니다.

    그리고 Java에서는 정수형 데이터를 표현할 때 int와 long 두 가지 타입을 주로 사용합니다. `
*/


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








