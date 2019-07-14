package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot  {
    public Map<Ticket,Car> parkingMap=new HashMap<>();

    public void park(Ticket ticket, Car car) {
        this.parkingMap.put(ticket,car);
    }

    public Car fetch(Ticket ticket) {
        return parkingMap.remove(ticket);
    }
}
