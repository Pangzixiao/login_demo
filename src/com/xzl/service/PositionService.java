package com.xzl.service;

import com.xzl.dao.PositionDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class PositionService {
    @Resource
    PositionDao positionDao;

    public List<Map<String,Object>> queryPositionInfoByCom(String company_name) {
        return positionDao.queryPositionInfoByCom(company_name);
    }
}
