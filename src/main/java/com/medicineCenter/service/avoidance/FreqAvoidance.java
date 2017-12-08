package com.medicineCenter.service.avoidance;

import com.medicineCenter.model.dataObject.Experts;
import com.medicineCenter.model.dto.AvoidanceDTO;
import com.medicineCenter.service.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by huang on 2016/12/8.
 * 规避原则
 * 专家在n次检查任务内不能重复
 * 传入一个符合条件的List,在查询出三次任务内的taskId,在符合的taskId的List进行比较,符合条件的就进行删除.
 */
@Service
public class FreqAvoidance implements Avoidance {
    @Resource
    TaskService taskService;

    @Override
    public AvoidanceDTO ShrinkExperts(AvoidanceDTO avoidanceDTO) {
//        TODO  修改最近几次
        List<Experts> expertsIds = taskService.FreqAvoidance(avoidanceDTO.getSource(), times);//传入科室名字,查出这个科室的最近三次任务都有谁.
        for (Experts expertsId:expertsIds) {
            for (Experts experts:avoidanceDTO.getCandidateList()) {
                if (experts.getExpertsId() == expertsId.getExpertsId()){   //expertsId和查出的expertsId相等的话干掉.
                    avoidanceDTO.getCandidateList().remove(experts);
                }
            }
        }
        return avoidanceDTO;
    }

    int times = 3;

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
