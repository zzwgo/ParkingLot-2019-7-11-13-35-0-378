package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot  {
    private Map<Ticket,Car> parkingMap;

    public Map<Ticket, Car> getParkingMap() {
        return parkingMap;
    }

    public ParkingLot() {
        this.parkingMap=new HashMap<>();
    }

    public void park(Ticket ticket, Car car) {
        this.parkingMap.put(ticket,car);
    }

    public Car fetch(Ticket ticket) {
        return parkingMap.remove(ticket);
    }

    public boolean isFull(){
        return parkingMap.size()>=10;
    }

    public boolean hasBeenPark(Car car) {
        for (Ticket ticket : parkingMap.keySet()) {
            if (parkingMap.get(ticket).equals(car)) {
                return true;
            }
        }
        return false;
    }
}
