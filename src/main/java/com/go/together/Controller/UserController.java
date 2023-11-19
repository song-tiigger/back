package com.go.together.Controller;

import com.go.together.Dto.UserDto;
import com.go.together.Mapper.UserMapper;
import com.go.together.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


//@Controller
//@Controller는 전통적인 Spring MVC 컨트롤러를 정의하는 어노테이션입니다.
//        주로 HTML을 반환하는 웹 페이지를 만들 때 사용합니다.
//        메서드가 반환하는 값은 기본적으로 View 이름을 나타냅니다. 예를 들어, "home"을 반환하면
//        home.jsp와 같은 View를 찾아서 클라이언트에게 전송합니다.
//        만약 메서드가 데이터 자체를 응답 본문(Body)으로 보내야 한다면, 해당 메서드나 반환 값에 추가로
//@ResponseBody 어노테이션을 붙여야 합니다.
//@RestController
//@RestController는 RESTful 웹 서비스 컨트롤러를 정의하는 어노테이션입니다.
//        JSON, XML 등의 데이터 자체를 반환할 때 주로 사용합니다.
//        내부적으로 @Controller와 @ResponseBody 어노테이션이 결합된 형태입니다. 따라서 메서드가 반환하는 값은 HTTP 응답 본문(Body)
//        그 자체로 간주됩니다. 예를 들어, 객체를 반환하면 해당 객체가 JSON 형태로 변환되어 응답 본문에 포함됩니다.

@RestController
@RequiredArgsConstructor
//@RequestMapping("/user/*")
public class UserController {
    private final UserService userService;



    //회원가입이 정상적으로 되면 1반환 아니면 0

    @PostMapping("/join")
    public int userRegister(@RequestBody UserDto userDto) {
        int result = userService.register(userDto);
        System.out.println("회원가입이 완료되었습니다 ! ! ! ! !");
        return result;
    }



    //로그인 아이디에 따라 UserNumber 배정됨
    @PostMapping("/login")
    public UserDto login(@RequestBody UserDto userDto) {
        UserDto result = userService.findUserNumber(userDto);
//
//        // 세션 가져오기
//        HttpSession session = req.getSession();
//        // 세션에 userNumber 저장하기
//        session.setAttribute("userNumber", result.getUserNumber());

        System.out.println("로그인 성공 ! ! ! ! ! ! !");
        return result;
    }




    //아이디 찾기

    @PostMapping("/searchId")
    public String searchId(@RequestBody UserDto userDto) {
        String res =userService.searchUserId(userDto);

        return res;
    }

    //비밀번호찾기

    @PostMapping("/searchPw")
    public int searchPw(@RequestBody UserDto userDto){
        int res=userService.searchUserPassword(userDto);

        return res;
    }
    //아이디 중복확인

    @PostMapping("/checkId")
    public int checkId(@RequestBody  UserDto userDto){
        int res=userService.idCheck(userDto);
        return res;
    }


    // 비밀번호 수정 쿼리
    @PostMapping("/modifyPw")
    public int modifyMy(@RequestBody UserDto userDto) {
        Integer userNumber = userDto.getUserNumber();
        if (userNumber == null) {
            // userNumber가 null인 경우에 대한 처리
            throw new IllegalArgumentException("userNumber이 없습니다.");
        }
        int res = userService.modify(userDto);
        System.out.println("---------------------------!!!!!!!!!!!!");
        System.out.println(userDto);
        return res;
    }


   @PostMapping("/myPage")
   public UserDto myPage(@RequestBody UserDto userDto){
       Integer userNumber = userDto.getUserNumber();
       if (userNumber == null) {
           // userNumber가 null인 경우에 대한 처리
           throw new IllegalArgumentException("userNumber이 없습니다.");
       }

       UserDto res = userService.getUserList(userDto);
       return res; // UserDto를 반환
   }




}









//    @GetMapping("/logout")
//    public String logout(HttpServletRequest req){
//        req.getSession().invalidate();//세션초기화
//        return "user.login";
//    }
//}


