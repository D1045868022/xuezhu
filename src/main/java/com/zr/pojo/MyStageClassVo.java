package com.zr.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by chenshuai on 2019/9/3.
 */
@Data
public class MyStageClassVo {
    @NotNull(message = "分期金额不能为空")
    private Integer amountSettlements;
    @NotNull(message = "我的课程不能为空")
    private Integer myCourse;
    @NotNull(message = "还款周期不能为空")
    private Integer paymentCycle;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "上课时间不能为空")
    private Date classHours;
    private String myCourseName;
    private String paymentCycleName;
}
