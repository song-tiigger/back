package com.go.together.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CategoryMajorDto {
    private Long categoryMajorCode;
    private String categoryName;
}
