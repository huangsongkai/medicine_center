package com.medicineCenter.dao;
import com.medicineCenter.model.dataObject.GroupExperts;
import com.medicineCenter.model.dto.ExpertsTaskDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface GroupExpertsMapperExt extends GroupExpertsMapper {
    //ALTER TABLE USER ADD FULLTEXT INDEX ft_index (NAME,DIRECTIVE) WITH PARSER ngram;
    @Select({
    "select * from groupexperts",
    //"where match(name, directive) against(#{q})",
    //"where name like CONCAT('%',#{q},'%') or directive like CONCAT('%',#{q},'%')",
    "LIMIT #{offset},#{limit}"
    })
    List<GroupExperts> selectByFullText(@Param("offset") int offset, @Param("limit") int limit, @Param("q") String q);

    @Select({
    "select count(1) from group_experts",
    //"where match(name, directive) against(#{q})",
    //"where name like CONCAT('%',#{q},'%') or directive like CONCAT('%',#{q},'%')",
    })
    int selectCountByFullText(@Param("q") String q);

    @Select({
            "SELECT experts.name AS  name, task.inspection_unit AS inspectionUnit , task.source AS source , task.create_time AS createTime , task.execution_time AS executionTime FROM group_experts ",
            "LEFT JOIN task ON group_experts.task_id = task.task_id " ,
            "LEFT JOIN experts ON group_experts.experts_id = experts.experts_id",
            "LIMIT #{offset},#{limit}"
    })
    @Results({
            @Result(column="name", property="name" ,jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="inspection_unit", property="inspectionUnit", jdbcType=JdbcType.VARCHAR),
            @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="execution_time", property="executionTime", jdbcType=JdbcType.DATE)
    })
    List<ExpertsTaskDTO> queryExpertsTask(@Param("offset") int offset, @Param("limit") int limit, @Param("q") String q);

}
