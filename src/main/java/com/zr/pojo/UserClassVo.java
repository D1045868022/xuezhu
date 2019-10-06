package com.zr.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Created by chenshuai on 2019/9/3.
 */
@Data
public class UserClassVo {
    private Integer id;
    private String userName;
    private String userPwd;
    private String iphone;
    private String verificationCode;
    private Date createTime;
    private Date updateTime;
}
