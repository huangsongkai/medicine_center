package com.medicineCenter.service.avoidance;

import com.medicineCenter.model.dataObject.Experts;
import com.medicineCenter.model.dto.AvoidanceDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huang on 2016/12/23.
 * ExcludeAddrs 传入归属地list, 在返回的list中吧ExcludeAddrs的归属地的删除掉
 */
@Service
public class ConfirmedAdressAvoidance implements Avoidance{
    @Override
    public AvoidanceDTO ShrinkExperts(AvoidanceDTO avoidanceDTO) {
        List<Experts> reamExpertsList = new ArrayList<Experts>();
        for (Experts experts : avoidanceDTO.getCandidateList()) {
            if (!("省直".equals(experts.getAttribution()))){
                    if(isIn(experts.getAttribution().trim(), avoidanceDTO.getExcludeAddrs())){ //排除的地点 删除掉
                    reamExpertsList.add(experts);
                }
            }
        }
        avoidanceDTO.getCandidateList().removeAll(reamExpertsList);
        return avoidanceDTO;
    }

    public boolean isIn(String attribution, List<String> addrs){
        for(String addr : addrs){
            if(attribution.equals(addr.trim()))
                return true;
        }
        return false;
    }
}
