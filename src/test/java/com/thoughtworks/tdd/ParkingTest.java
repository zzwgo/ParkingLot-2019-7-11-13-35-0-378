package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingTest {
    @Test
    public void parking_the_car_and_should_fetch_the_car_when_give_a_ticket(){
        ParkingLot parkingLot=new ParkingLot();
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        Car car=new Car();
        Ticket ticket=parkingBoy.parking(car);
        Car fetchCar=parkingBoy.fetchCar(ticket);
        assertThat(car, is(fetchCar));
    }
}
