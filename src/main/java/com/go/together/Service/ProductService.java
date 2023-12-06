
package com.go.together.Service;

import com.go.together.Dto.ProductDto;
import com.go.together.Dto.UserDto;
import com.go.together.Mapper.FileMapper;
import com.go.together.Mapper.ProductMapper;
import com.go.together.Mapper.UserMapper;
import com.go.together.Vo.ProductVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final FileService fileService;
    private final FileMapper fileMapper;


    public int registerProduct(ProductDto productDto){
        if(productDto == null){
            throw new IllegalArgumentException("정보가 없습니다");
        }
        System.out.println("상품 등록완료!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return productMapper.insertProduct(productDto);
    }



    public ProductVo findOneProduct(Long productNumber){
        if(productNumber == null){
            throw new IllegalArgumentException("상품게시글 번호가 없습니다");
        }
        return productMapper.selectProduct(productNumber);
    }



    public List<ProductVo> findAllProduct(ProductVo productVo){
        if(productVo == null){
            throw new IllegalArgumentException("정보가 없습니다");
        }
        return productMapper.selectAllProduct(productVo);
    }




//    상품 삭제

    public int remove(Long productNumber){
        if(productNumber ==null){
            throw new IllegalArgumentException("상품게시글 번호가가 없습니다");
        }
        fileMapper.delete(productNumber);
        return productMapper.delete(productNumber);
    }

// 상품 수정



public void modify (ProductDto productDto, List<MultipartFile> files) throws IOException {
    if(productDto == null || files ==null){
        throw new IllegalArgumentException("게시글 수정 매개변수 null 체크");
    }
    fileService.remove(productDto.getProductNumber());
    fileService.registerAndSaveFiles(files, productDto.getProductNumber());
    productMapper.updateProduct(productDto);
}

}
