package com.medicineCenter.dao;

import com.medicineCenter.model.dataObject.InspectionGroup;
import com.medicineCenter.model.dataObject.InspectionGroupExample;
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

public interface InspectionGroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    @SelectProvider(type=InspectionGroupSqlProvider.class, method="countByExample")
    int countByExample(InspectionGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    @DeleteProvider(type=InspectionGroupSqlProvider.class, method="deleteByExample")
    int deleteByExample(InspectionGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    @Delete({
            "delete from inspection_group",
            "where group_id = #{groupId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer groupId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    @Insert({
            "insert into inspection_group (group_id, task_id, ",
            "category, category_two, ",
            "num, state, create_time)",
            "values (#{groupId,jdbcType=INTEGER}, #{taskId,jdbcType=INTEGER}, ",
            "#{category,jdbcType=VARCHAR}, #{categoryTwo,jdbcType=VARCHAR}, ",
            "#{num,jdbcType=INTEGER}, #{state,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(InspectionGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    @InsertProvider(type=InspectionGroupSqlProvider.class, method="insertSelective")
    int insertSelective(InspectionGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    @SelectProvider(type=InspectionGroupSqlProvider.class, method="selectByExample")
    @Results({
            @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="task_id", property="taskId", jdbcType=JdbcType.INTEGER),
            @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
            @Result(column="category_two", property="categoryTwo", jdbcType=JdbcType.VARCHAR),
            @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
            @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<InspectionGroup> selectByExample(InspectionGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    @Select({
            "select",
            "group_id, task_id, category, category_two, num, state, create_time",
            "from inspection_group",
            "where group_id = #{groupId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="task_id", property="taskId", jdbcType=JdbcType.INTEGER),
            @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
            @Result(column="category_two", property="categoryTwo", jdbcType=JdbcType.VARCHAR),
            @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
            @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    InspectionGroup selectByPrimaryKey(Integer groupId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    @UpdateProvider(type=InspectionGroupSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") InspectionGroup record, @Param("example") InspectionGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    @UpdateProvider(type=InspectionGroupSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") InspectionGroup record, @Param("example") InspectionGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    @UpdateProvider(type=InspectionGroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(InspectionGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    @Update({
            "update inspection_group",
            "set task_id = #{taskId,jdbcType=INTEGER},",
            "category = #{category,jdbcType=VARCHAR},",
            "category_two = #{categoryTwo,jdbcType=VARCHAR},",
            "num = #{num,jdbcType=INTEGER},",
            "state = #{state,jdbcType=VARCHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP}",
            "where group_id = #{groupId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(InspectionGroup record);
}