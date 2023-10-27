package com.go.together.Dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Data
@Slf4j
@NoArgsConstructor
public class UserDto{
    private Long userNumber;
    private String userName;
    private String userId;
    private String userPassword;
    private String userEmail;
    private String userAddressNumber;
    private String userAddress1;
    private String userAddress2;
    private String userAddress3;
    private String userPhoneNumber;
}
