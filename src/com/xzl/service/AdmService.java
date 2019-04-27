package com.xzl.service;

import com.xzl.dao.AdmDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@Service
public class AdmService {
    @Resource
    AdmDao admDao;
    public boolean login(Map<String, Object> param) {
        Map<String,Object> m = new HashMap<String,Object>();
        boolean flag = false;
        m = admDao.queryByName(param);
        if(m!=null&&!m.isEmpty()){
            flag = m.get("password").equals(param.get("password"));
        }
        return flag;
    }
}
