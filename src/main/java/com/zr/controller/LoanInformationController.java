package com.zr.controller;

import com.zr.meiju.*;
import com.zr.pojo.*;
import com.zr.service.LoanService;
import com.zr.service.impl.LoanServiceImpl;
import com.zr.util.ResultBuildVo;
import com.zr.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenshuai on 2019/9/3.
 */
@RestController
public class LoanInformationController {

    @Autowired
    private LoanService loanService;
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("getFqsq")
    public ResultVo getFqsq(HttpServletRequest request){
        String key = LoanServiceImpl.huoQuKey(request);
        MyStageClassVo myStageClassVo = new MyStageClassVo();
        LoanInformationClassVo loanInformationClassVo = (LoanInformationClassVo)redisTemplate.opsForValue().get(key);
        myStageClassVo.setAmountSettlements(loanInformationClassVo.getAmountSettlements());
        myStageClassVo.setMyCourseName(CourseEnum.getName(loanInformationClassVo.getMyCourse()));
        myStageClassVo.setMyCourse(loanInformationClassVo.getMyCourse());
        myStageClassVo.setPaymentCycleName(CycleEnum.getName(loanInformationClassVo.getPaymentCycle()));
        myStageClassVo.setPaymentCycle(loanInformationClassVo.getPaymentCycle());
        myStageClassVo.setClassHours(loanInformationClassVo.getClassHours());
        return ResultBuildVo.success(myStageClassVo);
    }

    @GetMapping("kechengDropdownBox")
    public ResultVo kechengDropdownBox(){
        List<XiaLaClass> xiaLaClassList = new ArrayList<>();
        for (CourseEnum c : CourseEnum.values()){
            XiaLaClass xiaLaClass = new XiaLaClass(c.getStatusValue(),c.getStatusName());
            xiaLaClassList.add(xiaLaClass);
        }
        return ResultBuildVo.success(xiaLaClassList);
    }

    @GetMapping("huankuanDropdownBox")
    public ResultVo huankuanDropdownBox(){
        List<XiaLaClass> xiaLaClassList = new ArrayList<>();
        for (CycleEnum c : CycleEnum.values()){
            XiaLaClass xiaLaClass = new XiaLaClass(c.getStatusValue(),c.getStatusName());
            xiaLaClassList.add(xiaLaClass);
        }
        return ResultBuildVo.success(xiaLaClassList);
    }

    @PostMapping("installmentApply")
    public ResultVo installmentApply(@RequestBody @Valid MyStageClassVo myStageClassVo, HttpServletRequest request,HttpServletResponse response ,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }

