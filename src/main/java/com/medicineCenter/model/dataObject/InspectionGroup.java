package com.medicineCenter.model.dataObject;

import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.Date;

public class InspectionGroup {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inspection_group.group_id
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    private Integer groupId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inspection_group.task_id
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    private Integer taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inspection_group.category
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    private String category;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inspection_group.category_two
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    private String categoryTwo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inspection_group.num
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    private Integer num;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inspection_group.state
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    private String state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inspection_group.create_time
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inspection_group.group_id
     *
     * @return the value of inspection_group.group_id
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inspection_group.group_id
     *
     * @param groupId the value for inspection_group.group_id
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inspection_group.task_id
     *
     * @return the value of inspection_group.task_id
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inspection_group.task_id
     *
     * @param taskId the value for inspection_group.task_id
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inspection_group.category
     *
     * @return the value of inspection_group.category
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inspection_group.category
     *
     * @param category the value for inspection_group.category
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inspection_group.category_two
     *
     * @return the value of inspection_group.category_two
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public String getCategoryTwo() {
        return categoryTwo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inspection_group.category_two
     *
     * @param categoryTwo the value for inspection_group.category_two
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public void setCategoryTwo(String categoryTwo) {
        this.categoryTwo = categoryTwo == null ? null : categoryTwo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inspection_group.num
     *
     * @return the value of inspection_group.num
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public Integer getNum() {
        return num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inspection_group.num
     *
     * @param num the value for inspection_group.num
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inspection_group.state
     *
     * @return the value of inspection_group.state
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inspection_group.state
     *
     * @param state the value for inspection_group.state
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inspection_group.create_time
     *
     * @return the value of inspection_group.create_time
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inspection_group.create_time
     *
     * @param createTime the value for inspection_group.create_time
     *
     * @mbggenerated Tue Oct 25 16:10:38 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
}