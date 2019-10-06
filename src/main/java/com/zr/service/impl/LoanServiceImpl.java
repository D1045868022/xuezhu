package com.zr.service.impl;

import com.zr.mapper.LoanMapper;
import com.zr.meiju.CourseEnum;
import com.zr.meiju.CycleEnum;
import com.zr.meiju.OpeningBankEnum;
import com.zr.pojo.*;
import com.zr.service.LoanService;
import com.zr.util.ResultBuildVo;
import com.zr.util.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by chenshuai on 2019/9/3.
 */
@Service
public class LoanServiceImpl implements LoanService{
    @Autowired
    private LoanMapper loanMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public ResultVo installmentApply(MyStageClassVo myStageClassVo, HttpServletRequest request,HttpServletResponse response) {
        String key = huoQuKey(request);
        LoanInformationClassVo loanInformationClassVo = new LoanInformationClassVo();
        LoanInformationClassVo informationClassVo = (LoanInformationClassVo)redisTemplate.opsForValue().get(key);
        BeanUtils.copyProperties(myStageClassVo,loanInformationClassVo);
        loanInformationClassVo.setId(informationClassVo.getId());
        loanInformationClassVo.setUpdateTime(new Date());
        loanMapper.installmentApply(loanInformationClassVo);
        LoanInformationClassVo loanInformationClassVo1 = loanMapper.queryById(informationClassVo.getId());
        redisTemplate.opsForValue().set(key,loanInformationClassVo1);
        return ResultBuildVo.success(loanInformationClassVo);
    }

    @Override
    public ResultVo essentialInformation(MyBasicClassVo myBasicClassVo, HttpServletRequest request,HttpServletResponse response) {
        String key = huoQuKey(request);
        LoanInformationClassVo loanInformationClassVo = new LoanInformationClassVo();
        LoanInformationClassVo informationClassVo = (LoanInformationClassVo)redisTemplate.opsForValue().get(key);
        BeanUtils.copyProperties(myBasicClassVo,loanInformationClassVo);
        loanInformationClassVo.setId(informationClassVo.getId());
        loanInformationClassVo.setUpdateTime(new Date());
        loanMapper.essentialInformation(loanInformationClassVo);
        LoanInformationClassVo loanInformationClassVo1 = loanMapper.queryById(informationClassVo.getId());
        redisTemplate.opsForValue().set(key,loanInformationClassVo1);
        return ResultBuildVo.success(loanInformationClassVo);
    }



    @Override
    public ResultVo userLive(MyDwellClassVo myDwellClassVo, HttpServletRequest request, HttpServletResponse response) {
        String key = huoQuKey(request);
        LoanInformationClassVo loanInformationClassVo = new LoanInformationClassVo();
        LoanInformationClassVo informationClassVo = (LoanInformationClassVo)redisTemplate.opsForValue().get(key);
        BeanUtils.copyProperties(myDwellClassVo,loanInformationClassVo);
        loanInformationClassVo.setId(informationClassVo.getId());
        loanInformationClassVo.setUpdateTime(new Date());
        loanMapper.userLive(loanInformationClassVo);
        LoanInformationClassVo loanInformationClassVo1 = loanMapper.queryById(informationClassVo.getId());
        redisTemplate.opsForValue().set(key,loanInformationClassVo1);
        return ResultBuildVo.success(loanInformationClassVo);
    }

    @Override
    public ResultVo education(MyEductionClassVo myEductionClassVo, HttpServletRequest request, HttpServletResponse response) {
        String key = huoQuKey(request);
        LoanInformationClassVo loanInformationClassVo = new LoanInformationClassVo();
        LoanInformationClassVo informationClassVo = (LoanInformationClassVo)redisTemplate.opsForValue().get(key);
        BeanUtils.copyProperties(myEductionClassVo,loanInformationClassVo);
        loanInformationClassVo.setId(informationClassVo.getId());
        loanInformationClassVo.setUpdateTime(new Date());
        loanMapper.education(loanInformationClassVo);
        LoanInformationClassVo loanInformationClassVo1 = loanMapper.queryById(informationClassVo.getId());
        redisTemplate.opsForValue().set(key,loanInformationClassVo1);
        return ResultBuildVo.success(loanInformationClassVo);
    }

