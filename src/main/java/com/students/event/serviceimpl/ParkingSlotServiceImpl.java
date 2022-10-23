package com.students.event.serviceimpl;

import com.students.event.buildingModel.ParkingSlot;
import com.students.event.repository.ParkingSlotRepository;
import com.students.event.service.ParkingSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {

    @Autowired
    private ParkingSlotRepository parkingSlotRepository;
//    @Autowired
//    private VehicleRepository vehicleRepository;
    @Override
    public List<ParkingSlot> fetchEmptySlotDetails(String vehicleType) {
        return  parkingSlotRepository.findByVehicleType_TypeAndIsOccupied(vehicleType, false);
    }

    @Override
    public List<ParkingSlot> fetchVehicleParked(String vehicleNumber) {
        return parkingSlotRepository.findByVehicle_VehicleNumber(vehicleNumber);
    }
}
