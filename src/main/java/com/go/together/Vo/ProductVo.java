package com.go.together.Vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Data
@Slf4j
@NoArgsConstructor
public class ProductVo {
    private Long productNumber;
    private int userNumber;
    private Long categoryMajorCode;
    private Long categoryMinorCode;
    private String productName;
    private Double productPrice;
    private Double discountRate; // 추가: 할인율
    private Double discountPrice; // 추가: 할인가
    private String productExplanation;
    private String productExplanation1;
    private String productExplanation2;
    private int productQuantity;
    private List<String> productSizes;
    private List<String> productColors;
    private Date productRegisterDate;
    private String userId;
    private String fileName;
    private String fileUploadPath;
    private String fileUuid;

}
