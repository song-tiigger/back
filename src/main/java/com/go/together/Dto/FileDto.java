package com.go.together.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class FileDto {
    private Long FileNumber;
    private String fileName;
    private String fileUploadPath;
    private String fileUuid;
    private Long productNumber;
}
