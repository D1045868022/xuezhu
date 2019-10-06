package com.zr.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by chenshuai on 2019/9/3.
 */
@Data
public class UserClassAddVo {
    private String userName;
    @NotNull(message = "密码不能为空")
    private String userPwd;
    @NotNull(message = "密码不能为空")
    private String confirmPwd;
    @NotNull(message = "手机号不能为空")
    private String iphone;
    @NotNull(message = "验证码不能为空")
    private String verificationCode;
}
