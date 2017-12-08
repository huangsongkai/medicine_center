package com.medicineCenter.model.dto;

import com.medicineCenter.model.dataObject.TaskTowChage;

import java.util.List;

/**
 * Created by Administrator on 2016/10/8.
 */
public class TaskChangeDTO {
    private Integer taskId;
    private List<TaskTowChage> expertsIdList;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public List<TaskTowChage> getExpertsIdList() {
        return expertsIdList;
    }

    public void setExpertsIdList(List<TaskTowChage> expertsIdList) {
        this.expertsIdList = expertsIdList;
    }
}
