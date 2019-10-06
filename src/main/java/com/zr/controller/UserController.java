package com.zr.controller;

import com.sun.deploy.net.HttpResponse;
import com.zr.pojo.LoginClassVo;
import com.zr.pojo.UserClassAddVo;
import com.zr.service.UserService;
import com.zr.util.ResultBuildVo;
import com.zr.util.ResultVo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenshuai on 2019/9/3.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("register")
    public ResultVo register(@RequestBody @Valid UserClassAddVo userClassAddVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return userService.register(userClassAddVo);
    }

    @GetMapping("getVerificationCode")
    public ResultVo getVerificationCode(String iphone) {
        String value = "1234";
        redisTemplate.opsForValue().set(iphone, value);
        redisTemplate.expire(iphone, 60 * 5, TimeUnit.SECONDS);
        return ResultBuildVo.success("1234");
    }

    @PostMapping("login")
    public ResultVo login(@RequestBody @Valid LoginClassVo loginClassVo, HttpServletResponse response, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return userService.login(loginClassVo,response);
    }

    @GetMapping("inputInvitationCode")
    public ResultVo inputInvitationCode(String inputInvitationCode, HttpServletRequest request,HttpServletResponse response){
        return userService.inputInvitationCode(inputInvitationCode,request,response);
    }
}
