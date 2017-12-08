package com.medicineCenter.dao;

import com.medicineCenter.model.dataObject.Experts;
import com.medicineCenter.model.dataObject.InspectionGroup;
import com.medicineCenter.model.dataObject.Task;
import com.medicineCenter.model.dto.SelectProviderDTO;
import com.medicineCenter.model.dto.TaskDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TaskMapperExt extends TaskMapper {
    @SelectProvider(type=TaskSqlProviderExt.class, method="selectByFullTextPrselectByFullTextProviderovider")
    @Results({
            @Result(column="task_id", property="taskId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="inspection_unit", property="inspectionUnit", jdbcType=JdbcType.VARCHAR),
            @Result(column="leader_id", property="leaderId", jdbcType=JdbcType.VARCHAR),
            @Result(column="bacteria", property="bacteria", jdbcType=JdbcType.VARCHAR),
            @Result(column="execution_time", property="executionTime", jdbcType=JdbcType.DATE),
            @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
            @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Task> selectByFullText(SelectProviderDTO selectProviderDTO);

    @SelectProvider(type=TaskSqlProviderExt.class, method="selectCountByFullTextBySourceProvider")
    int selectCountByFullText(SelectProviderDTO selectProviderDTO);


//    @Select({
//            "select * from task ",
//            "left join  inspection_group ",
//            "on  task.task_id =  inspection_group.task_id ",
//            "",
//            //"where match(name, directive) against(#{q})",
//            //"where name like CONCAT('%',#{q},'%') or directive like CONCAT('%',#{q},'%')",
//            "LIMIT #{offset},#{limit}"
//    })



    @Select("select * from task LIMIT #{offset},#{limit}")
    @Results(value = {
            @Result(property="taskId", column="taskId"),
            @Result(property="inspectionUnit", column="inspectionUnit"),
            @Result(property="source", column="source"),
            @Result(property="createUser", column="createUser"),
            @Result(property="createTime", column="createTime"),
            @Result(property="state", column="state"),
            @Result(property="GroupList", javaType=List.class, column="taskId",
                    many=@Many(select="getByTaskId"))
    })
    List<TaskDTO> selectByTaskOneReturnTaskDTO(@Param("offset") int offset, @Param("limit") int limit, @Param("q") String q);

    @Select("SELECT * FROM inspection_group WHERE inspection_group.task_id = #{taskId}")
    List<InspectionGroup> getByTaskId(String taskId);


    @Select({
            "select * from task",
            //"where match(name, directive) against(#{q})",
            "where (name like CONCAT('%',#{q},'%') or directive like CONCAT('%',#{q},'%') )",
            " and source = '#{type}'",
            "LIMIT #{offset},#{limit}"
    })
    List<Task> selectByFullTextBySource(@Param("offset") int offset, @Param("limit") int limit, @Param("q") String q, @Param("type") String type);

    @Select({
            "select count(1) from task",
            //"where match(name, directive) against(#{q})",
            "where (name like CONCAT('%',#{q},'%') or directive like CONCAT('%',#{q},'%') )",
            " and source = '#{type}'"
    })
    int selectCountByFullTextBySource(@Param("q") String q, @Param("type") String type);
    @Update({
            "update group_experts",
            "set state = '已确认'",
            "where task_id = #{taskId,jdbcType=INTEGER}"
    })
    int updateGroupExpertsByState(@Param("taskId") int taskId);

    @Select({
            "select count(1) from task",
            //"where match(name, directive) against(#{q})",
            " where task.state = '处理中' "
    })
    int queryTaskprocessing();
    @Select({
            "select count(1) from task",
            //"where match(name, directive) against(#{q})",
            " where task.state = '变更中' "
    })
    int queryTaskChange();
    @Select({
            "select count(1) from task",
            //"where match(name, directive) against(#{q})",
            " where task.state = '待生成' "
    })
    int queryTaskgenerate();
    @SelectProvider(type=TaskSqlProviderExt.class, method="selectFreqAvoidanceNumber")
    @Results({
            @Result(column="experts_id", property="expertsId", jdbcType=JdbcType.INTEGER)
    })
    List<Experts> FreqAvoidance(SelectProviderDTO selectProviderDTO);

    @Select({
            "select * from task where now() <  task.end_execution_time and task.source = #{source}"
    })
    List<Task> selectByEndExecutionTime(@Param("source") String source);
}
