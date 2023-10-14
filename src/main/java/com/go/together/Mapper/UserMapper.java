package com.go.together.Mapper;

import com.go.together.Dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    //유저 회원가입
    public void insert(UserDto userDto);

    //유저 로그인
    public Long selectUserNumber(@Param("userId")String userId , @Param("userPassword")String userPassword);

    //아이디찾기
    public String findUserId(@Param("userName")String userName, @Param("userPhoneNumber") String userPhoneNumber);

    //비밀번호 찾기
    public String findUserPassword(@Param("userId")String userId,@Param("userName")String userName, @Param("userPhoneNumber") String userPhoneNumber);

    //회원 업데이트
    public void update(UserDto userDto);
}
