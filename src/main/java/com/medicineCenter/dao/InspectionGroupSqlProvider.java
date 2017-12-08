package com.medicineCenter.dao;

import com.medicineCenter.model.dataObject.InspectionGroup;
import com.medicineCenter.model.dataObject.InspectionGroupExample.Criteria;
import com.medicineCenter.model.dataObject.InspectionGroupExample.Criterion;
import com.medicineCenter.model.dataObject.InspectionGroupExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class InspectionGroupSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public String countByExample(InspectionGroupExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("inspection_group");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public String deleteByExample(InspectionGroupExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("inspection_group");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public String insertSelective(InspectionGroup record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("inspection_group");

        if (record.getGroupId() != null) {
            sql.VALUES("group_id", "#{groupId,jdbcType=INTEGER}");
        }

        if (record.getTaskId() != null) {
            sql.VALUES("task_id", "#{taskId,jdbcType=INTEGER}");
        }

        if (record.getCategory() != null) {
            sql.VALUES("category", "#{category,jdbcType=VARCHAR}");
        }

        if (record.getCategoryTwo() != null) {
            sql.VALUES("category_two", "#{categoryTwo,jdbcType=VARCHAR}");
        }

        if (record.getNum() != null) {
            sql.VALUES("num", "#{num,jdbcType=INTEGER}");
        }

        if (record.getState() != null) {
            sql.VALUES("state", "#{state,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public String selectByExample(InspectionGroupExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("group_id");
        } else {
            sql.SELECT("group_id");
        }
        sql.SELECT("task_id");
        sql.SELECT("category");
        sql.SELECT("category_two");
        sql.SELECT("num");
        sql.SELECT("state");
        sql.SELECT("create_time");
        sql.FROM("inspection_group");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        InspectionGroup record = (InspectionGroup) parameter.get("record");
        InspectionGroupExample example = (InspectionGroupExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("inspection_group");

        if (record.getGroupId() != null) {
            sql.SET("group_id = #{record.groupId,jdbcType=INTEGER}");
        }

        if (record.getTaskId() != null) {
            sql.SET("task_id = #{record.taskId,jdbcType=INTEGER}");
        }

        if (record.getCategory() != null) {
            sql.SET("category = #{record.category,jdbcType=VARCHAR}");
        }

        if (record.getCategoryTwo() != null) {
            sql.SET("category_two = #{record.categoryTwo,jdbcType=VARCHAR}");
        }

        if (record.getNum() != null) {
            sql.SET("num = #{record.num,jdbcType=INTEGER}");
        }

        if (record.getState() != null) {
            sql.SET("state = #{record.state,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("inspection_group");

        sql.SET("group_id = #{record.groupId,jdbcType=INTEGER}");
        sql.SET("task_id = #{record.taskId,jdbcType=INTEGER}");
        sql.SET("category = #{record.category,jdbcType=VARCHAR}");
        sql.SET("category_two = #{record.categoryTwo,jdbcType=VARCHAR}");
        sql.SET("num = #{record.num,jdbcType=INTEGER}");
        sql.SET("state = #{record.state,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");

        InspectionGroupExample example = (InspectionGroupExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public String updateByPrimaryKeySelective(InspectionGroup record) {
        SQL sql = new SQL();
        sql.UPDATE("inspection_group");

        if (record.getTaskId() != null) {
            sql.SET("task_id = #{taskId,jdbcType=INTEGER}");
        }

        if (record.getCategory() != null) {
            sql.SET("category = #{category,jdbcType=VARCHAR}");
        }

        if (record.getCategoryTwo() != null) {
            sql.SET("category_two = #{categoryTwo,jdbcType=VARCHAR}");
        }

        if (record.getNum() != null) {
            sql.SET("num = #{num,jdbcType=INTEGER}");
        }

        if (record.getState() != null) {
            sql.SET("state = #{state,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        sql.WHERE("group_id = #{groupId,jdbcType=INTEGER}");

        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inspection_group
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    protected void applyWhere(SQL sql, InspectionGroupExample example, boolean includeExamplePhrase) {
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