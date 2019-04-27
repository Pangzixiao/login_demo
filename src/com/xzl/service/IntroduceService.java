package com.xzl.service;

import com.xzl.dao.IntroduceDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class IntroduceService {
    @Resource
    IntroduceDao introduceDao;

    public Map<String,Object> queryIntroduceById(int id) {
        return introduceDao.queryIntroduceByid(id);
    }

    public boolean addIntroduce(Map<String, Object> param) {
        return introduceDao.addIntroduce(param) == 1;
    }

    public boolean updateIntroduceById(Map<String, Object> param) {
        return introduceDao.updateIntroduceById(param)==1;
    }
}
