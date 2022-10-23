package com.students.event.buildingModel;

import javax.persistence.*;

@Entity
@Table(name = "vehicletype")
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleTypeNo;
    private String type;

    public Long getVehicleTypeNo() {
        return vehicleTypeNo;
    }

    public void setVehicleTypeNo(Long vehicleTypeNo) {
        this.vehicleTypeNo = vehicleTypeNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
