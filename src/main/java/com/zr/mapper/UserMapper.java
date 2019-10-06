package com.zr.mapper;

import com.zr.pojo.LoanInformationClassVo;
import com.zr.pojo.LoginClassVo;
import com.zr.pojo.UserClassVo;
import com.zr.util.ResultVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by chenshuai on 2019/9/3.
 */
@Mapper
public interface UserMapper {
    @Select("select iphone from user where iphone=#{iphone}")
    List<String> queryPhone(String iphone);

    @Insert("insert into user(userName,userPwd,iphone,verificationCode,createTime,updateTime)" +
            " values(#{userName},#{userPwd},#{iphone},#{verificationCode},#{createTime},#{updateTime})")
    void register(UserClassVo userClassVo);

    @Select("select id,userName,userPwd,iphone,verificationCode,createTime,updateTime" +
            " from user where iphone=#{iphone} and userPwd=#{userPwd}")
    UserClassVo queryUser(LoginClassVo loginClassVo);

    void inputInvitationCode(LoanInformationClassVo loanInformationClassVo);

    @Select("select * from user_loan_information where userId=#{id} and payOffStatus=0")
    LoanInformationClassVo queryLoan(Integer id);
}
