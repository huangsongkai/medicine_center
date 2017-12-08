package com.medicineCenter.model.dataObject;

import org.apache.commons.lang.builder.EqualsBuilder;

public class TaskInspectionInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_inspection_info.id
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_inspection_info.task_id
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    private Integer taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_inspection_info.inspection_unit
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    private String inspectionUnit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_inspection_info.attribution
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    private String attribution;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_inspection_info.checktype
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    private String checktype;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_inspection_info.id
     *
     * @return the value of task_inspection_info.id
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_inspection_info.id
     *
     * @param id the value for task_inspection_info.id
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_inspection_info.task_id
     *
     * @return the value of task_inspection_info.task_id
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_inspection_info.task_id
     *
     * @param taskId the value for task_inspection_info.task_id
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_inspection_info.inspection_unit
     *
     * @return the value of task_inspection_info.inspection_unit
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    public String getInspectionUnit() {
        return inspectionUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_inspection_info.inspection_unit
     *
     * @param inspectionUnit the value for task_inspection_info.inspection_unit
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    public void setInspectionUnit(String inspectionUnit) {
        this.inspectionUnit = inspectionUnit == null ? null : inspectionUnit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_inspection_info.attribution
     *
     * @return the value of task_inspection_info.attribution
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    public String getAttribution() {
        return attribution;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_inspection_info.attribution
     *
     * @param attribution the value for task_inspection_info.attribution
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    public void setAttribution(String attribution) {
        this.attribution = attribution == null ? null : attribution.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_inspection_info.checktype
     *
     * @return the value of task_inspection_info.checktype
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    public String getChecktype() {
        return checktype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_inspection_info.checktype
     *
     * @param checktype the value for task_inspection_info.checktype
     *
     * @mbggenerated Thu Feb 23 14:28:40 CST 2017
     */
    public void setChecktype(String checktype) {
        this.checktype = checktype == null ? null : checktype.trim();
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
}