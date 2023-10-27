package com.go.together.Mapper;

import com.go.together.Dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    //유저 회원가입
    public int insert(UserDto userDto);

    //아이디찾기
    public String findUserId(@Param("userName")String userName, @Param("userPhoneNumber") String userPhoneNumber);

    //비밀번호 찾기
    public String findUserPassword(@Param("userId")String userId,@Param("userName")String userName, @Param("userPhoneNumber") String userPhoneNumber);

    //회원 업데이트
    public void update(UserDto userDto);

    // 아이디로 회원 가져오기.
    public Long selectById(UserDto userDto);

    // 유저 번호로 회원정보 가져오기
    public UserDto selectByNo(long userNumber);
}
