package com.zr.service.impl;

import com.zr.mapper.UserMapper;
import com.zr.pojo.LoanInformationClassVo;
import com.zr.pojo.LoginClassVo;
import com.zr.pojo.UserClassAddVo;
import com.zr.pojo.UserClassVo;
import com.zr.service.UserService;
import com.zr.util.ErrorUtil;
import com.zr.util.ResultBuildVo;
import com.zr.util.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chenshuai on 2019/9/3.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public ResultVo register(UserClassAddVo userClassAddVo) {
        List<String> phoneList = userMapper.queryPhone(userClassAddVo.getIphone());
        if (!CollectionUtils.isEmpty(phoneList)){
            return ResultBuildVo.error(ErrorUtil.YANZHENGSHOUJIHAO);
        }
        String key = userClassAddVo.getIphone();
        String value = (String)redisTemplate.opsForValue().get(key);
        String verificationCode = userClassAddVo.getVerificationCode();
        if (value=="" || value == null){
            return ResultBuildVo.error(ErrorUtil.YANZHENGSMACUNZAI);
        }
        if (!verificationCode.equals(value)){
            return ResultBuildVo.error(ErrorUtil.YANZHENGSMACUWU);
        }
        Date date = new Date();
        UserClassVo userClassVo = new UserClassVo();
        BeanUtils.copyProperties(userClassAddVo,userClassVo);
        userClassVo.setUserName("小明");
        userClassVo.setCreateTime(date);
        userClassVo.setUpdateTime(date);
        userMapper.register(userClassVo);
        return ResultBuildVo.success(userClassVo);
    }

    @Override
    public ResultVo login(LoginClassVo loginClassVo, HttpServletResponse response) {
        List<String> phoneList = userMapper.queryPhone(loginClassVo.getIphone());
        if (CollectionUtils.isEmpty(phoneList)){
            return ResultBuildVo.error(ErrorUtil.YANZHENGSHOUJIHAO2);
        }
        UserClassVo userClassVo = userMapper.queryUser(loginClassVo);
        if (userClassVo == null){
            return ResultBuildVo.error(ErrorUtil.MIMACUOWU);
        }
        String key = "userId"+userClassVo.getId();
        redisTemplate.opsForValue().set(key,userClassVo);
        Cookie cookie = new Cookie("sessionId",key);
        response.addCookie(cookie);

        LoanInformationClassVo loanInformationClassVo = userMapper.queryLoan(userClassVo.getId());
        if (loanInformationClassVo != null){
            String key1 = "loan" + loanInformationClassVo.getId();
            redisTemplate.opsForValue().set(key1,loanInformationClassVo);
            Cookie cookie1 = new Cookie("loanId",key1);
            response.addCookie(cookie1);
        }
        return ResultBuildVo.success(userClassVo);
    }

    @Override
    public ResultVo inputInvitationCode(String inputInvitationCode, HttpServletRequest request,HttpServletResponse response) {

        LoanInformationClassVo loanInformationClassVo = new LoanInformationClassVo();
        String key = "";
        String loanId = "";
        Date date = new Date();
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals("sessionId")){
                    key = cookie.getValue();
                }
                if (cookie.getName().equals("loanId")){
                    loanId = cookie.getValue();
                }
            }
        }
        if (loanId == null || "".equals(loanId)){
            UserClassVo userClassVo = (UserClassVo)redisTemplate.opsForValue().get(key);
            loanInformationClassVo.setUserId(userClassVo.getId());
            loanInformationClassVo.setPayOffStatus(0);
            loanInformationClassVo.setCreateTime(date);
            loanInformationClassVo.setUpdateTime(date);
            loanInformationClassVo.setInvitationCode(inputInvitationCode);
            userMapper.inputInvitationCode(loanInformationClassVo);
            String key1 = "loan"+loanInformationClassVo.getId();
            redisTemplate.opsForValue().set(key1,loanInformationClassVo);
            Cookie cookie = new Cookie("loanId",key1);
            response.addCookie(cookie);
        }
        return ResultBuildVo.success(loanInformationClassVo);
    }
}
