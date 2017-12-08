package com.medicineCenter.model.dto;

import com.medicineCenter.model.dataObject.InspectionGroup;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/10/8.
 */
public class TaskTwoDTO {
    private Integer taskId;
    private String inspectionUnit;
    private String source;
    private String createUser;
    private Date createTime;
    private String leaderId;
    private String state;
    private String attribution;
    private String endExecutionTime;
    private String startExecutionTime;
    private List<InspectionGroup> jianguan;
    private List<InspectionGroup> jianyan;
    private List<InspectionGroup> linchuang;
    private List<InspectionGroup> zuzhang;
    private String checktype;

    public String getChecktype() {
        return checktype;
    }

    public void setChecktype(String checktype) {
        this.checktype = checktype;
    }

    public String getEndExecutionTime() {
        return endExecutionTime;
    }

    public void setEndExecutionTime(String endExecutionTime) {
        this.endExecutionTime = endExecutionTime;
    }

    public String getStartExecutionTime() {
        return startExecutionTime;
    }

    public void setStartExecutionTime(String startExecutionTime) {
        this.startExecutionTime = startExecutionTime;
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public List<InspectionGroup> getZuzhang() {
        return zuzhang;
    }

    public void setZuzhang(List<InspectionGroup> zuzhang) {
        this.zuzhang = zuzhang;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getInspectionUnit() {
        return inspectionUnit;
    }

    public void setInspectionUnit(String inspectionUnit) {
        this.inspectionUnit = inspectionUnit;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<InspectionGroup> getJianguan() {
        return jianguan;
    }

    public void setJianguan(List<InspectionGroup> jianguan) {
        this.jianguan = jianguan;
    }

    public List<InspectionGroup> getJianyan() {
        return jianyan;
    }

    public void setJianyan(List<InspectionGroup> jianyan) {
        this.jianyan = jianyan;
    }

    public List<InspectionGroup> getLinchuang() {
        return linchuang;
    }

    public void setLinchuang(List<InspectionGroup> linchuang) {
        this.linchuang = linchuang;
    }
}