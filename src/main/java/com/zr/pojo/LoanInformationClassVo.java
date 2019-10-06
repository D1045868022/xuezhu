package com.zr.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Created by chenshuai on 2019/9/3.
 */
@Data
public class LoanInformationClassVo {
    private Integer id;
    private String phone;
    private String name;
    private String idCode;
    private String qqCode;
    private Integer maritalStatus;
    private Integer liveStatus;
    private Integer liveYear;
    private String province;
    private String city;
    private String area;
    private String detailedAddress;
    private Integer occupation;
    private Integer education;
    private String graduationSchool;
    private String major;
    private Date graduationYear;
    private String familyContacts;
    private Integer relationsWithMe;
    private String contactTelephone;
    private String commonFamilyContacts;
    private Integer commonRelationsWithMe;
    private String commonPhone;
    private String idPositive;
    private String idOtherSide;
    private String phoneIdPicture;
    private String videoAuthentication;
    private String trainingContract;
    private String diploma;
    private Integer myCourse;
    private Integer amountSettlements;
    private Integer paymentCycle;
    private Date classHours;
    private Integer payOffStatus;
    private String bankCardAccount;
    private Integer openingBank;
    private String bankPhone;
    private String verificationCode;
    private String invitationCode;
    private Date createTime;
    private Date updateTime;
    private Integer userId;
}
