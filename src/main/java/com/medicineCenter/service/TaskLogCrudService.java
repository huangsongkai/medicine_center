package com.medicineCenter.service;

import com.medicineCenter.dao.TaskLogMapperExt;
import com.medicineCenter.interfaces.controller.Result;
import com.medicineCenter.model.dataObject.TaskLog;
import com.medicineCenter.model.dataObject.TaskLogExample;
import com.medicineCenter.model.dto.TaskLogDTO;
import com.medicineCenter.util.Page;
import com.medicineCenter.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song.
 */
@Service
public class TaskLogCrudService extends BaseService{
    @Resource
    TaskLogMapperExt tasklogMapperExt;

    public Result add(TaskLog tasklog) {
        return new Result(tasklogMapperExt.insert(tasklog),"",tasklog);
    }

    public int update(TaskLog tasklog) {
        return tasklogMapperExt.updateByPrimaryKeySelective(tasklog);
    }

    public int delete(TaskLog tasklog) {
        return tasklogMapperExt.deleteByPrimaryKey(tasklog.getId());
    }

    public TaskLog get(java.lang.Integer id) {
        return tasklogMapperExt.selectByPrimaryKey(id);
    }


    public Page<TaskLogDTO> getList(String source, int pageNum, String q, String asc, String desc) {
        String orderClause = "";
        if(asc != null){
            orderClause += asc;
        }else if(desc != null){
            orderClause += desc;
        }else{
            orderClause += "CREATE_TIME DESC";
        }
        Page page = new Page();
        List<TaskLogDTO> tasklogList;
        int totalPage;
        TaskLogExample tasklogExample = new TaskLogExample();
        if("d1".equals(source))
            source = "一科";
        else if ("d2".equals(source))
            source = "二科";
        else if ("d3".equals(source))
            source = "三科";
        else if ("d4".equals(source))
            source = "四科";
        else if ("d5".equals(source))
            source = "五科";
        else if ("d6".equals(source))
            source = "六科";
        else
            source = null;
        if (source != null){
            tasklogList = tasklogMapperExt.selectByFullTextBySoure( source, (pageNum - 1) * PAGE_SIZE, PAGE_SIZE, q);
            totalPage = PageUtil.getPageNum(tasklogMapperExt.selectCountByFullTextBySoure(source,q));
        }else{
            tasklogList = tasklogMapperExt.selectByFullText( (pageNum - 1) * PAGE_SIZE, PAGE_SIZE, q);
            totalPage = PageUtil.getPageNum(tasklogMapperExt.selectCountByFullText(q));
        }

        page.setCurrentPage(pageNum);
        page.setData(tasklogList);
        page.setTotalPage(totalPage);
        page.setPageSize(PAGE_SIZE);
        return page;
    }

    public int totalPage(TaskLogExample example) {
        return PageUtil.getPageNum(tasklogMapperExt.countByExample(example));
    }


    /**
     *查询更换记录
     */
    public List<TaskLog> queryUpadteLog(String taskid){
        List<TaskLog> experts = tasklogMapperExt.queryUpadteLog(taskid);
        return experts;
    }

    /**
     * 查询修改记录
     * @param taskid
     * @return
     */
    public List<TaskLogDTO> querytaskLogForTaskId(int taskid){
        List<TaskLogDTO> taskLogList = tasklogMapperExt.querytaskLogForTaskId(taskid);
        return taskLogList;
    }
}