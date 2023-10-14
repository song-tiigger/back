package com.go.together.Service;

import com.go.together.Dto.UserDto;
import com.go.together.Mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    //회원 등록
    public void register(UserDto userDto) {
        if (userDto == null) {
            throw new IllegalArgumentException("회원정보누락!");
        }
        userMapper.insert(userDto);

    }

    /**
     * @param userId
     * @param userPassword
     * @return
     * @throws IllegalArgumentException 존재하지 않는 회원 id,pw로 조회하는 경우
     */

    //회원 번호 조회하기 (아이디.패스워드)
    @Transactional(readOnly = true)
    public Long findUserNumber(String userId, String userPassword) {
        if (userId == null || userPassword == null) {
            throw new IllegalArgumentException("아이디 패스워드 누락");
        }


        return Optional.ofNullable(userMapper.selectUserNumber(userId, userPassword))
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 회원입니다.");
                });
    }

    public String searchUserId(String userName, String userPhoneNumber) {
        if (userName == null || userPhoneNumber == null) {
            throw new IllegalArgumentException("이름 ,핸드폰번호 누락");
        }
        return Optional.ofNullable(userMapper.findUserId(userName, userPhoneNumber))
                .orElseThrow(() -> new IllegalArgumentException("없는 이름 번호"));
    }

    public String searchUserPassword(String userId,String userName, String userPhoneNumber){
        if(userId ==null || userName ==null ||userPhoneNumber==null){
            throw new IllegalArgumentException("아이디 , 이름 ,핸드폰번호 누락");

        }
        return Optional.ofNullable(userMapper.findUserPassword(userId, userName, userPhoneNumber))
                .orElseThrow(()->new IllegalArgumentException("비밀번호를 변경하기위해 일치하는 회원정보가 없습니다."));
    }

    public void modify(UserDto userDto) {
        if (userDto == null) {
            throw new IllegalArgumentException("수정할 회원정보 누락");
        }
        userMapper.update(userDto);

    }

}




