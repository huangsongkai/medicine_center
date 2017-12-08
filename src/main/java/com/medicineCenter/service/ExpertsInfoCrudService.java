package com.medicineCenter.service;

import com.medicineCenter.dao.ExpertsInfoMapperExt;
import com.medicineCenter.interfaces.controller.Result;
import com.medicineCenter.model.dataObject.ExpertsInfo;
import com.medicineCenter.model.dataObject.ExpertsInfoExample;
import com.medicineCenter.util.Page;
import com.medicineCenter.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by song.
*/
@Service
public class ExpertsInfoCrudService extends BaseService{
    @Resource
    ExpertsInfoMapperExt expertsinfoMapperExt;

    public Result add(ExpertsInfo expertsinfo) {
        return new Result(expertsinfoMapperExt.insert(expertsinfo),"",expertsinfo);
    }

    public int update(ExpertsInfo expertsinfo) {
        return expertsinfoMapperExt.updateByPrimaryKeySelective(expertsinfo);
    }

    public int delete(ExpertsInfo expertsinfo) {
        return expertsinfoMapperExt.deleteByPrimaryKey(expertsinfo.getExpertsId());
    }

    public ExpertsInfo get(java.lang.Integer id) {
        return expertsinfoMapperExt.selectByPrimaryKey(id);
    }

    public Page<ExpertsInfo> getList(int pageNum, String q) {
        return getList(pageNum, q, null, null);
    }

    public Page<ExpertsInfo> getList(int pageNum, String q, String asc, String desc) {
        String orderClause = "";
        if(asc != null){
            orderClause += asc;
        }else if(desc != null){
            orderClause += desc;
        }else{
            orderClause += "CREATE_TIME DESC";
        }
        Page page = new Page();
        List<ExpertsInfo> expertsinfoList;
        int totalPage;
        ExpertsInfoExample expertsinfoExample = new ExpertsInfoExample();
        //全文检索 优先使用fulltext索引 还可以利用lucence，like等
        if(q != null){
            expertsinfoList = expertsinfoMapperExt.selectByFullText((pageNum - 1) * PAGE_SIZE, PAGE_SIZE, q);
            totalPage = PageUtil.getPageNum(expertsinfoMapperExt.selectCountByFullText(q));
        }else {
            expertsinfoExample.setOrderByClause(orderClause + " " + PageUtil.genPaginationClause(pageNum));
            expertsinfoList = expertsinfoMapperExt.selectByExample(expertsinfoExample);
            totalPage = totalPage(expertsinfoExample);
        }
        page.setCurrentPage(pageNum);
        page.setData(expertsinfoList);
        page.setTotalPage(totalPage);
        page.setPageSize(PAGE_SIZE);
        return page;
    }

    public int totalPage(ExpertsInfoExample example) {
        return PageUtil.getPageNum(expertsinfoMapperExt.countByExample(example));
    }

}