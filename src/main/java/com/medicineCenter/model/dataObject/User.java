package com.medicineCenter.model.dataObject;

import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.Date;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.ID
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.NAME
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.DIRECTIVE
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    private String directive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.MOBILE
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    private String mobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.EMAIL
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.PASSWORD
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USER.CREATE_TIME
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.ID
     *
     * @return the value of USER.ID
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.ID
     *
     * @param id the value for USER.ID
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.NAME
     *
     * @return the value of USER.NAME
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.NAME
     *
     * @param name the value for USER.NAME
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.DIRECTIVE
     *
     * @return the value of USER.DIRECTIVE
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    public String getDirective() {
        return directive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.DIRECTIVE
     *
     * @param directive the value for USER.DIRECTIVE
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    public void setDirective(String directive) {
        this.directive = directive == null ? null : directive.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.MOBILE
     *
     * @return the value of USER.MOBILE
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.MOBILE
     *
     * @param mobile the value for USER.MOBILE
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.EMAIL
     *
     * @return the value of USER.EMAIL
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.EMAIL
     *
     * @param email the value for USER.EMAIL
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.PASSWORD
     *
     * @return the value of USER.PASSWORD
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.PASSWORD
     *
     * @param password the value for USER.PASSWORD
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USER.CREATE_TIME
     *
     * @return the value of USER.CREATE_TIME
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USER.CREATE_TIME
     *
     * @param createTime the value for USER.CREATE_TIME
     *
     * @mbggenerated Wed Sep 21 13:25:28 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
}