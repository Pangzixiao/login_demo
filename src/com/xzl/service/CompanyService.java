package com.xzl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzl.dao.CompanyDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompanyService {
    @Resource
    CompanyDao companyDao;

    public boolean regist(Map<String, Object> param) {
        Map<String , Object> m = new HashMap<String,Object>();
        m = companyDao.queryCompanyByName(param);
        if(m == null || m.isEmpty()){
            companyDao.saveCompany(param);
            return true;
        }
        return false;
    }

    public boolean login(Map<String, Object> param) {
        Map<String,Object> m = new HashMap<String,Object>();
        boolean flag = false;
        m = companyDao.queryCompanyByName(param);

        if(m!=null&&!m.isEmpty()){
            flag = m.get("c_password").equals(param.get("c_password"));
        }
        return flag;
    }

    public PageInfo queryCompanys(Integer page) {
        PageHelper.startPage(page,3);
        List<Map<String,Object>> list = companyDao.queryUsers();
        return new PageInfo<Map<String,Object>>(list);
    }

    public boolean deleteCompanyById(int id) {
        return companyDao.deleteCompanyById(id)==1;
    }

    public Map<String,Object> queryCompanyById(int id) {
        Map<String,Object> map = companyDao.queryCompanyById(id);
        return map;
    }

    public PageInfo mutiQueryCompany(Integer page,Map<String,Object> param) {
        PageHelper.startPage(page,3);
        List<Map<String,Object>> list = companyDao.mutiQueryCompany(param);
        return new PageInfo<Map<String,Object>>(list);
    }

    public boolean checkCompanyById(int id) {
        Map<String,Object> param = new HashMap<String,Object>();
        Map<String,Object> m = companyDao.queryCompanyById(id);
        if(m!=null||!m.isEmpty()){
            return companyDao.checkCompanyById(id)==1;
        }
        return false;
    }

    public Map<String,Object> queryCompanyByName(String company_name) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("company_name",company_name);
        Map<String,Object> m = companyDao.queryCompanyByName(param);
        return m;
    }

    public boolean updateCompany(Map<String, Object> param) {
        return companyDao.updateCompany(param)==1;
    }
}
