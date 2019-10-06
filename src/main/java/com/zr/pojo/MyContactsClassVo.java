package com.zr.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by chenshuai on 2019/9/3.
 */
@Data
public class MyContactsClassVo {
    @NotBlank(message = "常用联系人名称不能为空")
    private String commonFamilyContacts;
    @NotBlank(message = "常用联系人手机号不能为空")
    private String commonPhone;
    @NotNull(message = "常用联系人不能为空")
    private Integer commonRelationsWithMe;
    @NotBlank(message = "家庭联系人名称不能为空")
    private String familyContacts;
    @NotNull(message = "家庭联系人不能为空")
    private Integer relationsWithMe;
    @NotBlank(message = "家庭联系人手机号不能为空")
    private String contactTelephone;

    private String relationsWithMeName;
    private String commonRelationsWithMeName;
}
