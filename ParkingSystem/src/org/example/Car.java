package org.example;

import java.util.ArrayList;
import java.util.List;

class Car {
    private String LicensePlateNo;

    public Car(String licensePlateNo) {
        LicensePlateNo = licensePlateNo;
    }

    public String getLicensePlateNo() {
        return LicensePlateNo;
    }
}
class ParkingSpot{
    private int spotNo;
    private boolean available;
    private Car car;

    public ParkingSpot(int spotNo) { //available and car is not taken because intially it will bw available and there will bw no car
        this.spotNo = spotNo;
        this.available = true;
        this.car = null;
    }

    public int getSpotNo() {
        return spotNo;
    }

    public boolean isAvailable() {
        return available;
    }

    public Car getCar() {
        return car;
    }
    public void occupyParking(Car car){
        this.car = car;
        this.available = false;
    }
    public void vaccantParking() {
        this.car = null;
        this.available = true;
    }
}
class ParkingLot {
    private List<ParkingSpot> spot;

    public ParkingLot(int capacity) {
        this.spot = new ArrayList<>();
        for (int i = 0; i <capacity ; i++) {
            spot.add(new ParkingSpot(i));
        }
    }
    public boolean carPark(Car car){
        for(ParkingSpot spots : spot){
            if(spots.isAvailable()) {
                spots.occupyParking(car);
                System.out.println("Car with License No : "+car.getLicensePlateNo()+" parked at spot no. : "+spots.getSpotNo());
                return true;
            }
        }
        System.out.println("Sorry for Inconvienience. But the Parking Lot is full !!");
        return false;
    }
    public boolean removeCar(String LicensePlateNo){
        for(ParkingSpot spots : spot){
            if(!spots.isAvailable() && spots.getCar().getLicensePlateNo().equalsIgnoreCase(LicensePlateNo)){
                spots.vaccantParking();
                System.out.println("Car with License No. : "+LicensePlateNo+" removed from parking");
                return true;
            }
        }
        System.out.println("Car with License No. : "+LicensePlateNo+" not found.");
        return false;
    }
}
class Test{
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5);
        Car car1 = new Car("BR30339449");
        Car car2 = new Car("UP96305280");
        Car car3 = new Car("DL30339449");
        Car car4 = new Car("WB96305280");
        Car car5 = new Car("MH30339449");
        Car car6 = new Car("MP96305280");
        parkingLot.carPark(car1);
        parkingLot.carPark(car2);
        parkingLot.carPark(car3);
        parkingLot.carPark(car4);
        parkingLot.carPark(car2);
    }
}
