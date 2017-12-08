package com.medicineCenter.model.dto;

import com.medicineCenter.model.dataObject.InspectionGroup;
import com.medicineCenter.model.dataObject.TaskInspectionInfo;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/10/8.
 */
public class TaskDTO {
    /**
     * 主键
     */
    private Integer taskId;
    /**
     * 检测单位
     */
    private String inspectionUnit;
    /**
     * 科室
     */
    private String source;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 检查时间
     */
    private Date executionTime;
    private String leaderId;
    private String state;
    private Integer leaderNum;
    private Integer expertsId;
    private String bacteria;
    private String attribution;
    private String endExecutionTime; //结束时间
    private String startExecutionTime;// 开始时间
    private String checktype;
    private List<TaskInspectionInfo> inspectionUnitList;//接收多个单位,多个归属地

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

    public String getBacteria() {
        return bacteria;
    }

    public void setBacteria(String bacteria) {
        this.bacteria = bacteria;
    }

    private List<InspectionGroup> GroupList;

    public Integer getExpertsId() {
        return expertsId;
    }

    public void setExpertsId(Integer expertsId) {
        this.expertsId = expertsId;
    }

    public Integer getLeaderNum() {
        return leaderNum;
    }

    public void setLeaderNum(Integer leaderNum) {
        this.leaderNum = leaderNum;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<InspectionGroup> getGroupList() {
        return GroupList;
    }

    public List<TaskInspectionInfo> getInspectionUnitList() {
        return inspectionUnitList;
    }

    public void setInspectionUnitList(List<TaskInspectionInfo> inspectionUnitList) {
        this.inspectionUnitList = inspectionUnitList;
    }

    public void setGroupList(List<InspectionGroup> groupList) {
        GroupList = groupList;
    }
}


