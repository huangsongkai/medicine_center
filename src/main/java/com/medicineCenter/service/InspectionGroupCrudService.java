package com.medicineCenter.service;

import com.medicineCenter.dao.InspectionGroupMapperExt;
import com.medicineCenter.interfaces.controller.Result;
import com.medicineCenter.model.dataObject.InspectionGroup;
import com.medicineCenter.model.dataObject.InspectionGroupExample;
import com.medicineCenter.util.Page;
import com.medicineCenter.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song.
 */
@Service
public class InspectionGroupCrudService extends BaseService{
    @Resource
    InspectionGroupMapperExt inspectiongroupMapperExt;

    public Result add(InspectionGroup inspectiongroup) {
        return new Result(inspectiongroupMapperExt.insert(inspectiongroup),"",inspectiongroup);
    }

    public int update(InspectionGroup inspectiongroup) {
        return inspectiongroupMapperExt.updateByPrimaryKeySelective(inspectiongroup);
    }

    public int delete(InspectionGroup inspectiongroup) {
        return inspectiongroupMapperExt.deleteByPrimaryKey(inspectiongroup.getGroupId());
    }

    public InspectionGroup get(java.lang.Integer id) {
        return inspectiongroupMapperExt.selectByPrimaryKey(id);
    }

    public Page<InspectionGroup> getList(int pageNum, String q) {
        return getList(pageNum, q, null, null);
    }

    public Page<InspectionGroup> getList(int pageNum, String q, String asc, String desc) {
        String orderClause = "";
        if(asc != null){
            orderClause += asc;
        }else if(desc != null){
            orderClause += desc;
        }else{
            orderClause += "CREATE_TIME DESC";
        }
        Page page = new Page();
        List<InspectionGroup> inspectiongroupList;
        int totalPage;
        InspectionGroupExample inspectiongroupExample = new InspectionGroupExample();
        //全文检索 优先使用fulltext索引 还可以利用lucence，like等
        if(q != null){
            inspectiongroupList = inspectiongroupMapperExt.selectByFullText((pageNum - 1) * PAGE_SIZE, PAGE_SIZE, q);
            totalPage = PageUtil.getPageNum(inspectiongroupMapperExt.selectCountByFullText(q));
        }else {
            inspectiongroupExample.setOrderByClause(orderClause + " " + PageUtil.genPaginationClause(pageNum));
            inspectiongroupList = inspectiongroupMapperExt.selectByExample(inspectiongroupExample);
            totalPage = totalPage(inspectiongroupExample);
        }
        page.setCurrentPage(pageNum);
        page.setData(inspectiongroupList);
        page.setTotalPage(totalPage);
        page.setPageSize(PAGE_SIZE);
        return page;
    }

    public int totalPage(InspectionGroupExample example) {
        return PageUtil.getPageNum(inspectiongroupMapperExt.countByExample(example));
    }


    public int updateBytaskId(InspectionGroup inspectiongroup) {
        return inspectiongroupMapperExt.updateBytaskId(inspectiongroup);
    }

    public List<InspectionGroup> selectByTaskId(Integer taskId) {
        return inspectiongroupMapperExt.SelectByTaskId(taskId);
    }

    public int updateByExample(InspectionGroupExample inspectionGroupExample, InspectionGroup inspectionGroup) {
        return inspectiongroupMapperExt.updateByExample(inspectionGroup,inspectionGroupExample);
    }
}