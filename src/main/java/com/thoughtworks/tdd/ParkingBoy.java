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
        for(Ticket ticket:parkingLot.parkingMap.keySet()){
            if(parkingLot.parkingMap.get(ticket).equals(car)){
                return  null;
            }
        }
        Ticket ticket=new Ticket();
        parkingLot.park(ticket,car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) throws Exception {
        if(ticket==null){
            throw new ParkingException("Please provide your parking ticket.");
        }
        if(parkingLot.parkingMap.get(ticket)==null){
            throw new ParkingException("Unrecognized parking ticket.");
        }

        return parkingLot.fetch(ticket);
    }
}
