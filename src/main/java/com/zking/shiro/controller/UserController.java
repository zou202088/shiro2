package com.zking.shiro.controller;

import com.zking.shiro.model.User;
import com.zking.shiro.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/")
    public String toLong(User user) {

        return "login";
    }


    @RequestMapping("/dologin")
    public String doLog(Model model, User user) {
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(
                user.getUsername(),
                user.getPassword()
        );

        String msg = "";
        boolean f = true;
        try {
            subject.login(token);

        } catch (IncorrectCredentialsException e) {
            msg = "密码错误";
            f = false;
        } catch (RuntimeException e) {
           msg="账号不存在";
           f=false;
        }
        model.addAttribute("msg", msg);
        if (f) {
            return "main";
        } else {
            return "login";
        }


    }
    @RequestMapping("/gj")
    @RequiresRoles("高级用户")
    public String gj(){

        return "gaoji";
    }


}
