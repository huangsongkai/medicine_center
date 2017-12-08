package com.medicineCenter.service;

import com.medicineCenter.dao.*;
import com.medicineCenter.interfaces.controller.Result;
import com.medicineCenter.model.dataObject.Experts;
import com.medicineCenter.model.dataObject.ExpertsCdLog;
import com.medicineCenter.model.dataObject.ExpertsExample;
import com.medicineCenter.model.dataObject.ExpertsUpLog;
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
public class ExpertsCrudService extends BaseService{
    @Resource
    ExpertsMapperExt expertsMapperExt;
    @Resource
    ExpertsLogMapper expertsLogMapper;
    @Resource
    ExpertsLogMapperExt expertsLogMapperExt;
    @Resource
    ExpertsCdLogMapperExt expertsCdLogMapperExt;
    @Resource
    ExpertsUpLogMapperExt expertsUpLogMapperExt;

    public Result add(Experts experts, String userName) {


        /**
         * 添加专家log
         */
        ExpertsCdLog  expertsCdLog = new ExpertsCdLog();
        int expertsreturn = expertsMapperExt.insert(experts);
        try {
            BeanUtils.copyProperties(expertsCdLog,experts);
            expertsCdLog.setExpertsId(expertsreturn);
            expertsCdLog.setUser(userName);
            expertsCdLog.setType("添加");
            expertsCdLogMapperExt.insert(expertsCdLog);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return new Result(expertsreturn,"",experts);
    }

    public int update(Experts experts) {
        return expertsMapperExt.updateByPrimaryKeySelective(experts);
    }

    public int delete(Experts experts, String userName) {
        ExpertsCdLog  expertsCdLog = new ExpertsCdLog();
        try {
            BeanUtils.copyProperties(expertsCdLog,experts);
            expertsCdLog.setUser(userName);
            expertsCdLog.setType("删除");
            expertsCdLogMapperExt.insert(expertsCdLog);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return expertsMapperExt.deleteByPrimaryKey(experts.getExpertsId());
    }

    public Experts get(int id) {
        return expertsMapperExt.selectByPrimaryKey(id);
    }

    public Page<Experts> getList(int pageNum, String q) {
        return getList(pageNum, q, null, null);
    }
    public Page<Experts> getExpertsList(int pageNum, String q) {
        return getList(pageNum, q, null, null);
    }

    public Page<Experts> getList(int pageNum, String q, String asc, String desc) {
        String orderClause = "";
        if(asc != null){
            orderClause += asc;
        }else if(desc != null){
            orderClause += desc;
        }else{
            orderClause += "CREATE_TIME DESC";
        }
        Page page = new Page();
        List<Experts> expertsList;
        int totalPage;
        ExpertsExample expertsExample = new ExpertsExample();
        //全文检索 优先使用fulltext索引 还可以利用lucence，like等
        if(q != null){
            expertsList = expertsMapperExt.selectByFullText((pageNum - 1) * PAGE_SIZE, PAGE_SIZE, q);
            totalPage = PageUtil.getPageNum(expertsMapperExt.selectCountByFullText(q));
        }else {
            expertsExample.setOrderByClause(orderClause + " " + PageUtil.genPaginationClause(pageNum));
            expertsList = expertsMapperExt.selectByExample(expertsExample);
            totalPage = totalPage(expertsExample);
        }
        page.setCurrentPage(pageNum);
        page.setData(expertsList);
        page.setTotalPage(totalPage);
        page.setPageSize(PAGE_SIZE);
        return page;
    }

    public int totalPage(ExpertsExample example) {
        return PageUtil.getPageNum(expertsMapperExt.countByExample(example));
    }

    /**
     * 根据组名和有菌无菌查询出
     * @param category
     * @param bacteria
     */
    public List<Experts> selectByCategoryAndBacteria(String category, String bacteria) {
        ExpertsExample exampleExample  = new ExpertsExample();
        if("1".equals(bacteria))
            exampleExample.or().andCategoryEqualTo(category).andBacteriaEqualTo(bacteria);  
        else
            exampleExample.or().andCategoryEqualTo(category);
        return expertsMapperExt.selectByExample(exampleExample);
    }
    public List<Experts> selectExpertsForSource(String source){
        return expertsMapperExt.selectExpertsForSource(source);
    }

    /**
     * 根据分类查询出一个list
     * @param category
     * @return
     */
    public List<Experts> selectByCategory(String category) {
        ExpertsExample exampleExample  = new ExpertsExample();
        exampleExample.or().andCategoryEqualTo(category);
        return expertsMapperExt.selectByExample(exampleExample);
    }



    /**
     * 根据部门差查出一个list
     * @param Department
     * @return
     */
    public List<Experts> selectByDepartment(String Department) {
        ExpertsExample exampleExample  = new ExpertsExample();
        exampleExample.or().andCategoryEqualTo(Department);
        return expertsMapperExt.selectByExample(exampleExample);
    }
    /**
     * 根据两个分类查询出一个list
     * @param category
     * @return
     */
    public List<Experts>  selectByCategoryAndCategoryTwo(String category,String categoryTwo) {
        ExpertsExample exampleExample  = new ExpertsExample();
        exampleExample.or().andCategoryEqualTo(category).andCategoryTwoEqualTo(categoryTwo);
        return expertsMapperExt.selectByExample(exampleExample);
    }

    /**
     * 查询专家列表 通用方法
     * @param pageNum
     * @param q
     * @param asc
     * @param desc
     * @return
     */
        public Page<Experts> getExperts(int pageNum, String q, String asc, String desc, String source) {
        String orderClause = "";
        if(asc != null){
            orderClause += asc;
        }else if(desc != null){
            orderClause += desc;
        }else{
            orderClause += "CREATE_TIME DESC";
        }
        Page page = new Page();
        List<Experts> expertsList;
        int totalPage;
        ExpertsExample expertsExample = new ExpertsExample();
        expertsExample.setOrderByClause(orderClause + " " + PageUtil.genPaginationClause(pageNum));
        ExpertsExample.Criteria criteria;
        if(q != null){
            criteria = expertsExample.or().andNameLike("%"+q.trim()+"%");
//            criteria = expertsExample.or().andNameEqualTo(q);
            if (source != null){
                criteria.andSourceEqualTo(source);
            }
        }else {
            if (source != null){
                expertsExample.or().andSourceEqualTo(source);
            }
        }
        expertsList = expertsMapperExt.selectByExample(expertsExample);
        totalPage = totalPage(expertsExample);
        page.setCurrentPage(pageNum);
        page.setData(expertsList);
        page.setTotalPage(totalPage);
        page.setPageSize(PAGE_SIZE);
        return page;
    }

    /**
     * 根据专家修改信息进行记录保存
     * @param experts
     * @return
     */
    public int updateForLog(Experts experts, String userName) throws InvocationTargetException, IllegalAccessException {
//        ExpertsLog expertszLog = new ExpertsLog();
//        BeanUtils.copyProperties(expertszLog,experts);
//        int expertsNum = expertsLogMapperExt.queryForExpertsId(experts.getExpertsId());
//        expertszLog.setEditionnum(expertsNum+1);//版本号+1
//        expertszLog.setCreateUser(userName);//创建人
//        expertsLogMapper.insert(expertszLog);
        ExpertsUpLog expertsUpLog = new ExpertsUpLog();
        String upadtelog = "";
        Experts old_experts = expertsMapperExt.selectByPrimaryKey(experts.getExpertsId());
        if (old_experts.getName().equals(experts.getName())){
            upadtelog+="原"+old_experts.getName()+" 现"+experts.getName()+" ";
        }
        if (old_experts.getSource().equals(experts.getSource())){
            upadtelog+="原"+old_experts.getSource()+" 现"+experts.getSource()+"  ";
        }
        if (old_experts.getAttribution().equals(experts.getAttribution())){
            upadtelog+="原"+experts.getAttribution()+" 现"+experts.getAttribution()+"  ";
        }
        expertsUpLog.setUpadteDetails(upadtelog);
        expertsUpLog.setExpertsId(experts.getExpertsId());
        expertsUpLog.setUser(userName);
        expertsUpLog.setType("修改");
        expertsUpLog.setSource(experts.getSource());
        expertsUpLogMapperExt.insert(expertsUpLog);
        return expertsMapperExt.updateByPrimaryKeySelective(experts);

    }
}