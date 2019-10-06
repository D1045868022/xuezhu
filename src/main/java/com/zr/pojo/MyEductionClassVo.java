package com.zr.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by chenshuai on 2019/9/3.
 */
@Data
public class MyEductionClassVo {
    @NotNull(message = "职业不能为空")
    private Integer occupation;
    @NotNull(message = "学历不能为空")
    private Integer education;
    @NotBlank(message = "毕业学校不能为空")
    private String graduationSchool;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "毕业年份不能为空")
    private Date graduationYear;
    @NotBlank(message = "专业不能为空")
    private String major;
    private String occupationName;
    private String educationName;
}
