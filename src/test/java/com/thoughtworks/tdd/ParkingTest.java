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

    @Test
    public void parking_mutiple_cars_and_should_fetch_the_car_correct_when_give_a_ticket(){
        ParkingLot parkingLot=new ParkingLot();
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        Car car1=new Car();
        Car car2=new Car();
        Ticket ticket1=parkingBoy.parking(car1);
        Ticket ticket2=parkingBoy.parking(car2);
        Car fetchCar1=parkingBoy.fetchCar(ticket1);
        Car fetchCar2=parkingBoy.fetchCar(ticket2);
        assertThat(car1, is(fetchCar1));
        assertThat(car2, is(fetchCar2));
    }
}
