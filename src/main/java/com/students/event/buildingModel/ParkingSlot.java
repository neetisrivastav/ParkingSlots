package com.students.event.buildingModel;

import javax.persistence.*;

@Entity
@Table(name = "parking")
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slotNumber;
    private boolean isOccupied;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vehicleTypeId")
    private VehicleType vehicleType;
    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;
    @OneToOne
    private Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Long getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Long slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}
