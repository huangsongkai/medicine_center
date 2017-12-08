package com.medicineCenter.service.avoidance;

import com.medicineCenter.model.dataObject.Experts;
import com.medicineCenter.model.dto.AvoidanceDTO;
import org.springframework.stereotype.Service;

/**
 * Created by huang on 2016/12/8.
 * 规避原则
 * 专家组成员的归属地不能和检查单位一样,省直的专家除外
 * @return  返回一个avoidanceDTO
 */
@Service
public class AddressAvoidance implements Avoidance{
    @Override
    public AvoidanceDTO ShrinkExperts(AvoidanceDTO avoidanceDTO) {
        for (Experts experts : avoidanceDTO.getCandidateList()) {
            if (!("省直".equals(experts.getAttribution()))){
                if((avoidanceDTO.getAttribution().trim()).equals((experts.getAttribution().trim()))){
                    avoidanceDTO.getCandidateList().remove(experts);
                }
            }
        }
        return avoidanceDTO;
    }
}
