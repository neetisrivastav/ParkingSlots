package com.students.event.repository;

import com.students.event.buildingModel.Floor;
import com.students.event.buildingModel.ParkingSlot;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "slots", path = "slots")
public interface ParkingSlotRepository extends PagingAndSortingRepository<ParkingSlot, Long> {

   public List<ParkingSlot> findByVehicleType_TypeAndIsOccupied(String VehicleType, boolean isOccupied);
   public List<ParkingSlot> findByVehicle_VehicleNumber(String vehicleNumber);
}
