package com.go.together.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class CartDto {

    private long cartNumber;
    private long userNumber;
    private long productNumber;
    private int cartCount;

}
