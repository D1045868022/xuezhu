package com.zr.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by chenshuai on 2019/9/3.
 */
@Data
public class MyDwellClassVo {
    @NotBlank(message = "详细地址不能为空")
    private String detailedAddress;
    @NotNull(message = "居住状态不能为空")
    private Integer liveStatus;
    @NotNull(message = "居住年限不能为空")
    private Integer liveYear;
    @NotNull(message = "婚姻状况不能为空")
    private Integer maritalStatus;
    @NotBlank(message = "现住址不能为空")
    private String province;
    private String maritalStatusName;
    private String liveStatusName;
    private String liveYearName;
}
