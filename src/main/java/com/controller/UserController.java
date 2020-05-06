package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/showAllUser")
    public ModelAndView doLogin(){
        ModelAndView model = new ModelAndView();
        if(null != userService.showAllUser()){
            model.addObject("userList",userService.showAllUser());
            model.setViewName("index");
        }else{
            model.setViewName("error");
        }
        return model;
    }

    @PostMapping("/update22")
    public String update(User user,HttpServletResponse response) throws IOException {
        int num = userService.updateUser(user);
        System.out.print("userId:" + user.getId());
        if(num > 0){
            response.sendRedirect("/showAllUser");
            return "redirect:/showAllUser";
        }
        return "error";
    }

    @GetMapping("delete")
    public String delete(int id,HttpServletResponse response) throws IOException {
        int num = userService.deleteUser(id);
        if(num > 0){
            response.sendRedirect("/showAllUser");
            return "redirect:/showAllUser";
        }
        return "error";
    }

    @GetMapping("selectById")
    public ModelAndView selectById(int id){
        User user = userService.selectById(id);
        ModelAndView model = new ModelAndView();
        if(null != user){
            model.addObject("user",user);
            model.setViewName("update");
        }else{
            model.setViewName("error");
        }
        return model;
    }
}
