package com.example.demo.lwh.web;

import com.example.demo.lwh.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class indexController {
    @Autowired
    UserService userService;

    @Autowired
    @ResponseBody
    @RequestMapping("login")
    String login(@RequestBody String jsonstr, HttpSession session, HttpServletResponse response) {
        try {
            System.out.println("123");
            JSONObject jsonObject=new JSONObject(jsonstr);

            String username=jsonObject.getString("username");
            String password=jsonObject.getString("password");

            System.out.println(username);
            System.out.println(password);
            boolean isok = userService.login(username, password);
            System.out.println("1234");
            if (isok) {
                String usersession = (String) session.getAttribute("user");
                if (usersession == null || !usersession.equals(username)) {
                    session.setAttribute("username", username);
                    System.out.println(username);
                }
                return "ok";
            }
            System.out.println(isok);
            return "fail";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}