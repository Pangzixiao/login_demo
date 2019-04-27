package com.xzl.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface CompanyDao {
    @Select("select * from t_company where company_name = #{company_name}")
    Map<String,Object> queryCompanyByName(Map<String, Object> param);

    int saveCompany(Map<String, Object> param);
    @Select("select * from t_company")
    List<Map<String,Object>> queryUsers();
    @Delete("delete  from t_company where company_id = #{id}")
    int deleteCompanyById(int id);

    Map<String,Object> queryCompanyById(int id);

    List<Map<String,Object>> mutiQueryCompany( Map<String,Object> param);

    @Update("update t_company set check_type='已审批' where company_id = #{id}")
    int checkCompanyById(int id);
}
