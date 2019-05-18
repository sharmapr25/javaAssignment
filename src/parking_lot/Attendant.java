package parking_lot;

public class Attendant implements ParkingLotObserver {
    private ParkingLot parkingLot;
    private boolean isParkingLotFull;
    private boolean isParkingSpaceAvailable;

    public Attendant(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void park(Car car) {
        parkingLot.park(car);
    }

    public void unpark(Car car) {
        parkingLot.unpark(car);
    }

    @Override
    public void notifyParkingLotIsFull() {
        this.isParkingLotFull = true;
        this.isParkingSpaceAvailable = false;

    }

    @Override
    public void notifyParkingLotSpaceAvailable() {
        this.isParkingSpaceAvailable = true;
        this.isParkingLotFull = false;
    }

    public boolean hasNotifiedParkingLotFull() {
        return isParkingLotFull;
    }

    public boolean hasNotifiedParkingLotSpaceAvailable() {
        return isParkingSpaceAvailable;
    }
}
