package com.medicineCenter.service.avoidance;

import com.medicineCenter.model.dataObject.Experts;
import com.medicineCenter.model.dataObject.Task;
import com.medicineCenter.model.dto.AvoidanceDTO;
import com.medicineCenter.service.ExpertsCrudService;
import com.medicineCenter.service.TaskCrudService;
import com.medicineCenter.util.Page;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huang on 2016/12/22.
 */
//获取Spring配置信息
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class AvoidanceTest {
    @Resource
    TaskCrudService taskCrudService;
    @Resource
    ExpertsCrudService expertsCrudService;
    @org.junit.Test
    public void shrinkExperts() throws Exception {
        Page<Experts> pageExperts = expertsCrudService.getExpertsList(1, null);
        System.out.println("测试"+pageExperts);

        Task task = test123();
        System.out.println(task);
        //创建一个规避原则
        List<Avoidance> avoidanceList = new ArrayList<Avoidance>();
        AddressAvoidance addressAvoidance = new AddressAvoidance();
        FreqAvoidance freqAvoidance = new FreqAvoidance();//创建一个规避原则
        avoidanceList.add(addressAvoidance);// 把规避原则添加进规避原则list中
        //avoidanceList.add(freqAvoidance);
        ArrayList<Experts> expertsList= new ArrayList<Experts>();
        AvoidanceDTO avoidanceDTO = new AvoidanceDTO();
        avoidanceDTO.setCandidateList(pageExperts.getData());
        avoidanceDTO.setSource("二科");
        avoidanceDTO.setTaskId(45);
        avoidanceDTO.setBacteria("0");

        System.out.println("规避原则数量"+ pageExperts.getData().size());
        for (Avoidance avoidance : avoidanceList){
          //  List<Experts> list = avoidance.ShrinkExperts(avoidanceDTO);
          //  System.out.println("测试"+list);
        }


    }
    public Task test123(){
        Task task = taskCrudService.get(45);

        return task;
    }
}