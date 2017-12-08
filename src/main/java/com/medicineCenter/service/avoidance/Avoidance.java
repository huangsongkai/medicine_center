package com.medicineCenter.service.avoidance;

import com.medicineCenter.model.dto.AvoidanceDTO;
import org.springframework.stereotype.Service;

/**
 * Created by huang on 2016/12/8.
 */
@Service
public interface Avoidance {
    public AvoidanceDTO ShrinkExperts(AvoidanceDTO avoidanceDTO);
}
