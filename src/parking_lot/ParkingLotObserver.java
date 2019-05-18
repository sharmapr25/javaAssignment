package parking_lot;

public interface ParkingLotObserver {
    void notifyParkingLotIsFull();

    void notifyParkingLotSpaceAvailable();
}
