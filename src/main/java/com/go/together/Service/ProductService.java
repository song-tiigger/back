
package com.go.together.Service;

import com.go.together.Dto.ProductDto;
import com.go.together.Dto.UserDto;
import com.go.together.Mapper.ProductMapper;
import com.go.together.Mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;

    public int registerProduct(ProductDto productDto){
        if(productDto == null){
            throw new IllegalArgumentException("정보가 없습니다");
        }
        System.out.println("상품 등록완료!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return productMapper.insertProduct(productDto);
    }



    public ProductDto findOneProduct(Long productNumber){
        if(productNumber == null){
            throw new IllegalArgumentException("상품게시글 번호가 없습니다");
        }
        return productMapper.selectProduct(productNumber);
    }



    public List<ProductDto> findAllProduct(ProductDto productDto){
        if(productDto == null){
            throw new IllegalArgumentException("정보가 없습니다");
        }
        return productMapper.selectAllProduct();
    }


}
