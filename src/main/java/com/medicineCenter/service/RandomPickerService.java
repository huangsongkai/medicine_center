package com.medicineCenter.service;

import com.medicineCenter.interfaces.controller.NotEnoughException;
import com.medicineCenter.model.dataObject.Experts;
import com.medicineCenter.model.dataObject.InspectionGroup;
import com.medicineCenter.util.RandomUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据两个类型 在数组中筛选 选出后在list中删
 * Ceated by huang on 2016/12/23.
 */
@Service
@Transactional
public class RandomPickerService {

    // TODO: 2017/1/23   重构
    public List<Experts> pickExpertsByAvoidanceDTO(List<Experts> ExpertsList, List<InspectionGroup> inspectionGroup) throws NotEnoughException {
        List<Experts> returnExpertsList = new ArrayList<Experts>();
        List<Experts>  middleList = new ArrayList<Experts>();
        try {
            for ( InspectionGroup inspectionGroup1 : inspectionGroup) {
                for (int i=0 ;i<inspectionGroup1.getNum();i++){
                    for (Experts experts : ExpertsList ) {
                        if (experts.getCategory().equals(inspectionGroup1.getCategory()) && experts.getCategoryTwo().equals(inspectionGroup1.getCategoryTwo())){
                            middleList.add(experts);
                        }
                    }
                    int randomNum = RandomUtil.genericOffset(middleList.size());//生成随机数
                    Experts temporaryExperts = middleList.get(randomNum);//临时选中的专家
                    returnExpertsList.add(temporaryExperts);//把随机出来的人员添加到要返回的数组当中;
                    List<Experts> removeList = new ArrayList<Experts>();//要删除的人员
                    removeList.add(temporaryExperts);//把随机的人员从数组中删除掉
                    for (Experts experts : middleList) {
                        if ("四科".equals(experts.getSource())) {
                            if (temporaryExperts.getName().equals(experts.getName())) { //把名字重复的专家都删除掉
                                removeList.add(experts);
                            }
                        }
                        if ("七科".equals(experts.getSource())) {

                        }else{
                            if (temporaryExperts.getWork().equals(experts.getWork())){ //把相同单位的人都删除掉
                                removeList.add(experts);
                            }
                        }

                      }
                    middleList.removeAll(removeList);
                    ExpertsList.removeAll(removeList);
                    middleList.clear();
                    for (Experts experts: ExpertsList) {
                        if ("四科".equals(experts.getSource())){
                            if (temporaryExperts.getWork().equals(experts.getWork())){ //把相同单位的人都删除掉
                                removeList.add(experts);
                            }
                        }
                        if ("七科".equals(experts.getSource())) {

                        }else{
                            if (temporaryExperts.getWork().equals(experts.getWork())){ //把相同单位的人都删除掉
                                removeList.add(experts);
                            }
                        }
                  }
                    if (removeList != null){
                    ExpertsList.removeAll(removeList);
                    }
                }
                middleList.clear();
            }

        }catch (Exception e){
            System.out.println(e);
            throw new NotEnoughException("专家人数不足");//人数不足抛出异常
        }
        //根据类型和归属地进行规避  把来自同一个归属地的专家删除掉
        return returnExpertsList;
    }
}
