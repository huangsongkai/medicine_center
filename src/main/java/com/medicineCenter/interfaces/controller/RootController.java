package com.medicineCenter.interfaces.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by song on 16/7/21.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/")
public class RootController {
    @RequestMapping("/")
    public String index(Model model){
        return "/user/login";
    }

    @RequestMapping("/crud/{page}")
    public String crudTest(@PathVariable String page){
        return "crud/"+page;
    }

    @RequestMapping("/crud/edit/{id}")
    @ResponseBody
    public TestBean editTest(@PathVariable String id){
        System.out.println(id);
        TestBean testBean = new TestBean();
        testBean.setCreateTime(new Date());
        testBean.setShopAddress("哈尔滨市南岗区");
        testBean.setShopName("百姓大药房");
        testBean.setShopInfoId("500dba0a-64a0-47b4-a5a8-c3e77b0eacb3");
        testBean.setSeq(11);
        testBean.setImgUrl("/static/1.jpg");
        testBean.setGpsX("111");
        testBean.setGpsY("222");
        testBean.setIsSend(1);
        testBean.setCreateUserName("admin");
        return testBean;
    }

    @RequestMapping("/admin")
    public String modal(Model model){
        return "admin";
    }

    class TestBean{
        String shopInfoId;
        String shopName;
        int seq;
        String shopAddress;
        String shopTel;
        int isSend;
        String imgUrl;
        String gpsX;
        String gpsY;
        String createUserName;
        Date createTime;

        public String getShopInfoId() {
            return shopInfoId;
        }

        public void setShopInfoId(String shopInfoId) {
            this.shopInfoId = shopInfoId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public String getShopAddress() {
            return shopAddress;
        }

        public void setShopAddress(String shopAddress) {
            this.shopAddress = shopAddress;
        }

        public String getShopTel() {
            return shopTel;
        }

        public void setShopTel(String shopTel) {
            this.shopTel = shopTel;
        }

        public int getIsSend() {
            return isSend;
        }

        public void setIsSend(int isSend) {
            this.isSend = isSend;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getGpsX() {
            return gpsX;
        }

        public void setGpsX(String gpsX) {
            this.gpsX = gpsX;
        }

        public String getGpsY() {
            return gpsY;
        }

        public void setGpsY(String gpsY) {
            this.gpsY = gpsY;
        }

        public String getCreateUserName() {
            return createUserName;
        }

        public void setCreateUserName(String createUserName) {
            this.createUserName = createUserName;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }


    }

}
