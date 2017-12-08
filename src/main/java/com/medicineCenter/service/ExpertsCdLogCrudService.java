package com.medicineCenter.service;

import com.medicineCenter.dao.ExpertsCdLogMapperExt;
import com.medicineCenter.interfaces.controller.Result;
import com.medicineCenter.model.dataObject.ExpertsCdLog;
import com.medicineCenter.model.dataObject.ExpertsCdLogExample;
import com.medicineCenter.util.Page;
import com.medicineCenter.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by song.
*/
@Service
public class ExpertsCdLogCrudService extends BaseService{
    @Resource
    ExpertsCdLogMapperExt expertscdlogMapperExt;

    public Result add(ExpertsCdLog expertscdlog) {
        return new Result(expertscdlogMapperExt.insert(expertscdlog),"",expertscdlog);
    }

    public int update(ExpertsCdLog expertscdlog) {
        return expertscdlogMapperExt.updateByPrimaryKeySelective(expertscdlog);
    }

    public int delete(ExpertsCdLog expertscdlog) {
        return expertscdlogMapperExt.deleteByPrimaryKey(expertscdlog.getId());
    }

    public ExpertsCdLog get(java.lang.Integer id) {
        return expertscdlogMapperExt.selectByPrimaryKey(id);
    }

    public Page<ExpertsCdLog> getList(int pageNum, String q) {
        return getList(pageNum, q, null, null);
    }

    public Page<ExpertsCdLog> getList(int pageNum, String q, String asc, String desc) {
        String orderClause = "";
        if(asc != null){
            orderClause += asc;
        }else if(desc != null){
            orderClause += desc;
        }else{
            orderClause += "CREATE_TIME DESC";
        }
        Page page = new Page();
        List<ExpertsCdLog> expertscdlogList;
        int totalPage;
        ExpertsCdLogExample expertscdlogExample = new ExpertsCdLogExample();
        //全文检索 优先使用fulltext索引 还可以利用lucence，like等
        if(q != null){
            expertscdlogList = expertscdlogMapperExt.selectByFullText((pageNum - 1) * PAGE_SIZE, PAGE_SIZE, q);
            totalPage = PageUtil.getPageNum(expertscdlogMapperExt.selectCountByFullText(q));
        }else {
            expertscdlogExample.setOrderByClause(orderClause + " " + PageUtil.genPaginationClause(pageNum));
            expertscdlogList = expertscdlogMapperExt.selectByExample(expertscdlogExample);
            totalPage = totalPage(expertscdlogExample);
        }
        page.setCurrentPage(pageNum);
        page.setData(expertscdlogList);
        page.setTotalPage(totalPage);
        page.setPageSize(PAGE_SIZE);
        return page;
    }

    public int totalPage(ExpertsCdLogExample example) {
        return PageUtil.getPageNum(expertscdlogMapperExt.countByExample(example));
    }

}