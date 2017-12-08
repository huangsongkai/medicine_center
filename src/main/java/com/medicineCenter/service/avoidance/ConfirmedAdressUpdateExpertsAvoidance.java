package com.medicineCenter.service.avoidance;

import com.medicineCenter.model.dataObject.Experts;
import com.medicineCenter.model.dto.AvoidanceDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huang on 2016/12/23.
 * ExcludeAddrs 传入归属地list, 在返回的list中吧ExcludeAddrs的归属地的删除掉
 */
@Service
public class ConfirmedAdressUpdateExpertsAvoidance implements Avoidance{
    @Override
    public AvoidanceDTO ShrinkExperts(AvoidanceDTO avoidanceDTO) {
        for (Experts experts : avoidanceDTO.getCandidateList()) {
            if (!("省直".equals(experts.getAttribution()))){
                if(isIn(experts.getAttribution(), avoidanceDTO.getExcludeAddrs())){ //排除的地点 删除掉
                    avoidanceDTO.getCandidateList().remove(experts);
                }
            }
        }
        return avoidanceDTO;
    }

    public boolean isIn(String attribution, List<String> addrs){
        for(String addr : addrs){
            if(attribution.equals(addr))
                return true;
        }
        return false;
    }
}
