package com.medicineCenter.dao;

import com.medicineCenter.model.dataObject.Experts;
import com.medicineCenter.model.dataObject.ExpertsExample;
import com.medicineCenter.model.dataObject.ExpertsExample.Criteria;
import com.medicineCenter.model.dataObject.ExpertsExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class ExpertsSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experts
     *
     * @mbggenerated Wed Dec 14 14:21:08 CST 2016
     */
    public String countByExample(ExpertsExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("experts");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experts
     *
     * @mbggenerated Wed Dec 14 14:21:08 CST 2016
     */
    public String deleteByExample(ExpertsExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("experts");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experts
     *
     * @mbggenerated Wed Dec 14 14:21:08 CST 2016
     */
    public String insertSelective(Experts record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("experts");

        if (record.getExpertsId() != null) {
            sql.VALUES("experts_id", "#{expertsId,jdbcType=INTEGER}");
        }

        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }

        if (record.getGender() != null) {
            sql.VALUES("gender", "#{gender,jdbcType=VARCHAR}");
        }

        if (record.getAge() != null) {
            sql.VALUES("age", "#{age,jdbcType=VARCHAR}");
        }

        if (record.getSchool() != null) {
            sql.VALUES("school", "#{school,jdbcType=VARCHAR}");
        }

        if (record.getDegree() != null) {
            sql.VALUES("degree", "#{degree,jdbcType=VARCHAR}");
        }

        if (record.getWork() != null) {
            sql.VALUES("work", "#{work,jdbcType=VARCHAR}");
        }

        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }

        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }

        if (record.getRemarks() != null) {
            sql.VALUES("remarks", "#{remarks,jdbcType=VARCHAR}");
        }

        if (record.getLeader() != null) {
            sql.VALUES("leader", "#{leader,jdbcType=VARCHAR}");
        }

        if (record.getBacteria() != null) {
            sql.VALUES("bacteria", "#{bacteria,jdbcType=VARCHAR}");
        }

        if (record.getCategory() != null) {
            sql.VALUES("category", "#{category,jdbcType=VARCHAR}");
        }

        if (record.getCategoryTwo() != null) {
            sql.VALUES("category_two", "#{categoryTwo,jdbcType=VARCHAR}");
        }

        if (record.getSource() != null) {
            sql.VALUES("source", "#{source,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getAttribution() != null) {
            sql.VALUES("attribution", "#{attribution,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experts
     *
     * @mbggenerated Wed Dec 14 14:21:08 CST 2016
     */
    public String selectByExample(ExpertsExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("experts_id");
        } else {
            sql.SELECT("experts_id");
        }
        sql.SELECT("name");
        sql.SELECT("gender");
        sql.SELECT("age");
        sql.SELECT("school");
        sql.SELECT("degree");
        sql.SELECT("work");
        sql.SELECT("title");
        sql.SELECT("phone");
        sql.SELECT("remarks");
        sql.SELECT("leader");
        sql.SELECT("bacteria");
        sql.SELECT("category");
        sql.SELECT("category_two");
        sql.SELECT("source");
        sql.SELECT("CREATE_TIME");
        sql.SELECT("attribution");
        sql.FROM("experts");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experts
     *
     * @mbggenerated Wed Dec 14 14:21:08 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Experts record = (Experts) parameter.get("record");
        ExpertsExample example = (ExpertsExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("experts");

        if (record.getExpertsId() != null) {
            sql.SET("experts_id = #{record.expertsId,jdbcType=INTEGER}");
        }

        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }

        if (record.getGender() != null) {
            sql.SET("gender = #{record.gender,jdbcType=VARCHAR}");
        }

        if (record.getAge() != null) {
            sql.SET("age = #{record.age,jdbcType=VARCHAR}");
        }

        if (record.getSchool() != null) {
            sql.SET("school = #{record.school,jdbcType=VARCHAR}");
        }

        if (record.getDegree() != null) {
            sql.SET("degree = #{record.degree,jdbcType=VARCHAR}");
        }

        if (record.getWork() != null) {
            sql.SET("work = #{record.work,jdbcType=VARCHAR}");
        }

        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }

        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }

        if (record.getRemarks() != null) {
            sql.SET("remarks = #{record.remarks,jdbcType=VARCHAR}");
        }

        if (record.getLeader() != null) {
            sql.SET("leader = #{record.leader,jdbcType=VARCHAR}");
        }

        if (record.getBacteria() != null) {
            sql.SET("bacteria = #{record.bacteria,jdbcType=VARCHAR}");
        }

        if (record.getCategory() != null) {
            sql.SET("category = #{record.category,jdbcType=VARCHAR}");
        }

        if (record.getCategoryTwo() != null) {
            sql.SET("category_two = #{record.categoryTwo,jdbcType=VARCHAR}");
        }

        if (record.getSource() != null) {
            sql.SET("source = #{record.source,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getAttribution() != null) {
            sql.SET("attribution = #{record.attribution,jdbcType=VARCHAR}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experts
     *
     * @mbggenerated Wed Dec 14 14:21:08 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("experts");

        sql.SET("experts_id = #{record.expertsId,jdbcType=INTEGER}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("gender = #{record.gender,jdbcType=VARCHAR}");
        sql.SET("age = #{record.age,jdbcType=VARCHAR}");
        sql.SET("school = #{record.school,jdbcType=VARCHAR}");
        sql.SET("degree = #{record.degree,jdbcType=VARCHAR}");
        sql.SET("work = #{record.work,jdbcType=VARCHAR}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        sql.SET("remarks = #{record.remarks,jdbcType=VARCHAR}");
        sql.SET("leader = #{record.leader,jdbcType=VARCHAR}");
        sql.SET("bacteria = #{record.bacteria,jdbcType=VARCHAR}");
        sql.SET("category = #{record.category,jdbcType=VARCHAR}");
        sql.SET("category_two = #{record.categoryTwo,jdbcType=VARCHAR}");
        sql.SET("source = #{record.source,jdbcType=VARCHAR}");
        sql.SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("attribution = #{record.attribution,jdbcType=VARCHAR}");

        ExpertsExample example = (ExpertsExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experts
     *
     * @mbggenerated Wed Dec 14 14:21:08 CST 2016
     */
    public String updateByPrimaryKeySelective(Experts record) {
        SQL sql = new SQL();
        sql.UPDATE("experts");

        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }

        if (record.getGender() != null) {
            sql.SET("gender = #{gender,jdbcType=VARCHAR}");
        }

        if (record.getAge() != null) {
            sql.SET("age = #{age,jdbcType=VARCHAR}");
        }

        if (record.getSchool() != null) {
            sql.SET("school = #{school,jdbcType=VARCHAR}");
        }

        if (record.getDegree() != null) {
            sql.SET("degree = #{degree,jdbcType=VARCHAR}");
        }

        if (record.getWork() != null) {
            sql.SET("work = #{work,jdbcType=VARCHAR}");
        }

        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }

        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }

        if (record.getRemarks() != null) {
            sql.SET("remarks = #{remarks,jdbcType=VARCHAR}");
        }

        if (record.getLeader() != null) {
            sql.SET("leader = #{leader,jdbcType=VARCHAR}");
        }

        if (record.getBacteria() != null) {
            sql.SET("bacteria = #{bacteria,jdbcType=VARCHAR}");
        }

        if (record.getCategory() != null) {
            sql.SET("category = #{category,jdbcType=VARCHAR}");
        }

        if (record.getCategoryTwo() != null) {
            sql.SET("category_two = #{categoryTwo,jdbcType=VARCHAR}");
        }

        if (record.getSource() != null) {
            sql.SET("source = #{source,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getAttribution() != null) {
            sql.SET("attribution = #{attribution,jdbcType=VARCHAR}");
        }

        sql.WHERE("experts_id = #{expertsId,jdbcType=INTEGER}");

        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table experts
     *
     * @mbggenerated Wed Dec 14 14:21:08 CST 2016
     */
    protected void applyWhere(SQL sql, ExpertsExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }

        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }

        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }

                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }

                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }

        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}