package com.medicineCenter.service.avoidance;

import com.medicineCenter.model.dataObject.Experts;
import com.medicineCenter.model.dto.AvoidanceDTO;
import com.medicineCenter.service.TaskService;
import com.medicineCenter.util.RandomUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huang on 2016/12/8
 * 规避原则
 * 专家组成员之间不能来自同一个地级市,省里的专家不受任何限制 最后使用
 */
@Service
public class ExpertsAddressAvoidance implements Avoidance {
    @Resource
    TaskService taskService;
    @Override
    public AvoidanceDTO ShrinkExperts(AvoidanceDTO avoidanceDTO) {
        Map<String,ArrayList<Experts>> attributionMap = new HashMap<String,ArrayList<Experts>>();//存有归属地的和归属地相关专家的map
        ArrayList<Experts> returnExperts = new ArrayList<Experts>();  //最后要返回的专家列表
        for (Experts experts : avoidanceDTO.getCandidateList()) {
            boolean attribution = attributionMap.containsKey(experts.getAttribution());//判断数据中是不是包含这个专家的归属地
            //如果不包含的话穿件一个list set进去 包含的话  直接获的map set进去.
            if(attribution){
                ArrayList<Experts> expertsList = attributionMap.get(experts.getAttribution());
                expertsList.add(experts);
            }else{
                ArrayList<Experts> expertsList = new ArrayList<Experts>();
                expertsList.add(experts);
                attributionMap.put(experts.getAttribution(),expertsList);
            }
        }
        for (Map.Entry<String,ArrayList<Experts>> entry : attributionMap.entrySet()) {   //
            ArrayList<Experts> expertsList = entry.getValue();
            if ("省直".equals(entry.getKey())){
                for (Experts experts:expertsList) {
                    returnExperts.add(experts);
                }
            }else{
                if (expertsList != null){
                    returnExperts.add(expertsList.get(RandomUtil.genericOffset(expertsList.size())));
                }
            }
            //System.out.println("归属地 = " + entry.getKey() + ", 专家名字 = " + entry.getValue().get(0).getName());
        }


        return avoidanceDTO;
    }


}
