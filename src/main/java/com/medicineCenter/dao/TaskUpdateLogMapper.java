package com.medicineCenter.dao;

import com.medicineCenter.model.dataObject.TaskUpdateLog;
import com.medicineCenter.model.dataObject.TaskUpdateLogExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TaskUpdateLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_update_log
     *
     * @mbggenerated Fri Jan 20 16:20:36 CST 2017
     */
    @SelectProvider(type=TaskUpdateLogSqlProvider.class, method="countByExample")
    int countByExample(TaskUpdateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_update_log
     *
     * @mbggenerated Fri Jan 20 16:20:36 CST 2017
     */
    @DeleteProvider(type=TaskUpdateLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(TaskUpdateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_update_log
     *
     * @mbggenerated Fri Jan 20 16:20:36 CST 2017
     */
    @Delete({
            "delete from task_update_log",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_update_log
     *
     * @mbggenerated Fri Jan 20 16:20:36 CST 2017
     */
    @Insert({
            "insert into task_update_log (id, task_id, ",
            "reason, create_time, ",
            "create_user, experts_id)",
            "values (#{id,jdbcType=INTEGER}, #{taskId,jdbcType=INTEGER}, ",
            "#{reason,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{createUser,jdbcType=VARCHAR}, #{expertsId,jdbcType=INTEGER})"
    })
    int insert(TaskUpdateLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_update_log
     *
     * @mbggenerated Fri Jan 20 16:20:36 CST 2017
     */
    @InsertProvider(type=TaskUpdateLogSqlProvider.class, method="insertSelective")
    int insertSelective(TaskUpdateLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_update_log
     *
     * @mbggenerated Fri Jan 20 16:20:36 CST 2017
     */
    @SelectProvider(type=TaskUpdateLogSqlProvider.class, method="selectByExample")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="task_id", property="taskId", jdbcType=JdbcType.INTEGER),
            @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
            @Result(column="experts_id", property="expertsId", jdbcType=JdbcType.INTEGER)
    })
    List<TaskUpdateLog> selectByExample(TaskUpdateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_update_log
     *
     * @mbggenerated Fri Jan 20 16:20:36 CST 2017
     */
    @Select({
            "select",
            "id, task_id, reason, create_time, create_user, experts_id",
            "from task_update_log",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="task_id", property="taskId", jdbcType=JdbcType.INTEGER),
            @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
            @Result(column="experts_id", property="expertsId", jdbcType=JdbcType.INTEGER)
    })
    TaskUpdateLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_update_log
     *
     * @mbggenerated Fri Jan 20 16:20:36 CST 2017
     */
    @UpdateProvider(type=TaskUpdateLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TaskUpdateLog record, @Param("example") TaskUpdateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_update_log
     *
     * @mbggenerated Fri Jan 20 16:20:36 CST 2017
     */
    @UpdateProvider(type=TaskUpdateLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TaskUpdateLog record, @Param("example") TaskUpdateLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_update_log
     *
     * @mbggenerated Fri Jan 20 16:20:36 CST 2017
     */
    @UpdateProvider(type=TaskUpdateLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TaskUpdateLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_update_log
     *
     * @mbggenerated Fri Jan 20 16:20:36 CST 2017
     */
    @Update({
            "update task_update_log",
            "set task_id = #{taskId,jdbcType=INTEGER},",
            "reason = #{reason,jdbcType=VARCHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "create_user = #{createUser,jdbcType=VARCHAR},",
            "experts_id = #{expertsId,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TaskUpdateLog record);
}