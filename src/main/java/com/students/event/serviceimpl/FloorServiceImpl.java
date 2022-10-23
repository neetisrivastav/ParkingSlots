package com.students.event.serviceimpl;

import com.students.event.buildingModel.Floor;
import com.students.event.repository.FloorRepository;
import com.students.event.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class FloorServiceImpl implements FloorService {

    @Autowired
    private FloorRepository floorRepository;

    public Floor saveFloor(Floor floor) {
        return floorRepository.save(floor);
    }
}