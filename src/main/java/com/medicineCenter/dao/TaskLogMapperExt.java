package com.medicineCenter.dao;
import com.medicineCenter.model.dataObject.TaskLog;
import com.medicineCenter.model.dto.TaskLogDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TaskLogMapperExt extends TaskLogMapper {
    //ALTER TABLE USER ADD FULLTEXT INDEX ft_index (NAME,DIRECTIVE) WITH PARSER ngram;
    String sql =    " select t.source AS source, inspection_unit ,  a.`name` AS old_name, b.`name` AS new_name, reason , task_log.create_time  from task_log  "+
            " inner join task t on task_log.task_id = t.task_id "+
            " left join experts a on task_log.orig_experts_id = a.experts_id "+
            " left join experts b on task_log.new_experts_id =  b.experts_id ";
    String sql1 =    " select t.source AS source, inspection_unit ,  a.`name` AS old_name, b.`name` AS new_name, reason  from task_log "+
            " inner join task t on task_log.task_id = t.task_id  and t.source =  #{source,jdbcType=VARCHAR} "+
            " left join experts a on task_log.orig_experts_id = a.experts_id "+
            " left join experts b on task_log.new_experts_id =  b.experts_id ";
    @Select({
            sql,
            //"where name like CONCAT('%',#{q},'%') or directive like CONCAT('%',#{q},'%')",
            "LIMIT #{offset},#{limit}"
    })
    @Results({
//            @Result(column="task_id", property="taskId", jdbcType= JdbcType.INTEGER, id=true),
           // @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
            @Result(column="inspection_unit", property="inspectionUnit", jdbcType=JdbcType.VARCHAR),
            @Result(column="old_name", property="oldName", jdbcType=JdbcType.VARCHAR),
            @Result(column="new_name", property="newName", jdbcType=JdbcType.VARCHAR),
            @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.VARCHAR)

    })
    List<TaskLogDTO> selectByFullText(  @Param("offset") int offset, @Param("limit") int limit, @Param("q") String q);

    @Select({
            " select  count(1) from task_log "

    })
    int selectCountByFullText(@Param("q") String q);



    @Select({
           sql1,
            //"where name like CONCAT('%',#{q},'%') or directive like CONCAT('%',#{q},'%')",
            "LIMIT #{offset},#{limit}"
    })
    @Results({
//            @Result(column="task_id", property="taskId", jdbcType= JdbcType.INTEGER, id=true),
           // @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
            @Result(column="inspection_unit", property="inspectionUnit", jdbcType=JdbcType.VARCHAR),
            @Result(column="old_name", property="oldName", jdbcType=JdbcType.VARCHAR),
            @Result(column="new_name", property="newName", jdbcType=JdbcType.VARCHAR),
            @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR)

    })
    List<TaskLogDTO> selectByFullTextBySoure( @Param("source")  String source, @Param("offset") int offset, @Param("limit") int limit, @Param("q") String q);

    @Select({
            " select  count(1) from task_log ",
            " inner join task t on task_log.task_id = t.task_id and t.source =  #{source,jdbcType=VARCHAR} ",
    })
    int selectCountByFullTextBySoure(@Param("source")  String source, @Param("q") String q);

    @Select({
            "select orig_experts_id from task_log where task_id = #{taskid,jdbcType=INTEGER} ",

    })

    @Results({
            @Result(column="task_id", property="taskId", jdbcType= JdbcType.INTEGER, id=true)

    })
    List<TaskLog> queryUpadteLog(@Param("taskid") String taskid);

    @Select({
            "SELECT tl.id, tl.task_id, tl.reason, tl.create_time ,tl.create_user, e0.`name` AS orig_experts_id , e1.`name` AS new_experts_id FROM task_log tl LEFT JOIN experts e0 ON e0.experts_id = tl.orig_experts_id LEFT JOIN experts e1 ON e1.experts_id = tl.new_experts_id WHERE tl.task_id =  #{taskid,jdbcType=INTEGER} ",

    })

    @Results({
            @Result(column="task_id", property="taskId", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="orig_experts_id", property="oldName", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="new_experts_id", property="newName", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="create_user", property="createUser", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="create_time", property="createTime", jdbcType= JdbcType.VARCHAR, id=true)

    })
    List<TaskLogDTO> querytaskLogForTaskId(@Param("taskid") int taskid);
}
