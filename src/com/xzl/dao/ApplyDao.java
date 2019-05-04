package com.xzl.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface ApplyDao {
    @Select("select * from t_apply where position_id = #{position_id}")
    List<Map<String,Object>> queryApplyByPositionId(int position_id);

    @Update("update t_apply set position_status = #{position_status} where apply_id = #{apply_id}")
    int checkPositionStatus(String apply_id, String position_status);

    int saveApply(Map<String, Object> param);
    @Select("select a.* , p.p_name,p.p_cname,p.salary,p.p_address from t_apply a left outer join  t_position p on a.position_id = p.position_id where a.user_id = #{user_id} and a.position_status=#{position_status}")
    List<Map<String,Object>> queryApplyByUserId(Map<String, Object> param);

    @Select("select a.* , p.p_name,p.p_cname,p.salary,p.p_address from t_apply a left outer join  t_position p on a.position_id = p.position_id where a.position_id = #{position_id} and a.position_status='有效'")
    List<Map<String,Object>> queryApplyByPosition(int position_id);

    @Select("select a.* , p.p_name,p.p_cname,p.salary,p.p_address from t_apply a left outer join  t_position p on a.position_id = p.position_id where p.p_cname = #{p_cname} and a.position_status='有效'")
    List<Map<String,Object>> queryApplyByCom(String p_cname);
}
