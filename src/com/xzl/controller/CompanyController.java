package com.xzl.controller;

import com.xzl.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Resource
    CompanyService companyService;

    @RequestMapping("/c_regist")
    public ModelAndView regist(@RequestParam Map<String,Object> param, HttpSession session){
        ModelAndView mav = new ModelAndView("redirect:/c_login");
        param.put("check_type","未审批");
        boolean b = companyService.regist(param);
        if( !b ){
            mav.setViewName("/c_register");
            mav.addObject("msg","用户名已存在");
        }

        return mav;
    }

    @RequestMapping("/c_login")
    public ModelAndView login(HttpSession session,@RequestParam Map<String,Object> param){
        ModelAndView mav = new ModelAndView("companyMain");
        boolean b = companyService.login(param);
        if(!b){
            mav.setViewName("redirect:c_login");
            mav.addObject("msg","用户名错误或密码错误");
        }else{
            session.setAttribute("company_login",param.get("company_name"));
        }
        return mav;
    }

    @RequestMapping("/showCompanyInfo")
    public ModelAndView showCompanyInfo(HttpSession session){
        ModelAndView mav = new ModelAndView("c_showCompanyInfo");
        String company_name = (String)session.getAttribute("company_login");
        if(company_name == null || company_name.equals("")){
            mav.setViewName("error");
        }else{
            Map<String , Object> info = companyService.queryCompanyByName(company_name);
            mav.addObject("info",info);
        }
        return mav;
    }


}
