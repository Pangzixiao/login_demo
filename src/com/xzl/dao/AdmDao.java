package com.xzl.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface AdmDao {
    @Select("select * from admin where username = #{username}")
    Map<String,Object> queryByName(Map<String, Object> param);
}
