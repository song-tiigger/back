package com.go.together.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@Slf4j
@NoArgsConstructor
public class ProductDto {
    private Long productNumber;
    private Long categoryMajorCode;
    private Long categoryMinorCode;
    private String productName;
    private String productColor;
    private Double productPrice;
    private Double discountRate; // 추가: 할인율
//    private Double discountPrice; // 추가: 할인가
    private String productExplanation;
    private int productQuantity;
    private String productSize;
   private Date productRegisterDate;
    private String userId;
}
