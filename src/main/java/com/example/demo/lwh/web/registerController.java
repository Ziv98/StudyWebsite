package com.example.demo.lwh.web;

import com.example.demo.lwh.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class registerController {
//    @Autowired
//    UserService userService;
//    @PostMapping("register")
//    String register(@RequestBody String jsonstr){
//        JSONObject jsonObject=new JSONObject(jsonstr);
//
//        String username=jsonObject.getString("username");
//        String password=jsonObject.getString("password");
//
//        boolean flag=userService.register(username,password);
//        if(flag)
//            return "ok";
//        return "no";
//    }
}
