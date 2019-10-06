package com.zr.mapper;

import com.zr.pojo.LoanInformationClassVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by chenshuai on 2019/9/3.
 */
@Mapper
public interface LoanMapper {
    @Update("update user_loan_information set amountSettlements=#{amountSettlements},myCourse=#{myCourse}," +
            "paymentCycle=#{paymentCycle},classHours=#{classHours} where id=#{id}")
    void installmentApply(LoanInformationClassVo loanInformationClassVo);

    @Update("update user_loan_information set phone=#{phone},name=#{name},idCode=#{idCode},qqCode=#{qqCode}," +
            "updateTime=#{updateTime} where id=#{id}")
    void essentialInformation(LoanInformationClassVo loanInformationClassVo);

    @Select("select * from user_loan_information where id=#{id}")
    LoanInformationClassVo queryById(Integer id);

    @Update("update user_loan_information set maritalStatus=#{maritalStatus},liveStatus=#{liveStatus}," +
            "liveYear=#{liveYear},province=#{province},detailedAddress=#{detailedAddress} where id=#{id}")
    void userLive(LoanInformationClassVo loanInformationClassVo);

    @Update("update user_loan_information set occupation=#{occupation},education=#{education}," +
            "graduationSchool=#{graduationSchool},major=#{major},graduationYear=#{graduationYear} where id=#{id}")
    void education(LoanInformationClassVo loanInformationClassVo);

    @Update("update user_loan_information set familyContacts=#{familyContacts},relationsWithMe=#{relationsWithMe}," +
            "contactTelephone=#{contactTelephone},commonFamilyContacts=#{commonFamilyContacts}," +
            "commonRelationsWithMe=#{commonRelationsWithMe},commonPhone=#{commonPhone} where id=#{id}")
    void contacts(LoanInformationClassVo loanInformationClassVo);

    @Update("update user_loan_information set bankCardAccount=#{bankCardAccount},openingBank=#{openingBank}," +
            "bankPhone=#{bankPhone},verificationCode=#{verificationCode} where id=#{id}")
    void repaymentBank(LoanInformationClassVo loanInformationClassVo);
}