    @Override
    public ResultVo contacts(MyContactsClassVo myContactsClassVo, HttpServletRequest request, HttpServletResponse response) {
        String key = huoQuKey(request);
        LoanInformationClassVo loanInformationClassVo = new LoanInformationClassVo();
        LoanInformationClassVo informationClassVo = (LoanInformationClassVo)redisTemplate.opsForValue().get(key);
        BeanUtils.copyProperties(myContactsClassVo,loanInformationClassVo);
        loanInformationClassVo.setId(informationClassVo.getId());
        loanInformationClassVo.setUpdateTime(new Date());
        loanMapper.contacts(loanInformationClassVo);
        LoanInformationClassVo loanInformationClassVo1 = loanMapper.queryById(informationClassVo.getId());
        redisTemplate.opsForValue().set(key,loanInformationClassVo1);
        return ResultBuildVo.success(loanInformationClassVo);
    }

    @Override
    public ResultVo repaymentBank(MyBankClassVo myBankClassVo, HttpServletRequest request, HttpServletResponse response) {
        String key = huoQuKey(request);
        LoanInformationClassVo loanInformationClassVo = new LoanInformationClassVo();
        LoanInformationClassVo informationClassVo = (LoanInformationClassVo)redisTemplate.opsForValue().get(key);
        BeanUtils.copyProperties(myBankClassVo,loanInformationClassVo);
        loanInformationClassVo.setId(informationClassVo.getId());
        loanInformationClassVo.setUpdateTime(new Date());
        loanMapper.repaymentBank(loanInformationClassVo);
        LoanInformationClassVo loanInformationClassVo1 = loanMapper.queryById(informationClassVo.getId());
        redisTemplate.opsForValue().set(key,loanInformationClassVo1);
        return ResultBuildVo.success(loanInformationClassVo);
    }

    @Override
    public ResultVo xueZhuFenQi(HttpServletRequest request) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar c = Calendar.getInstance();
        String key = huoQuKey(request);
        XueZhuFenQiClassVo xueZhuFenQiClassVo = new XueZhuFenQiClassVo();
        LoanInformationClassVo loanInformationClassVo = (LoanInformationClassVo)redisTemplate.opsForValue().get(key);
        xueZhuFenQiClassVo.setAmountSettlements(loanInformationClassVo.getAmountSettlements());
        xueZhuFenQiClassVo.setPaymentAccount("中软云际");
        Date startTime = loanInformationClassVo.getCreateTime();
        String day=String .format("%td", startTime);
        int month = 0;
        if (loanInformationClassVo.getPaymentCycle() == 0){
            month=3;
        }
        else if (loanInformationClassVo.getPaymentCycle() == 1){
            month=6;
        }
        else if (loanInformationClassVo.getPaymentCycle() == 2){
            month=9;
        }
        else if (loanInformationClassVo.getPaymentCycle() == 3){
            month=12;
        }
        c.add(Calendar.MONTH,month);
        System.out.println(sdf.format(c.getTime()));
        Date endTime = c.getTime();
        String startTimeStr = sdf.format(startTime);
        String endTimeStr = sdf.format(endTime);
        StringBuffer stringBuffer = new StringBuffer();
        String append1 = stringBuffer.append(startTimeStr).append("-").append(endTimeStr).toString();
        xueZhuFenQiClassVo.setQizhiDate(append1);
        xueZhuFenQiClassVo.setName(loanInformationClassVo.getName());
        xueZhuFenQiClassVo.setIdCode(loanInformationClassVo.getIdCode());
        StringBuffer stringBuffer1 = new StringBuffer();
        String append2 = stringBuffer1.append("每月").append(day).append("号").toString();
        xueZhuFenQiClassVo.setPayMentDate(append2);
        xueZhuFenQiClassVo.setPaymentCycle(CycleEnum.getName(loanInformationClassVo.getPaymentCycle()));
        xueZhuFenQiClassVo.setBackBank(OpeningBankEnum.getName(loanInformationClassVo.getOpeningBank()));
        xueZhuFenQiClassVo.setAgreement("授权书");
        xueZhuFenQiClassVo.setMyCourseName(CourseEnum.getName(loanInformationClassVo.getMyCourse()));
        return ResultBuildVo.success(xueZhuFenQiClassVo);
    }


    public static String huoQuKey(HttpServletRequest request) {
        String key = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals("loanId")){
                    key = cookie.getValue();
                }
            }
        }
        return key;
    }

}
