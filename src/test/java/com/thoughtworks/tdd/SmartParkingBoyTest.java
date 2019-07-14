package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    public void mutiple_parkingt_lots_can_fetch_correct_car() throws Exception {
        List<ParkingLot> lots=new ArrayList<>();
        ParkingLot parkingLot1=new ParkingLot();
        ParkingLot parkingLot2=new ParkingLot();
        lots.add(parkingLot1);
        lots.add(parkingLot2);
        SmartPakingBoy SmartParkingBoy=new SmartPakingBoy(lots);
        Car firstCar=new Car();
        Ticket ticketFirst=SmartParkingBoy.parking(firstCar);
        for(int i=0;i<19;i++){
            Car car=new Car();
            Ticket ticket=SmartParkingBoy.parking(car);
        }
        Car firstCarFetch=SmartParkingBoy.fetchCar(ticketFirst);

        Car car11=new Car();
        Ticket ticketLast=SmartParkingBoy.parking(car11);

        Car fetchCar11=SmartParkingBoy.fetchCar(ticketLast);
        assertEquals(car11,fetchCar11);
    }
}
