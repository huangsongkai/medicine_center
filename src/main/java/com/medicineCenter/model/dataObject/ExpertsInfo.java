package com.medicineCenter.model.dataObject;

import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.Date;

public class ExpertsInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column experts_info.experts_id
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    private Integer expertsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column experts_info.name
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column experts_info.gender
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    private String gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column experts_info.age
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    private String age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column experts_info.school
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    private String school;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column experts_info.degree
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    private String degree;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column experts_info.work
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    private String work;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column experts_info.title
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column experts_info.phone
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column experts_info.remarks
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column experts_info.leader
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    private String leader;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column experts_info.bacteria
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    private String bacteria;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column experts_info.category_one
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    private String categoryOne;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column experts_info.category_two
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    private String categoryTwo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column experts_info.source
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    private String source;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column experts_info.CREATE_TIME
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column experts_info.experts_id
     *
     * @return the value of experts_info.experts_id
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public Integer getExpertsId() {
        return expertsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column experts_info.experts_id
     *
     * @param expertsId the value for experts_info.experts_id
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public void setExpertsId(Integer expertsId) {
        this.expertsId = expertsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column experts_info.name
     *
     * @return the value of experts_info.name
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column experts_info.name
     *
     * @param name the value for experts_info.name
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column experts_info.gender
     *
     * @return the value of experts_info.gender
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column experts_info.gender
     *
     * @param gender the value for experts_info.gender
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column experts_info.age
     *
     * @return the value of experts_info.age
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public String getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column experts_info.age
     *
     * @param age the value for experts_info.age
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column experts_info.school
     *
     * @return the value of experts_info.school
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public String getSchool() {
        return school;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column experts_info.school
     *
     * @param school the value for experts_info.school
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column experts_info.degree
     *
     * @return the value of experts_info.degree
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public String getDegree() {
        return degree;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column experts_info.degree
     *
     * @param degree the value for experts_info.degree
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column experts_info.work
     *
     * @return the value of experts_info.work
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public String getWork() {
        return work;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column experts_info.work
     *
     * @param work the value for experts_info.work
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public void setWork(String work) {
        this.work = work == null ? null : work.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column experts_info.title
     *
     * @return the value of experts_info.title
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column experts_info.title
     *
     * @param title the value for experts_info.title
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column experts_info.phone
     *
     * @return the value of experts_info.phone
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column experts_info.phone
     *
     * @param phone the value for experts_info.phone
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column experts_info.remarks
     *
     * @return the value of experts_info.remarks
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column experts_info.remarks
     *
     * @param remarks the value for experts_info.remarks
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column experts_info.leader
     *
     * @return the value of experts_info.leader
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public String getLeader() {
        return leader;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column experts_info.leader
     *
     * @param leader the value for experts_info.leader
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public void setLeader(String leader) {
        this.leader = leader == null ? null : leader.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column experts_info.bacteria
     *
     * @return the value of experts_info.bacteria
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public String getBacteria() {
        return bacteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column experts_info.bacteria
     *
     * @param bacteria the value for experts_info.bacteria
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public void setBacteria(String bacteria) {
        this.bacteria = bacteria == null ? null : bacteria.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column experts_info.category_one
     *
     * @return the value of experts_info.category_one
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public String getCategoryOne() {
        return categoryOne;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column experts_info.category_one
     *
     * @param categoryOne the value for experts_info.category_one
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public void setCategoryOne(String categoryOne) {
        this.categoryOne = categoryOne == null ? null : categoryOne.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column experts_info.category_two
     *
     * @return the value of experts_info.category_two
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public String getCategoryTwo() {
        return categoryTwo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column experts_info.category_two
     *
     * @param categoryTwo the value for experts_info.category_two
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public void setCategoryTwo(String categoryTwo) {
        this.categoryTwo = categoryTwo == null ? null : categoryTwo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column experts_info.source
     *
     * @return the value of experts_info.source
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public String getSource() {
        return source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column experts_info.source
     *
     * @param source the value for experts_info.source
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column experts_info.CREATE_TIME
     *
     * @return the value of experts_info.CREATE_TIME
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column experts_info.CREATE_TIME
     *
     * @param createTime the value for experts_info.CREATE_TIME
     *
     * @mbggenerated Tue Oct 18 10:07:52 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

}