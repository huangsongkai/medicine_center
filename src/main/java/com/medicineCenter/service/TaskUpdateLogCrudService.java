package com.medicineCenter.service;

import com.medicineCenter.dao.TaskUpdateLogMapperExt;
import com.medicineCenter.interfaces.controller.Result;
import com.medicineCenter.model.dataObject.TaskUpdateLog;
import com.medicineCenter.model.dataObject.TaskUpdateLogExample;
import com.medicineCenter.util.Page;
import com.medicineCenter.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by song.
*/
@Service
public class TaskUpdateLogCrudService extends BaseService{
    @Resource
    TaskUpdateLogMapperExt taskupdatelogMapperExt;

    public Result add(TaskUpdateLog taskupdatelog) {
        return new Result(taskupdatelogMapperExt.insert(taskupdatelog),"",taskupdatelog);
    }

    public int update(TaskUpdateLog taskupdatelog) {
        return taskupdatelogMapperExt.updateByPrimaryKeySelective(taskupdatelog);
    }

    public int delete(TaskUpdateLog taskupdatelog) {
        return taskupdatelogMapperExt.deleteByPrimaryKey(taskupdatelog.getId());
    }

    public TaskUpdateLog get(java.lang.Integer id) {
        return taskupdatelogMapperExt.selectByPrimaryKey(id);
    }

    public Page<TaskUpdateLog> getList(int pageNum, String q) {
        return getList(pageNum, q, null, null);
    }

    public Page<TaskUpdateLog> getList(int pageNum, String q, String asc, String desc) {
        String orderClause = "";
        if(asc != null){
            orderClause += asc;
        }else if(desc != null){
            orderClause += desc;
        }else{
            orderClause += "CREATE_TIME DESC";
        }
        Page page = new Page();
        List<TaskUpdateLog> taskupdatelogList;
        int totalPage;
        TaskUpdateLogExample taskupdatelogExample = new TaskUpdateLogExample();
        //全文检索 优先使用fulltext索引 还可以利用lucence，like等
        if(q != null){
            taskupdatelogList = taskupdatelogMapperExt.selectByFullText((pageNum - 1) * PAGE_SIZE, PAGE_SIZE, q);
            totalPage = PageUtil.getPageNum(taskupdatelogMapperExt.selectCountByFullText(q));
        }else {
            taskupdatelogExample.setOrderByClause(orderClause + " " + PageUtil.genPaginationClause(pageNum));
            taskupdatelogList = taskupdatelogMapperExt.selectByExample(taskupdatelogExample);
            totalPage = totalPage(taskupdatelogExample);
        }
        page.setCurrentPage(pageNum);
        page.setData(taskupdatelogList);
        page.setTotalPage(totalPage);
        page.setPageSize(PAGE_SIZE);
        return page;
    }

    public int totalPage(TaskUpdateLogExample example) {
        return PageUtil.getPageNum(taskupdatelogMapperExt.countByExample(example));
    }


    public String selectTaskIdAndExpertsId(int taskId, Integer expertsId) {
        TaskUpdateLogExample taskupdatelogExample = new TaskUpdateLogExample();
        taskupdatelogExample.or().andTaskIdEqualTo(taskId);
        taskupdatelogExample.or().andExpertsIdEqualTo(expertsId);
        List<TaskUpdateLog> taskupdatelogList = taskupdatelogMapperExt.selectByExample(taskupdatelogExample);
        if (taskupdatelogList!=null && taskupdatelogList.size() != 0){
            return taskupdatelogList.get(0).getReason();
        }
        return "";
    }
}