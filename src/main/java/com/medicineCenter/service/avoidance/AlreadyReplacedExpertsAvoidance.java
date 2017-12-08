package com.medicineCenter.service.avoidance;

import com.medicineCenter.model.dataObject.Experts;
import com.medicineCenter.model.dataObject.TaskLog;
import com.medicineCenter.model.dto.AvoidanceDTO;
import com.medicineCenter.service.TaskLogCrudService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huang on 2016/12/8
 * 规避原则
 * 查询专家的更换记录,把更换过的专家删除掉
 * @return  返回一个avoidanceDTO
 */
@Service
public class AlreadyReplacedExpertsAvoidance implements Avoidance {
    @Resource
    TaskLogCrudService taskLogCrudService;
    @Override
    public AvoidanceDTO ShrinkExperts(AvoidanceDTO avoidanceDTO) {
        List<Experts> reamExpertsList = new ArrayList<Experts>();
        List<TaskLog> expertsId = taskLogCrudService.queryUpadteLog(avoidanceDTO.getTaskId() + "");
        if (expertsId != null && expertsId.size() != 0){
            for (TaskLog experts0 : expertsId) {
                for (Experts experts1 : avoidanceDTO.getCandidateList()) {
                    if (experts0.getOrigExpertsId() == experts1.getExpertsId()){
                        reamExpertsList.add(experts1);

                    }
                }
            }
            avoidanceDTO.getCandidateList().removeAll(reamExpertsList);
        }
        return avoidanceDTO;
    }
}
