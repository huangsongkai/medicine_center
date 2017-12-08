package com.medicineCenter.dao;
import com.medicineCenter.model.dataObject.Experts;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface ExpertsMapperExt extends ExpertsMapper {
    //ALTER TABLE USER ADD FULLTEXT INDEX ft_index (NAME,DIRECTIVE) WITH PARSER ngram;
    @Select({
    "select * from experts",
    //"where match(name, directive) against(#{q})",
    //"where name like CONCAT('%',#{q},'%') or directive like CONCAT('%',#{q},'%')",
    "LIMIT #{offset},#{limit}"
    })
    List<Experts> selectByFullText(@Param("offset") int offset, @Param("limit") int limit, @Param("q") String q);

    @Select({
    "select count(1) from experts",
    //"where match(name, directive) against(#{q})",
    //"where name like CONCAT('%',#{q},'%') or directive like CONCAT('%',#{q},'%')",
    })
    int selectCountByFullText(@Param("q") String q);
    @Select({
            "select * from experts",
            " where source = #{source}"
            //"where match(name, directive) against(#{q})",
            //"where name like CONCAT('%',#{q},'%') or directive like CONCAT('%',#{q},'%')",
    })
    List<Experts> selectExpertsForSource(@Param("source") String source);
}
