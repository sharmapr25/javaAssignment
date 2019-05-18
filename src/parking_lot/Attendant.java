package parking_lot;

public class Attendant {
    private ParkingLot parkingLot;

    public Attendant(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void park(Car car) {
        parkingLot.park(car);
    }

    public void unpark(Car car) {
        parkingLot.unpark(car);
    }
}
