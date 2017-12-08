package com.medicineCenter.service;

import com.medicineCenter.dao.TaskInspectionInfoMapperExt;
import com.medicineCenter.interfaces.controller.Result;
import com.medicineCenter.model.dataObject.TaskInspectionInfo;
import com.medicineCenter.model.dataObject.TaskInspectionInfoExample;
import com.medicineCenter.util.Page;
import com.medicineCenter.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by song.
*/
@Service
public class TaskInspectionInfoCrudService extends BaseService{
    @Resource
    TaskInspectionInfoMapperExt taskinspectioninfoMapperExt;

    public Result add(TaskInspectionInfo taskinspectioninfo) {
        return new Result(taskinspectioninfoMapperExt.insert(taskinspectioninfo),"",taskinspectioninfo);
    }

    public int update(TaskInspectionInfo taskinspectioninfo) {
        return taskinspectioninfoMapperExt.updateByPrimaryKeySelective(taskinspectioninfo);
    }

    public int delete(TaskInspectionInfo taskinspectioninfo) {
        return taskinspectioninfoMapperExt.deleteByPrimaryKey(taskinspectioninfo.getId());
    }

    public TaskInspectionInfo get(java.lang.Integer id) {
        return taskinspectioninfoMapperExt.selectByPrimaryKey(id);
    }

    public Page<TaskInspectionInfo> getList(int pageNum, String q) {
        return getList(pageNum, q, null, null);
    }

    public Page<TaskInspectionInfo> getList(int pageNum, String q, String asc, String desc) {
        String orderClause = "";
        if(asc != null){
            orderClause += asc;
        }else if(desc != null){
            orderClause += desc;
        }else{
            orderClause += "CREATE_TIME DESC";
        }
        Page page = new Page();
        List<TaskInspectionInfo> taskinspectioninfoList;
        int totalPage;
        TaskInspectionInfoExample taskinspectioninfoExample = new TaskInspectionInfoExample();
        //全文检索 优先使用fulltext索引 还可以利用lucence，like等
        if(q != null){
            taskinspectioninfoList = taskinspectioninfoMapperExt.selectByFullText((pageNum - 1) * PAGE_SIZE, PAGE_SIZE, q);
            totalPage = PageUtil.getPageNum(taskinspectioninfoMapperExt.selectCountByFullText(q));
        }else {
            taskinspectioninfoExample.setOrderByClause(orderClause + " " + PageUtil.genPaginationClause(pageNum));
            taskinspectioninfoList = taskinspectioninfoMapperExt.selectByExample(taskinspectioninfoExample);
            totalPage = totalPage(taskinspectioninfoExample);
        }
        page.setCurrentPage(pageNum);
        page.setData(taskinspectioninfoList);
        page.setTotalPage(totalPage);
        page.setPageSize(PAGE_SIZE);
        return page;
    }

    public int totalPage(TaskInspectionInfoExample example) {
        return PageUtil.getPageNum(taskinspectioninfoMapperExt.countByExample(example));
    }
    //根据taskId查询
    public List<TaskInspectionInfo> getTaskId(int taskId) {
        TaskInspectionInfoExample taskinspectioninfoExample = new TaskInspectionInfoExample();
        taskinspectioninfoExample.or().andTaskIdEqualTo(taskId);
        return taskinspectioninfoMapperExt.selectByExample(taskinspectioninfoExample);
    }
}