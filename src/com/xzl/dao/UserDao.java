package com.xzl.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {
    public int saveUser(Map<String,Object> param);
    @Select("select * from t_user where username = #{username}")
    Map<String,Object> queryByName(Map<String, Object> param);
    @Select("select * from t_user")
    List<Map<String,Object>> queryUsers();
    @Delete("delete  from t_user where user_id = #{id}")
    boolean deleteUserById(int id);
    @Select("select * from t_user where username = #{username}")
    List<Map<String,Object>> queryUsersByName(String username);

    @Update("update t_user set password=#{password} where username = #{username}")
    int updatePasswordByName(Map<String, Object> param);


}
