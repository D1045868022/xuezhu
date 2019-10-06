package com.zr.service;

import com.zr.pojo.*;
import com.zr.util.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by chenshuai on 2019/9/3.
 */
public interface LoanService {
    ResultVo installmentApply(MyStageClassVo myStageClassVo, HttpServletRequest request,HttpServletResponse response);

    ResultVo essentialInformation(MyBasicClassVo myBasicClassVo, HttpServletRequest request,HttpServletResponse response);

    ResultVo userLive(MyDwellClassVo myDwellClassVo, HttpServletRequest request, HttpServletResponse response);

    ResultVo education(MyEductionClassVo myEductionClassVo, HttpServletRequest request, HttpServletResponse response);

    ResultVo contacts(MyContactsClassVo myContactsClassVo, HttpServletRequest request, HttpServletResponse response);

    ResultVo repaymentBank(MyBankClassVo myBankClassVo, HttpServletRequest request, HttpServletResponse response);

    ResultVo xueZhuFenQi(HttpServletRequest request);
}
