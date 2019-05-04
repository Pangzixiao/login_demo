package com.xzl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzl.dao.ApplyDao;
import com.xzl.dao.CompanyDao;
import com.xzl.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApplyService {
    @Resource
    ApplyDao applyDao;
    @Resource
    UserDao userDao;
    @Resource
    PositionService positionService;
    @Resource
    CompanyDao companyDao;

    public boolean applyPositionById(HttpSession session,int position_id) {
        String username = (String)session.getAttribute("user_login");
        if(username == null || username.equals("")){
            return false;
        }else{
            Map<String,Object> param = new HashMap<String, Object>();
            param.put("username",username);
            Map<String,Object> m  = userDao.queryByName(param);
            int user_id = (int) m.get("user_id");
            Map<String,Object> p = new HashMap<String, Object>();
            p.put("user_id",user_id);
            p.put("position_id",position_id);
            p.put("position_status","有效");
            p.put("apply_status","已申请");
            p.put("apply_date",new Date());
            if(applyDao.saveApply(p)==1){
                return positionService.addCount(position_id);
            }else{
                return false;
            }
        }
    }

    public PageInfo queryByUserId(HttpSession session,Integer page, String position_status) {
        PageHelper.startPage(page,3);
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("position_status",position_status);
        String username = (String)session.getAttribute("user_login");
        Map<String,Object> p = new HashMap<String, Object>();
        p.put("username",username);
        Map<String,Object> m  = userDao.queryByName(p);
        int user_id = (int) m.get("user_id");
        param.put("user_id",user_id);
        List<Map<String,Object>> list = applyDao.queryApplyByUserId(param);
        return new PageInfo<Map<String,Object>>(list);
    }

    public PageInfo queryApplyByPositionId(Integer page, int position_id) {
        PageHelper.startPage(page,3);
        List<Map<String,Object>> list = applyDao.queryApplyByPosition(position_id);
        return new PageInfo<Map<String,Object>>(list);
    }

    public PageInfo queryApplyByCom(Integer page,HttpSession session) {
        PageHelper.startPage(page,3);
        Map<String ,Object> param = new HashMap<String, Object>();
        String p_cname = (String)session.getAttribute("company_login");
        List<Map<String,Object>> list = applyDao.queryApplyByCom(p_cname);
        return new PageInfo<Map<String,Object>>(list);
    }
}