        return loanService.installmentApply(myStageClassVo,request,response);
    }

    @PostMapping("essentialInformation")
    public ResultVo essentialInformation(@RequestBody @Valid MyBasicClassVo myBasicClassVo, HttpServletRequest request,HttpServletResponse response ,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return loanService.essentialInformation(myBasicClassVo,request,response);
    }

    @GetMapping("getNews")
    public ResultVo getNews(HttpServletRequest request){
        String key = LoanServiceImpl.huoQuKey(request);
        MyBasicClassVo myBasicClassVo = new MyBasicClassVo();
        LoanInformationClassVo loanInformationClassVo = (LoanInformationClassVo)redisTemplate.opsForValue().get(key);
        return ResultBuildVo.success(loanInformationClassVo);
    }

    @GetMapping("hunyinDropdownBox")
    public ResultVo hunyinDropdownBox(){
        List<XiaLaClass> xiaLaClassList = new ArrayList<>();
        for (MaritalStatusEnum c : MaritalStatusEnum.values()){
            XiaLaClass xiaLaClass = new XiaLaClass(c.getStatusValue(),c.getStatusName());
            xiaLaClassList.add(xiaLaClass);
        }
        return ResultBuildVo.success(xiaLaClassList);
    }

    @GetMapping("juzhuDropdownBox")
    public ResultVo juzhuDropdownBox(){
        List<XiaLaClass> xiaLaClassList = new ArrayList<>();
        for (LiveStatusEnum c : LiveStatusEnum.values()){
            XiaLaClass xiaLaClass = new XiaLaClass(c.getStatusValue(),c.getStatusName());
            xiaLaClassList.add(xiaLaClass);
        }
        return ResultBuildVo.success(xiaLaClassList);
    }

    @GetMapping("nianxianDropdownBox")
    public ResultVo nianxianDropdownBox(){
        List<XiaLaClass> xiaLaClassList = new ArrayList<>();
        for (LiveYearEnum c : LiveYearEnum.values()){
            XiaLaClass xiaLaClass = new XiaLaClass(c.getStatusValue(),c.getStatusName());
            xiaLaClassList.add(xiaLaClass);
        }
        return ResultBuildVo.success(xiaLaClassList);
    }


    @PostMapping("userLive")
    public ResultVo userLive(@RequestBody @Valid MyDwellClassVo myDwellClassVo, HttpServletRequest request,HttpServletResponse response ,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return loanService.userLive(myDwellClassVo,request,response);
    }


    @GetMapping("getLive")
    public ResultVo getLive(HttpServletRequest request){
        String key = LoanServiceImpl.huoQuKey(request);
        MyDwellClassVo myDwellClassVo = new MyDwellClassVo();
        LoanInformationClassVo loanInformationClassVo = (LoanInformationClassVo)redisTemplate.opsForValue().get(key);
        myDwellClassVo.setMaritalStatusName(MaritalStatusEnum.getName(loanInformationClassVo.getMaritalStatus()));
        myDwellClassVo.setLiveStatusName(LiveStatusEnum.getName(loanInformationClassVo.getLiveStatus()));
        myDwellClassVo.setLiveYearName(LiveYearEnum.getName(loanInformationClassVo.getLiveYear()));
        myDwellClassVo.setMaritalStatus(loanInformationClassVo.getMaritalStatus());
        myDwellClassVo.setLiveStatus(loanInformationClassVo.getLiveStatus());
        myDwellClassVo.setLiveYear(loanInformationClassVo.getLiveYear());
        myDwellClassVo.setProvince(loanInformationClassVo.getProvince());
        myDwellClassVo.setDetailedAddress(loanInformationClassVo.getDetailedAddress());
        return ResultBuildVo.success(myDwellClassVo);
    }


    @GetMapping("getEducation")
    public ResultVo getEducation(HttpServletRequest request){
        String key = LoanServiceImpl.huoQuKey(request);
        MyEductionClassVo myEductionClassVo = new MyEductionClassVo();
        LoanInformationClassVo loanInformationClassVo = (LoanInformationClassVo)redisTemplate.opsForValue().get(key);
        myEductionClassVo.setEducation(loanInformationClassVo.getEducation());
        myEductionClassVo.setEducationName(EducationEnum.getName(loanInformationClassVo.getEducation()));
        myEductionClassVo.setOccupation(loanInformationClassVo.getOccupation());
        myEductionClassVo.setOccupationName(OccupationEnum.getName(loanInformationClassVo.getOccupation()));
        myEductionClassVo.setGraduationSchool(loanInformationClassVo.getGraduationSchool());
        myEductionClassVo.setGraduationYear(loanInformationClassVo.getGraduationYear());
        myEductionClassVo.setMajor(loanInformationClassVo.getMajor());
        return ResultBuildVo.success(myEductionClassVo);
    }

    @GetMapping("zhiyeDropdownBox")
    public ResultVo zhiyeDropdownBox(){
        List<XiaLaClass> xiaLaClassList = new ArrayList<>();
        for (OccupationEnum c : OccupationEnum.values()){
            XiaLaClass xiaLaClass = new XiaLaClass(c.getStatusValue(),c.getStatusName());
            xiaLaClassList.add(xiaLaClass);
        }
        return ResultBuildVo.success(xiaLaClassList);
    }

    @GetMapping("xueliDropdownBox")
    public ResultVo xueliDropdownBox(){
        List<XiaLaClass> xiaLaClassList = new ArrayList<>();
        for (EducationEnum c : EducationEnum.values()){
            XiaLaClass xiaLaClass = new XiaLaClass(c.getStatusValue(),c.getStatusName());
            xiaLaClassList.add(xiaLaClass);
        }
        return ResultBuildVo.success(xiaLaClassList);
    }

    @PostMapping("education")
    public ResultVo education(@RequestBody @Valid MyEductionClassVo myEductionClassVo, HttpServletRequest request,HttpServletResponse response ,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return loanService.education(myEductionClassVo,request,response);
    }

    @GetMapping("withguanxiDropdownBox")
    public ResultVo withguanxiDropdownBox(){
        List<XiaLaClass> xiaLaClassList = new ArrayList<>();
        for (RelationsWithMeEnum c : RelationsWithMeEnum.values()){
            XiaLaClass xiaLaClass = new XiaLaClass(c.getStatusValue(),c.getStatusName());
            xiaLaClassList.add(xiaLaClass);
        }
        return ResultBuildVo.success(xiaLaClassList);
    }

    @GetMapping("withguanxiDropdownBoxOften")
    public ResultVo withguanxiDropdownBoxOften(){
        List<XiaLaClass> xiaLaClassList = new ArrayList<>();
        for (CommonRelationsWithMeEnum c : CommonRelationsWithMeEnum.values()){
            XiaLaClass xiaLaClass = new XiaLaClass(c.getStatusValue(),c.getStatusName());
            xiaLaClassList.add(xiaLaClass);
        }
        return ResultBuildVo.success(xiaLaClassList);
    }

    @GetMapping("getContacts")
    public ResultVo getContacts(HttpServletRequest request){
        String key = LoanServiceImpl.huoQuKey(request);
        MyContactsClassVo myContactsClassVo = new MyContactsClassVo();
        LoanInformationClassVo loanInformationClassVo = (LoanInformationClassVo)redisTemplate.opsForValue().get(key);
        myContactsClassVo.setCommonRelationsWithMeName(CommonRelationsWithMeEnum.getName(loanInformationClassVo.getCommonRelationsWithMe()));
        myContactsClassVo.setRelationsWithMeName(RelationsWithMeEnum.getName(loanInformationClassVo.getRelationsWithMe()));
        myContactsClassVo.setCommonRelationsWithMe(loanInformationClassVo.getCommonRelationsWithMe());
        myContactsClassVo.setRelationsWithMe(loanInformationClassVo.getRelationsWithMe());
        myContactsClassVo.setCommonFamilyContacts(loanInformationClassVo.getCommonFamilyContacts());
        myContactsClassVo.setCommonPhone(loanInformationClassVo.getCommonPhone());
        myContactsClassVo.setContactTelephone(loanInformationClassVo.getContactTelephone());
        myContactsClassVo.setFamilyContacts(loanInformationClassVo.getFamilyContacts());
        return ResultBuildVo.success(myContactsClassVo);
    }

    @PostMapping("contacts")
    public ResultVo contacts(@RequestBody @Valid MyContactsClassVo myContactsClassVo, HttpServletRequest request,HttpServletResponse response ,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return loanService.contacts(myContactsClassVo,request,response);
    }


    @GetMapping("kaihuhangDropdownBox")
    public ResultVo kaihuhangDropdownBox(){
        List<KaiHuClassVo> kaiHuClassVoList = new ArrayList<>();
        for (OpeningBankEnum c : OpeningBankEnum.values()){
            KaiHuClassVo kaiHuClassVo = new KaiHuClassVo(c.getStatusValue(),c.getStatusName());
            kaiHuClassVoList.add(kaiHuClassVo);
        }
        return ResultBuildVo.success(kaiHuClassVoList);
    }

    @PostMapping("repaymentBank")
    public ResultVo repaymentBank(@RequestBody @Valid MyBankClassVo myBankClassVo, HttpServletRequest request,HttpServletResponse response ,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return loanService.repaymentBank(myBankClassVo,request,response);
    }

    @GetMapping("huankuan_dengji")
    public ResultVo huankuan_dengji(HttpServletRequest request){
        String key = LoanServiceImpl.huoQuKey(request);
        MyBankClassVo myBankClassVo = new MyBankClassVo();
        LoanInformationClassVo loanInformationClassVo = (LoanInformationClassVo)redisTemplate.opsForValue().get(key);
        myBankClassVo.setOpeningBankName(OpeningBankEnum.getName(loanInformationClassVo.getOpeningBank()));
        myBankClassVo.setOpeningBank(loanInformationClassVo.getOpeningBank());
        myBankClassVo.setBankCardAccount(loanInformationClassVo.getBankCardAccount());
        myBankClassVo.setBankPhone(loanInformationClassVo.getBankPhone());
        myBankClassVo.setVerificationCode(loanInformationClassVo.getVerificationCode());
        return ResultBuildVo.success(myBankClassVo);
    }

    @GetMapping("xueZhuFenQi")
    public ResultVo xueZhuFenQi(HttpServletRequest request){
        return loanService.xueZhuFenQi(request);
    }

    @PostMapping("xueZhuFenQiAdd")
    public ResultVo xueZhuFenQiAdd(){
        return ResultBuildVo.success(null);
    }

    @GetMapping("examine")
    public ResultVo examine(HttpServletRequest request){
        String key = LoanServiceImpl.huoQuKey(request);
        ExamineClassVo examineClassVo = new ExamineClassVo();
        LoanInformationClassVo loanInformationClassVo = (LoanInformationClassVo)redisTemplate.opsForValue().get(key);
        examineClassVo.setName(loanInformationClassVo.getName());
        examineClassVo.setAmountSettlements(loanInformationClassVo.getAmountSettlements());
        examineClassVo.setMyCourse(CourseEnum.getName(loanInformationClassVo.getMyCourse()));
        examineClassVo.setPaymentCycleName(CycleEnum.getName(loanInformationClassVo.getPaymentCycle()));
        examineClassVo.setBackBank(OpeningBankEnum.getName(loanInformationClassVo.getOpeningBank()));
        examineClassVo.setPhone(loanInformationClassVo.getPhone());
        return ResultBuildVo.success(examineClassVo);
    }

    @GetMapping("myOrder")
    public ResultVo myOrder(){
        return ResultBuildVo.success(null);
    }
}
