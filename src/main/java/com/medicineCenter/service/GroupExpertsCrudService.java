package com.medicineCenter.service;

import com.medicineCenter.dao.GroupExpertsMapperExt;
import com.medicineCenter.interfaces.controller.Result;
import com.medicineCenter.model.dataObject.*;
import com.medicineCenter.model.dto.ExpertsTaskDTO;
import com.medicineCenter.util.Page;
import com.medicineCenter.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by song.
*/
@Service
public class GroupExpertsCrudService extends BaseService{
    @Resource
    GroupExpertsMapperExt groupexpertsMapperExt;

    public Result add(GroupExperts groupexperts) {
        return new Result(groupexpertsMapperExt.insert(groupexperts),"",groupexperts);
    }

    public int update(GroupExperts groupexperts) {
        return groupexpertsMapperExt.updateByPrimaryKeySelective(groupexperts);
    }

    public int delete(GroupExperts groupexperts) {
        return groupexpertsMapperExt.deleteByPrimaryKey(groupexperts.getId());
    }

    public GroupExperts get(java.lang.Integer id) {
        return groupexpertsMapperExt.selectByPrimaryKey(id);
    }

    public Page<GroupExperts> getList(int pageNum, String q) {
        return getList(pageNum, q, null, null);
    }

    public Page<GroupExperts> getList(int pageNum, String q, String asc, String desc) {
        String orderClause = "";
        if(asc != null){
            orderClause += asc;
        }else if(desc != null){
            orderClause += desc;
        }else{
            orderClause += "CREATE_TIME DESC";
        }
        Page page = new Page();
        List<GroupExperts> groupexpertsList;
        int totalPage;
        GroupExpertsExample groupexpertsExample = new GroupExpertsExample();
        //全文检索 优先使用fulltext索引 还可以利用lucence，like等
        if(q != null){
            groupexpertsList = groupexpertsMapperExt.selectByFullText((pageNum - 1) * PAGE_SIZE, PAGE_SIZE, q);
            totalPage = PageUtil.getPageNum(groupexpertsMapperExt.selectCountByFullText(q));
        }else {
            groupexpertsExample.setOrderByClause(orderClause + " " + PageUtil.genPaginationClause(pageNum));
            groupexpertsList = groupexpertsMapperExt.selectByExample(groupexpertsExample);
            totalPage = totalPage(groupexpertsExample);
        }
        page.setCurrentPage(pageNum);
        page.setData(groupexpertsList);
        page.setTotalPage(totalPage);
        page.setPageSize(PAGE_SIZE);
        return page;
    }

    public int totalPage(GroupExpertsExample example) {
        return PageUtil.getPageNum(groupexpertsMapperExt.countByExample(example));
    }


    public List<GroupExperts> getByTaskId(int id) {
        GroupExpertsExample example = new GroupExpertsExample();
        example.or().andTaskIdEqualTo(id);
        List<GroupExperts> groupExpertsList = groupexpertsMapperExt.selectByExample(example);
        return groupExpertsList;
    }
    public GroupExperts  selectByTaskIdAndExpertsId(int taskId, int expertsId) {
        GroupExpertsExample example = new GroupExpertsExample();
        example.or().andTaskIdEqualTo(taskId).andExpertsIdEqualTo(expertsId);
        List<GroupExperts> groupExpertsList = groupexpertsMapperExt.selectByExample(example);
        GroupExperts groupExperts = new GroupExperts();
        if (groupExpertsList != null && groupExpertsList.size() != 0){
             groupExperts = groupExpertsList.get(0);
        }
        return groupExperts;
    }

    public Page<ExpertsTaskDTO> queryExpertsTask(int pageNum, String q, String asc, String desc, String source) {

        String orderClause = "";
        if(asc != null){
            orderClause += asc;
        }else if(desc != null){
            orderClause += desc;
        }else{
            orderClause += "CREATE_TIME DESC";
        }
        Page page = new Page();
        List<Task> taskList;
        int totalPage;
        TaskExample taskExample = new TaskExample();
        totalPage = PageUtil.getPageNum(groupexpertsMapperExt.selectCountByFullText(q));
        List<ExpertsTaskDTO> expertsTaskDTO = groupexpertsMapperExt.queryExpertsTask((pageNum - 1) * PAGE_SIZE, PAGE_SIZE, q);
        page.setCurrentPage(pageNum);
        page.setData(expertsTaskDTO);
        page.setTotalPage(totalPage);
        page.setPageSize(PAGE_SIZE);
        return page;
    }

    public List<GroupExperts> ExpertsListForTaskId(int taskId) {
        GroupExpertsExample example = new GroupExpertsExample();
        example.or().andTaskIdEqualTo(taskId);
        List<GroupExperts> groupExpertsList = groupexpertsMapperExt.selectByExample(example);
        return groupExpertsList;
    }
}