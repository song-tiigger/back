package com.go.together.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor

public class ProductDto {
    private Long productNumber;
    private Long categoryMinorCode;
    private String productName;
    private Double productPrice;
    private Double discountRate; // 추가: 할인율
    private Double discountPrice; // 추가: 할인가
    private String productExplanation;
    private int productQuantity;
    private String productSize;
    private String productRegisterDate;
}
