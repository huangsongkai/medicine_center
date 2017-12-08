package com.medicineCenter.dao;
import com.medicineCenter.model.dataObject.ExpertsInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface ExpertsInfoMapperExt extends ExpertsInfoMapper {
    //ALTER TABLE USER ADD FULLTEXT INDEX ft_index (NAME,DIRECTIVE) WITH PARSER ngram;
    @Select({
    "select * from expertsinfo",
    //"where match(name, directive) against(#{q})",
    //"where name like CONCAT('%',#{q},'%') or directive like CONCAT('%',#{q},'%')",
    "LIMIT #{offset},#{limit}"
    })
    List<ExpertsInfo> selectByFullText(@Param("offset") int offset, @Param("limit") int limit, @Param("q") String q);

    @Select({
    "select count(1) from expertsinfo",
    //"where match(name, directive) against(#{q})",
    //"where name like CONCAT('%',#{q},'%') or directive like CONCAT('%',#{q},'%')",
    })
    int selectCountByFullText(@Param("q") String q);
}
