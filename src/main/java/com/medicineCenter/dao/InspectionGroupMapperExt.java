package com.medicineCenter.dao;
import com.medicineCenter.model.dataObject.InspectionGroup;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface InspectionGroupMapperExt extends InspectionGroupMapper {
    //ALTER TABLE USER ADD FULLTEXT INDEX ft_index (NAME,DIRECTIVE) WITH PARSER ngram;
    @Select({
            "select * from inspectiongroup",
            //"where match(name, directive) against(#{q})",
            //"where name like CONCAT('%',#{q},'%') or directive like CONCAT('%',#{q},'%')",
            "LIMIT #{offset},#{limit}"
    })
    List<InspectionGroup> selectByFullText(@Param("offset") int offset, @Param("limit") int limit, @Param("q") String q);

    @Select({
            "select count(1) from inspectiongroup",
            //"where match(name, directive) against(#{q})",
            //"where name like CONCAT('%',#{q},'%') or directive like CONCAT('%',#{q},'%')",
    })
    int selectCountByFullText(@Param("q") String q);
    @Update({
            "update inspection_group",
            "set task_id = #{taskId,jdbcType=INTEGER},",
            "category = #{category,jdbcType=VARCHAR},",
            "categoryTwo = #{categoryTwo,jdbcType=VARCHAR},",
            "num = #{num,jdbcType=VARCHAR},",
            "state = #{state,jdbcType=VARCHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP}",
            "where task_id = #{taskId,jdbcType=INTEGER}"
    })
    int updateBytaskId(InspectionGroup record);


    @Select({
            "select * from inspection_group ",
            "where task_id = #{taskId,jdbcType=INTEGER}"
    })
    List<InspectionGroup> SelectByTaskId(@Param("taskId") Integer taskId);
}
