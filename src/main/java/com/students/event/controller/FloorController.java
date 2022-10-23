package com.students.event.controller;

import com.students.event.buildingModel.Floor;
import com.students.event.buildingModel.ParkingSlot;
import com.students.event.service.FloorService;
import com.students.event.service.ParkingSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/floor")
public class FloorController {

    @Autowired
    private FloorService floorService;

    @Autowired
    private ParkingSlotService parkingSlotService;

    @PostMapping("/save-update-floor")
    public String saveFloor(@RequestBody Floor floor) {
        floorService.saveFloor(floor);
        return "successfully inserted or updated";
    }

    @GetMapping("/fetchEmptySlots/{vehicleType}")
    public List<ParkingSlot> fetchEmptySlots(@PathVariable String vehicleType)
    {
        return parkingSlotService.fetchEmptySlotDetails(vehicleType);
    }

    @GetMapping("/fetchEmptySlots/{vehicleNumber}")
    public List<ParkingSlot> fetchVehicleParked(@PathVariable String vehicleNumber)
    {
        return parkingSlotService.fetchVehicleParked(vehicleNumber);
    }

}