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
}
