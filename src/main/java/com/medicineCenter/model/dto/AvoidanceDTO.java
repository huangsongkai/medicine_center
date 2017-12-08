package com.medicineCenter.model.dto;

import com.medicineCenter.model.dataObject.Experts;

import java.util.List;

/**
 * Created by Administrator on 2016/10/8.
 */
public class AvoidanceDTO {
    private List<Experts> candidateList;//候选
    private List<Experts> confirmedList;//确认
    private String attribution;//归属地
    private String source;
    private String bacteria;
    private int taskId;
    private int expertsId;
    private List<String> excludeAddrs;//要规避掉的地址.
    public List<Experts> expertsList;

    public List<String> getExcludeAddrs() {
        return excludeAddrs;
    }

    public void setExcludeAddrs(List<String> excludeAddrs) {
        this.excludeAddrs = excludeAddrs;
    }

    public int getExpertsId() {
        return expertsId;
    }

    public void setExpertsId(int expertsId) {
        this.expertsId = expertsId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getBacteria() {
        return bacteria;
    }

    public void setBacteria(String bacteria) {
        this.bacteria = bacteria;
    }

    public List<Experts> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(List<Experts> candidateList) {
        this.candidateList = candidateList;
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<Experts> getConfirmedList() {
        return confirmedList;
    }

    public void setConfirmedList(List<Experts> confirmedList) {
        this.confirmedList = confirmedList;
    }
}


