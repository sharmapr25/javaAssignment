package parking_lot;

import java.util.List;

public class Attendant implements ParkingLotObserver {
    private List<ParkingLot> parkingLots;
    private List<ParkingLot> availableParkingLots;

    private boolean isParkingLotFull;
    private boolean isParkingSpaceAvailable;

    public Attendant(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.availableParkingLots = parkingLots;
    }

    public void park(Car car) {
        
        parkingLots.get(0).park(car);
    }

    public void unpark(Car car) {
        parkingLots.get(0).unpark(car);
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
