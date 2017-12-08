package com.medicineCenter.service;

import com.medicineCenter.dao.ExpertsLogMapperExt;
import com.medicineCenter.interfaces.controller.Result;
import com.medicineCenter.model.dataObject.ExpertsLog;
import com.medicineCenter.model.dataObject.ExpertsLogExample;
import com.medicineCenter.util.Page;
import com.medicineCenter.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by song.
*/
@Service
public class ExpertsLogCrudService extends BaseService{
    @Resource
    ExpertsLogMapperExt expertslogMapperExt;

    public Result add(ExpertsLog expertslog) {
        return new Result(expertslogMapperExt.insert(expertslog),"",expertslog);
    }

    public int update(ExpertsLog expertslog) {
        return expertslogMapperExt.updateByPrimaryKeySelective(expertslog);
    }

    public int delete(ExpertsLog expertslog) {
        return expertslogMapperExt.deleteByPrimaryKey(expertslog.getExpertsLogId());
    }

    public ExpertsLog get(java.lang.Integer id) {
        return expertslogMapperExt.selectByPrimaryKey(id);
    }

    public Page<ExpertsLog> getList(int pageNum, String q) {
        return getList(pageNum, q, null, null);
    }

    public Page<ExpertsLog> getList(int pageNum, String q, String asc, String desc) {
        String orderClause = "";
        if(asc != null){
            orderClause += asc;
        }else if(desc != null){
            orderClause += desc;
        }else{
            orderClause += "CREATE_TIME DESC";
        }
        Page page = new Page();
        List<ExpertsLog> expertslogList;
        int totalPage;
        ExpertsLogExample expertslogExample = new ExpertsLogExample();
        //全文检索 优先使用fulltext索引 还可以利用lucence，like等
        if(q != null){
            expertslogList = expertslogMapperExt.selectByFullText((pageNum - 1) * PAGE_SIZE, PAGE_SIZE, q);
            totalPage = PageUtil.getPageNum(expertslogMapperExt.selectCountByFullText(q));
        }else {
            expertslogExample.setOrderByClause(orderClause + " " + PageUtil.genPaginationClause(pageNum));
            expertslogList = expertslogMapperExt.selectByExample(expertslogExample);
            totalPage = totalPage(expertslogExample);
        }
        page.setCurrentPage(pageNum);
        page.setData(expertslogList);
        page.setTotalPage(totalPage);
        page.setPageSize(PAGE_SIZE);
        return page;
    }

    public int totalPage(ExpertsLogExample example) {
        return PageUtil.getPageNum(expertslogMapperExt.countByExample(example));
    }

}