package com.wddlhyss.community.controller;

import com.wddlhyss.community.model.User;
import com.wddlhyss.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String hello(HttpServletRequest request){
       Cookie[] cookies = request.getCookies();
       for (Cookie cookie:cookies){
           if(cookie.getName().equals("token")){
               String token = cookie.getValue();
               User user = userService.findByToken(token);
               if(user!=null){
                   request.getSession().setAttribute("user",user);
               }
               break;
           }
       }
        return "index";
    }
}
