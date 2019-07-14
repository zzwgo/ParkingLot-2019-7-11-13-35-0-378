package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

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

    @Test
    public void parking_cars_and_should_not_fetch_the_car_when_give_a_worng_ticket(){
        ParkingLot parkingLot=new ParkingLot();
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        Car car1=new Car();
        Car car2=new Car();
        Ticket ticket1=parkingBoy.parking(car1);
        // not give a ticket
        Car fetchCar1=parkingBoy.fetchCar(null);
        Assertions.assertEquals(null, fetchCar1);
        // not give a wrong ticket
        Car fetchCar2=parkingBoy.fetchCar(new Ticket());
        Assertions.assertEquals(null, fetchCar2);
    }

    @Test
    public void should_not_fetch_the_car_when_give_a_ticket_had_been_used(){
        ParkingLot parkingLot=new ParkingLot();
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        Car car1=new Car();
        Ticket ticket1=parkingBoy.parking(car1);
        Car fetchCar1=parkingBoy.fetchCar(ticket1);
        Car fetchCar2=parkingBoy.fetchCar(ticket1);
        Assertions.assertEquals(null, fetchCar2);
    }

    @Test
    public void should_not_parking_the_car_when_parkingLot_is_fulled(){
        ParkingLot parkingLot=new ParkingLot();
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        for(int i=0;i<10;i++){
            Car car=new Car();
            Ticket ticket1=parkingBoy.parking(car);
        }
        Car car_11=new Car();
        Ticket ticket11=parkingBoy.parking(car_11);
        Assertions.assertEquals(null, ticket11);
    }
    @Test
    public void should_not_parking_the_car_when_parking_a_parked_car(){
        ParkingLot parkingLot=new ParkingLot();
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        Car car1=new Car();
        Ticket ticket1=parkingBoy.parking(car1);
        Ticket ticket2=parkingBoy.parking(car1);
        Assertions.assertEquals(null, ticket2);
    }
}
