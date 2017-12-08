package com.medicineCenter.service;

import com.medicineCenter.dao.TaskMapperExt;
import com.medicineCenter.interfaces.controller.Result;
import com.medicineCenter.model.dataObject.InspectionGroup;
import com.medicineCenter.model.dataObject.Task;
import com.medicineCenter.model.dataObject.TaskExample;
import com.medicineCenter.model.dto.SelectProviderDTO;
import com.medicineCenter.model.dto.TaskDTO;
import com.medicineCenter.util.Page;
import com.medicineCenter.util.PageUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
* Created by song.
*/
@Service
public class TaskCrudService extends BaseService{
    @Resource
    TaskMapperExt taskMapperExt;

    public Result add(Task task) {
        return new Result(taskMapperExt.insert(task),"",task);
    }

    public int update(Task task) {
        return taskMapperExt.updateByPrimaryKeySelective(task);
    }

    public int delete(Task task) {
        return taskMapperExt.deleteByPrimaryKey(task.getTaskId());
    }

    public Task get(int id) {
        return taskMapperExt.selectByPrimaryKey(id);
    }

    public Page<Task> getList(int pageNum, String q, String asc, String desc, String dep,String state) {
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
        //全文检索 优先使用fulltext索引 还可以利用lucence，like等
        if(q != null){
            if ("质量科".equals(dep)){
                dep="";
            }
                //新建一个ProviderDTO为 Provider 传值
                SelectProviderDTO selectProviderDTO = new SelectProviderDTO();
                selectProviderDTO.setOffset((pageNum - 1) * PAGE_SIZE);
                selectProviderDTO.setLimit(PAGE_SIZE);
                selectProviderDTO.setQ(q);
                selectProviderDTO.setDep(dep);
                selectProviderDTO.setState(state);
                taskList = taskMapperExt.selectByFullText(selectProviderDTO);
                totalPage = PageUtil.getPageNum(taskMapperExt.selectCountByFullText(selectProviderDTO));
        }else {
            taskExample.setOrderByClause(orderClause + " " + PageUtil.genPaginationClause(pageNum));
            if (!"质量科".equals(dep)){
                taskExample.or().andSourceEqualTo(dep);
            }
            if (state != null){
                taskExample.or().andStateEqualTo(state);
            }
            taskList = taskMapperExt.selectByExample(taskExample);
            totalPage = totalPage(taskExample);
        }
        page.setCurrentPage(pageNum);
        page.setData(taskList);
        page.setTotalPage(totalPage);
        page.setPageSize(PAGE_SIZE);
        return page;
    }



    public int totalPage(TaskExample example) {
        return PageUtil.getPageNum(taskMapperExt.countByExample(example));
    }

    public Result add(TaskDTO taskDTO) {
        Task task = new Task();
        try {
            BeanUtils.copyProperties(task, taskDTO);//copy对象的属性
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        add(task);
        InspectionGroup inspectionGroup = new InspectionGroup();
        inspectionGroup.setTaskId(task.getTaskId());
        //add(inspectionGroup);
        try {
            BeanUtils.copyProperties(inspectionGroup, taskDTO);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  null;
    }
    public List<TaskDTO> selectByTaskOneReturnTaskDTO(int pageNum, String q){
        return taskMapperExt.selectByTaskOneReturnTaskDTO((pageNum - 1) * PAGE_SIZE, PAGE_SIZE, q);
    }


    public void updateGroupExpertsByState(int taskId) {
        taskMapperExt.updateGroupExpertsByState(taskId);
    }

    public int queryTaskProcessing() {
        //处理中
        int processing = taskMapperExt.queryTaskprocessing();
        return processing;
    }

    public int queryTaskGenerate() {
        //待生成
        int generate = taskMapperExt.queryTaskgenerate();
        return generate;
    }

    public int queryTaskChange() {
        //变更中
        int change = taskMapperExt.queryTaskChange();
        return change;
    }
    //查询在任务中的专家
    public List<Task> selectByEndExecutionTime(String source) {
        return taskMapperExt.selectByEndExecutionTime(source);
    }
}