package com.go.together.Mapper;

import com.go.together.Dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Slf4j
public class UserMapperTest {


    @Autowired
  private UserMapper userMapper;
    private UserDto userDto;

    @BeforeEach
    void setup(){
        userDto =new UserDto();
        userDto.setUserId("gg");
        userDto.setUserPassword("1234");
        userDto.setUserEmail("hi@naver.com");
        userDto.setUserPhoneNumber("111111111111");

    }

    @Test
    void insert() {
        userMapper.insert(userDto);
        assertThat(userMapper.selectUserNumber(userDto.getUserId(),userDto.getUserPassword()))
                .isEqualTo(userDto.getUserNumber());
    }

    @Test
    void selectUserNumber() {
        userMapper.selectUserNumber("gg","1234");
    }
}