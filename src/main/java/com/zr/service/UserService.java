package com.zr.service;

import com.zr.pojo.LoginClassVo;
import com.zr.pojo.UserClassAddVo;
import com.zr.util.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by chenshuai on 2019/9/3.
 */
public interface UserService {
    ResultVo register(UserClassAddVo userClassAddVo);

    ResultVo login(LoginClassVo loginClassVo, HttpServletResponse response);

    ResultVo inputInvitationCode(String inputInvitationCode, HttpServletRequest request,HttpServletResponse response);
}
