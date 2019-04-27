package com.xzl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzl.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class UserService {
    @Resource
    UserDao userDao;

    /**
     * 注册
     * @param param
     * @return
     */
    public boolean regist(Map<String, Object> param) {
        Map<String , Object> m = new HashMap<String,Object>();
        m = userDao.queryByName(param);
        if(m == null || m.isEmpty()){
            userDao.saveUser(param);
            return true;
        }
        return false;
    }

    /**
     * 登录
     * @param param
     * @return
     */
    public boolean login (Map<String,Object> param){
        Map<String,Object> m = new HashMap<String,Object>();
        boolean flag = false;
        m = userDao.queryByName(param);
        if(m!=null&&!m.isEmpty()){
            flag = m.get("password").equals(param.get("password"));
        }
        return flag;
    }

    /**
     * 查询所有用户
     * @param page
     * @return
     */
    public PageInfo queryUsers(Integer page) {
        //分页需要设置查询第几页的数据
        PageHelper.startPage(page,10);
        List<Map<String,Object>> list = userDao.queryUsers();
        return new PageInfo<Map<String,Object>>(list);
    }

    /**
     * 通过id删除用户
     * @param id
     * @return
     */
    public boolean deleteUserById(int id) {
        return userDao.deleteUserById(id);
    }

    /**
     * 通过用户名查询用户
     * @param username
     * @param page
     * @return
     */
    public PageInfo queryUsersByName(String username, Integer page) {
        PageHelper.startPage(page,10);
        List<Map<String,Object>> list = userDao.queryUsersByName(username);
        return new PageInfo<Map<String,Object>>(list);

    }


    public boolean updatePasswordByName(String username, String password) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("username",username);
        param.put("password",password);
        Map<String,Object> m = userDao.queryByName(param);
        if(m!=null||!m.isEmpty()){
            return userDao.updatePasswordByName(param)==1;
        }
        return false;
    }

    public int checkIdByName(String username) {
        Map<String , Object> param = new HashMap<String , Object>();
        param.put("username",username);
        Map<String ,Object> m = userDao.queryByName(param);
        return (int)m.get("user_id");
    }
}
