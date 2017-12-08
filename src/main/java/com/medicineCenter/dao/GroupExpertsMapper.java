package com.medicineCenter.dao;

import com.medicineCenter.model.dataObject.GroupExperts;
import com.medicineCenter.model.dataObject.GroupExpertsExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface GroupExpertsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_experts
     *
     * @mbggenerated Wed Oct 12 14:49:18 CST 2016
     */
    @SelectProvider(type=GroupExpertsSqlProvider.class, method="countByExample")
    int countByExample(GroupExpertsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_experts
     *
     * @mbggenerated Wed Oct 12 14:49:18 CST 2016
     */
    @DeleteProvider(type=GroupExpertsSqlProvider.class, method="deleteByExample")
    int deleteByExample(GroupExpertsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_experts
     *
     * @mbggenerated Wed Oct 12 14:49:18 CST 2016
     */
    @Delete({
            "delete from group_experts",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_experts
     *
     * @mbggenerated Wed Oct 12 14:49:18 CST 2016
     */
    @Insert({
            "insert into group_experts (id, experts_id, ",
            "task_id, state, create_time)",
            "values (#{id,jdbcType=INTEGER}, #{expertsId,jdbcType=INTEGER}, ",
            "#{taskId,jdbcType=INTEGER}, #{state,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(GroupExperts record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_experts
     *
     * @mbggenerated Wed Oct 12 14:49:18 CST 2016
     */
    @InsertProvider(type=GroupExpertsSqlProvider.class, method="insertSelective")
    int insertSelective(GroupExperts record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_experts
     *
     * @mbggenerated Wed Oct 12 14:49:18 CST 2016
     */
    @SelectProvider(type=GroupExpertsSqlProvider.class, method="selectByExample")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="experts_id", property="expertsId", jdbcType=JdbcType.INTEGER),
            @Result(column="task_id", property="taskId", jdbcType=JdbcType.INTEGER),
            @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<GroupExperts> selectByExample(GroupExpertsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_experts
     *
     * @mbggenerated Wed Oct 12 14:49:18 CST 2016
     */
    @Select({
            "select",
            "id, experts_id, task_id, state, create_time",
            "from group_experts",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="experts_id", property="expertsId", jdbcType=JdbcType.INTEGER),
            @Result(column="task_id", property="taskId", jdbcType=JdbcType.INTEGER),
            @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    GroupExperts selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_experts
     *
     * @mbggenerated Wed Oct 12 14:49:18 CST 2016
     */
    @UpdateProvider(type=GroupExpertsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") GroupExperts record, @Param("example") GroupExpertsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_experts
     *
     * @mbggenerated Wed Oct 12 14:49:18 CST 2016
     */
    @UpdateProvider(type=GroupExpertsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") GroupExperts record, @Param("example") GroupExpertsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_experts
     *
     * @mbggenerated Wed Oct 12 14:49:18 CST 2016
     */
    @UpdateProvider(type=GroupExpertsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GroupExperts record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_experts
     *
     * @mbggenerated Wed Oct 12 14:49:18 CST 2016
     */
    @Update({
            "update group_experts",
            "set experts_id = #{expertsId,jdbcType=INTEGER},",
            "task_id = #{taskId,jdbcType=INTEGER},",
            "state = #{state,jdbcType=VARCHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(GroupExperts record);
}