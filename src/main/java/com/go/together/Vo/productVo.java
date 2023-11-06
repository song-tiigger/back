package com.go.together.Vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Component

public class productVo {
    private Long productNumber;
    private Long categoryMinorCode;
    private String productName;
    private String productColor;
    private Double productPrice;
    private Double discountRate; // 추가: 할인율
    private Double discountPrice; // 추가: 할인가
    private String productExplanation;
    private int productQuantity;
    private String productSize;
    private String productRegisterDate;


    private  Long userNumber;
    private String userId;
    private String fileName;
    private String fileUploadPath;
    private String fileUuid;
}
