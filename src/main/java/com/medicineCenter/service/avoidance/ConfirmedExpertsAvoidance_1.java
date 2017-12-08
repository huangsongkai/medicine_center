package com.medicineCenter.service.avoidance;

import com.medicineCenter.model.dataObject.Experts;
import com.medicineCenter.model.dto.AvoidanceDTO;
import org.apache.commons.collections.ListUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by huang on 2016/12/23.
 */
@Service
public class ConfirmedExpertsAvoidance_1 implements Avoidance{
    @Override
    public AvoidanceDTO ShrinkExperts(AvoidanceDTO avoidanceDTO) {
        if(avoidanceDTO.getConfirmedList() == null)
            return avoidanceDTO;
//        TODO  判断执行有没有问题
        avoidanceDTO.setCandidateList(ListUtils.subtract(avoidanceDTO.getCandidateList(), avoidanceDTO.getConfirmedList()));
        avoidanceDTO.setExcludeAddrs(new ArrayList<String>());
        for(Experts experts : avoidanceDTO.getConfirmedList()){
            //已经初始化,第0个元素为检查单位的归属地
            if(experts.getAttribution().equals("省直"))
                continue;
            avoidanceDTO.getExcludeAddrs().add(experts.getAttribution());
        }
        return avoidanceDTO;
    }
}
