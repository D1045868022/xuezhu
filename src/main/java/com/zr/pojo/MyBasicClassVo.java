package com.zr.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by chenshuai on 2019/9/3.
 */
@Data
public class MyBasicClassVo {
    @NotBlank(message = "身份证不能为空")
    private String idCode;
    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotBlank(message = "手机号不能为空")
    private String phone;
    @NotBlank(message = "QQ不能为空")
    private String qqCode;
}
