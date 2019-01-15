package com.example.demo.contoller;

import com.example.demo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/user")
public class UserContoller {

    @RequestMapping("/getUser")
    @ResponseBody
    public  Object getUser() {
        User user = new User();
        user.setName("Name xiaom");
        user.setAge("19");
        user.setPassword("123");
        user.setDesc("xxx");
        return user;
    }
}
