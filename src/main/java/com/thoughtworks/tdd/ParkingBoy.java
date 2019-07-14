package com.thoughtworks.tdd;

public class ParkingBoy {
    public ParkingLot parkingLot;
    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot=parkingLot;
    }

    public Ticket parking(Car car) {
        if(parkingLot.parkingMap.size()>=10){
            return null;
        }
        Ticket ticket=new Ticket();
        parkingLot.park(ticket,car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) {
        return parkingLot.fetch(ticket);
    }
}
