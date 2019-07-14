package com.thoughtworks.tdd;

public class ParkingBoy {
    public ParkingLot parkingLot;
    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot=parkingLot;
    }

    public Ticket parking(Car car) {
        Ticket ticket=new Ticket();
        parkingLot.park(ticket,car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) {
        Car car=parkingLot.fetch(ticket);
        return car;
    }
}
