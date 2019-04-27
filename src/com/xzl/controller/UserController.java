package com.xzl.controller;

import com.xzl.service.IntroduceService;
import com.xzl.service.UserService;
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
}
