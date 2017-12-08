package com.medicineCenter.dao;

import com.medicineCenter.model.dto.SelectProviderDTO;

/**
 * Created by Administrator on 2016/10/19.
 */
public class TaskSqlProviderExt {
// TODO: 2016/10/20  重构@
    @Deprecated// 方法已过时
        public String selectByFullTextPrselectByFullTextProviderovider(SelectProviderDTO selectProviderDTO){
        String sql = "";
        sql += "select * from task where 1=1 ";
        if (selectProviderDTO.getQ() != null){
            sql += "and (inspection_unit like CONCAT('%" + selectProviderDTO.getQ() + "%')) ";
        }
        if (selectProviderDTO.getDep() != null){
            sql += "and source = '" + selectProviderDTO.getDep() + "' ";
        }
        if (selectProviderDTO.getState() != null){
            sql += "and state = '" + selectProviderDTO.getState() + "' ";
        }
        if (selectProviderDTO.getOffset() != null && selectProviderDTO.getLimit() != null){
            sql += "LIMIT " + selectProviderDTO.getOffset() + "," + selectProviderDTO.getLimit() + "";
        }
        return sql;
    }

    public String selectCountByFullTextBySourceProvider(SelectProviderDTO selectProviderDTO){
        String sql = "";
        sql += "select count(1) from task where 1=1 ";
        if (selectProviderDTO.getQ() != null){
            sql += "and (inspection_unit like CONCAT('%" + selectProviderDTO.getQ() + "%') or task.create_user like CONCAT('%" + selectProviderDTO.getQ() + "%')) ";
        }
        if (selectProviderDTO.getDep() != null){
            sql += "and source = '" + selectProviderDTO.getDep() + "' ";
        }
        if (selectProviderDTO.getState() != null){
            sql += "and state = '" + selectProviderDTO.getState() + "' ";
        }
        if (selectProviderDTO.getOffset() != null && selectProviderDTO.getLimit() != null){
            sql += "LIMIT " + selectProviderDTO.getOffset() + "," + selectProviderDTO.getLimit() + " ";
        }
        return sql;
    }
        //查询
    public String selectFreqAvoidanceNumber(SelectProviderDTO selectProviderDTO){
        String sql = "";
        sql += "SELECT experts_id FROM group_experts ";
        sql += "WHERE( group_experts.state = '已生成' OR group_experts.state = '已完成') ";
        sql += "AND group_experts.task_id IN";
        sql +="( SELECT task1.task_id FROM( SELECT * FROM task  ";
        if (selectProviderDTO.getSource() != null){
            sql += "where task.source = '"+selectProviderDTO.getSource()+"'";
        }
        sql += "ORDER BY task.create_time DESC LIMIT 3) AS task1)";
        return sql;
    }


}
