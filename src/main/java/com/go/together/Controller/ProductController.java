package com.go.together.Controller;

import com.go.together.Dto.FileDto;
import com.go.together.Dto.ProductDto;
import com.go.together.Service.ProductService;
import com.go.together.Vo.ProductVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//@Controller
//@Controller는 전통적인 Spring MVC 컨트롤러를 정의하는 어노테이션입니다.
//        주로 HTML을 반환하는 웹 페이지를 만들 때 사용합니다.
//        메서드가 반환하는 값은 기본적으로 View 이름을 나타냅니다. 예를 들어, "home"을 반환하면
//        home.jsp와 같은 View를 찾아서 클라이언트에게 전송합니다.
//        만약 메서드가 데이터 자체를 응답 본문(Body)으로 보내야 한다면, 해당 메서드나 반환 값에 추가로
//@ResponseBody 어노테이션을 붙여야 합니다.
//@RestController
//@RestController는 RESTful 웹 서비스 컨트롤러를 정의하는 어노테이션입니다.
//        JSON, XML 등의 데이터 자체를 반환할 때 주로 사용합니다.
//        내부적으로 @Controller와 @ResponseBody 어노테이션이 결합된 형태입니다. 따라서 메서드가 반환하는 값은 HTTP 응답 본문(Body)
//        그 자체로 간주됩니다. 예를 들어, 객체를 반환하면 해당 객체가 JSON 형태로 변환되어 응답 본문에 포함됩니다.

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/registerProduct")
    public int registerFile(@RequestBody ProductDto productDto){
        int result = productService.registerProduct(productDto);
        System.out.println("상품등록완료!");
        return result;
    }




    @PostMapping("/fileList")
    public List<ProductVo> fileList(@RequestBody ProductVo productVo) {
        String userId = productVo.getUserId();
        if (!"admin".equals(userId)) {
            throw new IllegalArgumentException("admin 아이디가 없습니다");
        }

        // 원하는 로직을 추가하여 productVo를 처리할 수 있습니다.
        // productService를 호출하여 필요한 비즈니스 로직을 수행하고,
        // 결과를 List<ProductVo> 형태로 반환합니다.
        List<ProductVo> productVoList = productService.findAllProduct(productVo);

        return productVoList;
    }
}










