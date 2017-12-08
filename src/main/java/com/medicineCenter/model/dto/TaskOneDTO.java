package com.medicineCenter.model.dto;

import com.medicineCenter.model.dataObject.InspectionGroup;

import java.util.List;

/**
 * Created by huang on 2017/1/2.
 */
public class TaskOneDTO {

    private Integer taskId;
    private String inspectionUnit;
    private String source;
    private String createUser;
    private String leaderId;
    private String state;
    private String attribution;
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    private String endExecutionTime;
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    private String startExecutionTime;
    private List<InspectionGroup> linchuang;
    private String checktype;

    public String getChecktype() {
        return checktype;
    }

    public void setChecktype(String checktype) {
        this.checktype = checktype;
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

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
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

    public List<InspectionGroup> getLinchuang() {
        return linchuang;
    }

    public void setLinchuang(List<InspectionGroup> linchuang) {
        this.linchuang = linchuang;
    }
}
