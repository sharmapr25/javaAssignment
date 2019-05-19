package parking_lot;

public interface ParkingLotObserver {
    void notifyParkingLotIsFull(ParkingLot parkingLot);

    void notifyParkingLotSpaceAvailable(ParkingLot parkingLot);
}
