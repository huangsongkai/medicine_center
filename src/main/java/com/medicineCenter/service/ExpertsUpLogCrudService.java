package com.medicineCenter.service;

import com.medicineCenter.dao.ExpertsUpLogMapperExt;
import com.medicineCenter.interfaces.controller.Result;
import com.medicineCenter.model.dataObject.ExpertsUpLog;
import com.medicineCenter.model.dataObject.ExpertsUpLogExample;
import com.medicineCenter.util.Page;
import com.medicineCenter.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by song.
*/
@Service
public class ExpertsUpLogCrudService extends BaseService{
    @Resource
    ExpertsUpLogMapperExt expertsuplogMapperExt;

    public Result add(ExpertsUpLog expertsuplog) {
        return new Result(expertsuplogMapperExt.insert(expertsuplog),"",expertsuplog);
    }

    public int update(ExpertsUpLog expertsuplog) {
        return expertsuplogMapperExt.updateByPrimaryKeySelective(expertsuplog);
    }

    public int delete(ExpertsUpLog expertsuplog) {
        return expertsuplogMapperExt.deleteByPrimaryKey(expertsuplog.getId());
    }

    public ExpertsUpLog get(java.lang.Integer id) {
        return expertsuplogMapperExt.selectByPrimaryKey(id);
    }

    public Page<ExpertsUpLog> getList(int pageNum, String q) {
        return getList(pageNum, q, null, null);
    }

    public Page<ExpertsUpLog> getList(int pageNum, String q, String asc, String desc) {
        String orderClause = "";
        if(asc != null){
            orderClause += asc;
        }else if(desc != null){
            orderClause += desc;
        }else{
            orderClause += "CREATE_TIME DESC";
        }
        Page page = new Page();
        List<ExpertsUpLog> expertsuplogList;
        int totalPage;
        ExpertsUpLogExample expertsuplogExample = new ExpertsUpLogExample();
        //全文检索 优先使用fulltext索引 还可以利用lucence，like等
        if(q != null){
            expertsuplogList = expertsuplogMapperExt.selectByFullText((pageNum - 1) * PAGE_SIZE, PAGE_SIZE, q);
            totalPage = PageUtil.getPageNum(expertsuplogMapperExt.selectCountByFullText(q));
        }else {
            expertsuplogExample.setOrderByClause(orderClause + " " + PageUtil.genPaginationClause(pageNum));
            expertsuplogList = expertsuplogMapperExt.selectByExample(expertsuplogExample);
            totalPage = totalPage(expertsuplogExample);
        }
        page.setCurrentPage(pageNum);
        page.setData(expertsuplogList);
        page.setTotalPage(totalPage);
        page.setPageSize(PAGE_SIZE);
        return page;
    }

    public int totalPage(ExpertsUpLogExample example) {
        return PageUtil.getPageNum(expertsuplogMapperExt.countByExample(example));
    }

}