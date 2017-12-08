package com.medicineCenter.service.avoidance;

import com.medicineCenter.model.dataObject.Experts;
import com.medicineCenter.model.dto.AvoidanceDTO;
import com.medicineCenter.service.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huang on 2016/12/8
 * 规避原则
 * 如果bacteria = 1 的话就把有菌的专家全部去掉.
 * @return  返回一个avoidanceDTO
 */
@Service
public class BacteriaAvoidance implements Avoidance {
    @Resource
    TaskService taskService;
    @Override
    public AvoidanceDTO ShrinkExperts(AvoidanceDTO avoidanceDTO) {
        List<Experts> reamExpertsList = new ArrayList<Experts>();
        if(avoidanceDTO.getBacteria() != null){
            for (Experts experts:avoidanceDTO.getCandidateList()) {
                if ("1".equals(avoidanceDTO.getBacteria())){
                    if(!("1".equals(experts.getBacteria()))){
                        reamExpertsList.add(experts);
                        //把有菌的人从List中删除.
                    }
                }
                if ("0".equals(avoidanceDTO.getBacteria())){
                    if(!("0".equals(experts.getBacteria()))){
                        reamExpertsList.add(experts);
                        //把无菌的人从List中删除.
                    }
                }
            }
            avoidanceDTO.getCandidateList().removeAll(reamExpertsList);
        }
        return avoidanceDTO;
    }
}
