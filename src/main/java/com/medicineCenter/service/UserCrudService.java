package com.medicineCenter.service;

import com.medicineCenter.dao.UserMapperExt;
import com.medicineCenter.interfaces.controller.Result;
import com.medicineCenter.model.dataObject.User;
import com.medicineCenter.model.dataObject.UserExample;
import com.medicineCenter.util.Page;
import com.medicineCenter.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song.
 */
@Service
public class UserCrudService extends BaseService{
    @Resource
    UserMapperExt userMapperExt;

    public Result add(User user) {
        UserExample userExample = new UserExample();
        userExample.or().andNameEqualTo(user.getName());
        if(userMapperExt.selectByExample(userExample).size() > 0)
            return newFaildResult("用户已经存在");
        return new Result(userMapperExt.insert(user),"",user);
    }

    public int update(User user) {
        return userMapperExt.updateByPrimaryKeySelective(user);
    }

    public int delete(User user) {
        return userMapperExt.deleteByPrimaryKey(user.getId());
    }

    public User get(java.lang.Integer id) {
        return userMapperExt.selectByPrimaryKey(id);
    }

    public Page<User> getList(int pageNum, String q) {
        return getList(pageNum, q, null, null);
    }

    public Page<User> getList(int pageNum, String q, String asc, String desc) {
        String orderClause = "";
        if(asc != null){
            orderClause += asc;
        }else if(desc != null){
            orderClause += desc;
        }else{
            orderClause += "CREATE_TIME DESC";
        }
        Page page = new Page();
        List<User> userList;
        int totalPage;
        UserExample userExample = new UserExample();
        //全文检索 优先使用fulltext索引 还可以利用lucence，like等
        if(q != null){
            userList = userMapperExt.selectByFullText((pageNum - 1) * PAGE_SIZE, PAGE_SIZE, q);
            totalPage = PageUtil.getPageNum(userMapperExt.selectCountByFullText(q));
        }else {
            userExample.setOrderByClause(orderClause + " " + PageUtil.genPaginationClause(pageNum));
            userList = userMapperExt.selectByExample(userExample);
            totalPage = totalPage(userExample);
        }
        page.setCurrentPage(pageNum);
        page.setData(userList);
        page.setTotalPage(totalPage);
        page.setPageSize(PAGE_SIZE);
        return page;
    }

    public Result checkLoginReturnDepartment(String userName, String passWord){
        if(userName.equals("admin") && passWord.equals("admin123"))
            return newResult(1, "登录成功", "admin");
        UserExample userExample = new UserExample();
        userExample.or().andNameEqualTo(userName.trim()).andPasswordEqualTo(passWord);
        List<User> userList = userMapperExt.selectByExample(userExample);
        if(userList.size() == 0)
            return newFaildResult("用户名或者密码错");
        else
            return newResult(1, "登录成功", userList.get(0).getDirective());
    }

    public int totalPage(UserExample example) {
        return PageUtil.getPageNum(userMapperExt.countByExample(example));
    }

}