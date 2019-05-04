package com.xzl.controller;

import com.github.pagehelper.PageInfo;
import com.xzl.service.*;
import javafx.beans.binding.ObjectExpression;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;
    @Resource
    IntroduceService introduceService;
    @Resource
    PositionService positionService;
    @Resource
    CompanyService companyService;
    @Resource
    ApplyService applyService;

    @RequestMapping("/regist")
    public ModelAndView regist(@RequestParam Map<String,Object> param, HttpSession session){
        ModelAndView mav = new ModelAndView("redirect:/login");
        boolean b = userService.regist(param);
        if( !b ){
            mav.setViewName("/register");
            mav.addObject("msg","用户名已存在");
        }

        return mav;
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpSession session,@RequestParam Map<String,Object> param){
        ModelAndView mav = new ModelAndView("userMain");
        boolean b = userService.login(param);
        if(!b){
            mav.setViewName("redirect:login");
            mav.addObject("msg","用户名错误或密码错误");
        }else{
            session.setAttribute("user_login",param.get("username"));
        }
        return mav;
    }

    @RequestMapping("/showIntroduce")
    public ModelAndView showIntroduce(HttpSession session){
        ModelAndView mav = new ModelAndView("u_showIntroduce");
        String username = (String)session.getAttribute("user_login");
        if(username == null || username.equals("")){
            mav.setViewName("error");
        }else{
            int id = userService.checkIdByName(username);
            Map<String , Object> info = introduceService.queryIntroduceById(id);
            if(info==null||info.isEmpty()){
                mav.setViewName("u_addIntroduce");
                mav.addObject("id",id);
            }else{
                mav.addObject("info",info);
            }
        }
        return mav;
    }

    @RequestMapping("/addIntroduce")
    public ModelAndView addIntroduce(@RequestParam Map<String , Object> param){
        ModelAndView mav = new ModelAndView("u_showIntroduce");
        boolean b = introduceService.addIntroduce(param);
        if( !b ){
            mav.setViewName("error");
            mav.addObject("msg","添加简历失败");
        }else{
            Map<String,Object> info = introduceService.queryIntroduceById(Integer.parseInt( (String)param.get("user_id")));
            mav.addObject("info",info);
        }

        return mav;
    }
    @RequestMapping("/queryIntroduce")
    public ModelAndView queryIntroduce(HttpSession session){
        ModelAndView mav = new ModelAndView("u_editIntroduce");
        String username = (String)session.getAttribute("user_login");
        if(username == null || username.equals("")){
            mav.setViewName("error");
        }else{
            int id = userService.checkIdByName(username);
            Map<String , Object> info = introduceService.queryIntroduceById(id);
            mav.addObject("info",info);
        }
        return mav;
    }

    @RequestMapping("/updateIntroduceById")
    public ModelAndView updateIntroduceById(@RequestParam Map<String,Object> param){
        ModelAndView mav = new ModelAndView("userMain");
        boolean b = introduceService.updateIntroduceById(param);
        if(!b){
            mav.addObject("msg","修改简历失败");
            mav.setViewName("error");
        }
        return mav;
    }

    @RequestMapping("/selectPositionPre")
    public ModelAndView selectPositionPre(){
        ModelAndView mav = new ModelAndView("u_findPosition");
        return mav;
    }
    @RequestMapping("/findPosition")
    public ModelAndView findPosition(HttpSession session,@RequestParam(required = false,defaultValue = "1") Integer page,@RequestParam Map<String , ObjectExpression> param){
        ModelAndView mav = new ModelAndView("u_queriedPosition");
        PageInfo info = positionService.MutiqueryPosition(page,param);
        mav.addObject("info",info);
        session.setAttribute("param",param);
        return mav;
    }

    @RequestMapping("/findPositionPage")
    public ModelAndView findPositionPage(HttpSession session,@RequestParam(required = false,defaultValue = "1") Integer page){
        ModelAndView mav = new ModelAndView("u_queriedPosition");
        Map<String , ObjectExpression> param = (Map<String , ObjectExpression>)session.getAttribute("param");
        PageInfo info = positionService.MutiqueryPosition(page,param);
        mav.addObject("info",info);
        session.setAttribute("param",param);
        return mav;
    }

    @RequestMapping("/queryPositionsByCompanyId")
    public ModelAndView queryPositionsByCompanyId(@RequestParam(required = false,defaultValue = "1") Integer page,int company_id){
        ModelAndView mav = new ModelAndView("u_companyPositionList");
        PageInfo info = positionService.queryPositionByCompanyId(page,company_id);
        Map<String,Object> comp = companyService.queryCompanyById(company_id);
        mav.addObject("info",info);
        mav.addObject("comp",comp);
        return mav;
    }

    @RequestMapping("/queryCompanyById")
    public  ModelAndView queryCompanyById(int company_id){
        ModelAndView mav = new ModelAndView("u_showCompanyInfo");
        Map<String,Object> info = companyService.queryCompanyById(company_id);
        mav.addObject("info",info);
        return mav;
    }

    @RequestMapping("/queryPositionById")
    public ModelAndView queryPositionById(int position_id){
        ModelAndView mav = new ModelAndView("u_showPositionInfo");
        Map<String,Object> info = positionService.queryPositionById(position_id);
        mav.addObject("info",info);
        return mav;
    }

    @RequestMapping("/applyPositionById")
    public ModelAndView applyPositionById(HttpSession session,int position_id){
        ModelAndView mav = new ModelAndView("redirect:/userMain");
        boolean b = applyService.applyPositionById(session,position_id);
        if(!b){
            mav.setViewName("error");
            mav.addObject("msg","请登录");
        }
        return mav;
    }

    @RequestMapping("/showMyApplay")
    public ModelAndView showMyApplay(HttpSession session, @RequestParam(required = false,defaultValue = "1") Integer page,
                                     @RequestParam(required = false,defaultValue = "有效") String position_status){
        ModelAndView mav = new ModelAndView("u_showMyApply");
        PageInfo info = applyService.queryByUserId(session,page,position_status);
        mav.addObject("info",info);
        return mav;
    }
}
