package com.students.event.service;

import com.students.event.buildingModel.ParkingSlot;

import java.util.List;

public interface ParkingSlotService {

    List<ParkingSlot> fetchEmptySlotDetails(String vehicleType);
    List<ParkingSlot> fetchVehicleParked(String vehicleNumber);
}
