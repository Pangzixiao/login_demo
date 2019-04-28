package com.xzl.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface PositionDao {
    @Select("select p.* ,c.company_name from t_position  p left outer join  t_company c on p.company_id = c.company_id where c.company_name=#{company_name}")
    List<Map<String,Object>> queryPositionInfoByCom(String company_name);

    int newPosition(Map<String, Object> param);
    @Select("select * from t_position where position_id = #{position_id}")
    Map<String,Object> queryPositionById(int position_id);

    int updatePosition(Map<String, Object> param);
    @Delete("delete from t_position where position_id=#{position_id}")
    int delPositionById(int position_id);
}
