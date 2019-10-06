package com.zr.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by chenshuai on 2019/9/3.
 */
@Data
public class MyBankClassVo {
    @NotBlank(message = "银行卡号不能为空")
    private String bankCardAccount;
    @NotBlank(message = "手机号不能为空")
    private String bankPhone;
    @NotNull(message = "开户行不能为空")
    private Integer openingBank;
    @NotBlank(message = "验证码不能为空")
    private String verificationCode;
    private String openingBankName;
}
