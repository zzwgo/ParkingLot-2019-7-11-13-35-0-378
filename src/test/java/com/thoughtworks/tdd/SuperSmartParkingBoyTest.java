package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {
    @Test
    public void mutiple_parkingt_lots_can_fetch_correct_car() throws Exception {
        List<ParkingLot> lots=new ArrayList<>();
        ParkingLot parkingLot1=new ParkingLot();
        ParkingLot parkingLot2=new ParkingLot();
        lots.add(parkingLot1);
        lots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy=new SuperSmartParkingBoy(lots);
        Car firstCar=new Car();
        Ticket ticketFirst=superSmartParkingBoy.parking(firstCar);
        for(int i=0;i<19;i++){
            Car car=new Car();
            Ticket ticket=superSmartParkingBoy.parking(car);
        }
        Car firstCarFetch=superSmartParkingBoy.fetchCar(ticketFirst);

        Car car11=new Car();
        Ticket ticketLast=superSmartParkingBoy.parking(car11);
        Car fetchCarLast=superSmartParkingBoy.fetchCar(ticketLast);
        Assertions.assertFalse(parkingLot1.getParkingMap().get(fetchCarLast)!=null);
    }
}
