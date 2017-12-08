package com.medicineCenter.dao;

import com.medicineCenter.model.dataObject.TaskInspectionInfo;
import com.medicineCenter.model.dataObject.TaskInspectionInfoExample;
import com.medicineCenter.model.dataObject.TaskInspectionInfoExample.Criteria;
import com.medicineCenter.model.dataObject.TaskInspectionInfoExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class TaskInspectionInfoSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_inspection_info
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    public String countByExample(TaskInspectionInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("task_inspection_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_inspection_info
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    public String deleteByExample(TaskInspectionInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("task_inspection_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_inspection_info
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    public String insertSelective(TaskInspectionInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("task_inspection_info");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }

        if (record.getTaskId() != null) {
            sql.VALUES("task_id", "#{taskId,jdbcType=INTEGER}");
        }

        if (record.getInspectionUnit() != null) {
            sql.VALUES("inspection_unit", "#{inspectionUnit,jdbcType=VARCHAR}");
        }

        if (record.getAttribution() != null) {
            sql.VALUES("attribution", "#{attribution,jdbcType=VARCHAR}");
        }

        if (record.getChecktype() != null) {
            sql.VALUES("checktype", "#{checktype,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_inspection_info
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    public String selectByExample(TaskInspectionInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("task_id");
        sql.SELECT("inspection_unit");
        sql.SELECT("attribution");
        sql.SELECT("checktype");
        sql.FROM("task_inspection_info");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_inspection_info
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TaskInspectionInfo record = (TaskInspectionInfo) parameter.get("record");
        TaskInspectionInfoExample example = (TaskInspectionInfoExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("task_inspection_info");

        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }

        if (record.getTaskId() != null) {
            sql.SET("task_id = #{record.taskId,jdbcType=INTEGER}");
        }

        if (record.getInspectionUnit() != null) {
            sql.SET("inspection_unit = #{record.inspectionUnit,jdbcType=VARCHAR}");
        }

        if (record.getAttribution() != null) {
            sql.SET("attribution = #{record.attribution,jdbcType=VARCHAR}");
        }

        if (record.getChecktype() != null) {
            sql.SET("checktype = #{record.checktype,jdbcType=VARCHAR}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_inspection_info
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("task_inspection_info");

        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("task_id = #{record.taskId,jdbcType=INTEGER}");
        sql.SET("inspection_unit = #{record.inspectionUnit,jdbcType=VARCHAR}");
        sql.SET("attribution = #{record.attribution,jdbcType=VARCHAR}");
        sql.SET("checktype = #{record.checktype,jdbcType=VARCHAR}");

        TaskInspectionInfoExample example = (TaskInspectionInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_inspection_info
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    public String updateByPrimaryKeySelective(TaskInspectionInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("task_inspection_info");

        if (record.getTaskId() != null) {
            sql.SET("task_id = #{taskId,jdbcType=INTEGER}");
        }

        if (record.getInspectionUnit() != null) {
            sql.SET("inspection_unit = #{inspectionUnit,jdbcType=VARCHAR}");
        }

        if (record.getAttribution() != null) {
            sql.SET("attribution = #{attribution,jdbcType=VARCHAR}");
        }

        if (record.getChecktype() != null) {
            sql.SET("checktype = #{checktype,jdbcType=VARCHAR}");
        }

        sql.WHERE("id = #{id,jdbcType=INTEGER}");

        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_inspection_info
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    protected void applyWhere(SQL sql, TaskInspectionInfoExample example, boolean includeExamplePhrase) {
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