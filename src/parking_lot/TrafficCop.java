package parking_lot;

public class TrafficCop implements ParkingLotObserver{
    private boolean isParkingLotFull;
    private boolean isParkingSpaceAvailable;

    @Override
    public void notifyParkingLotIsFull(ParkingLot parkingLot) {
        this.isParkingLotFull = true;
        this.isParkingSpaceAvailable = false;

    }

    @Override
    public void notifyParkingLotSpaceAvailable(ParkingLot parkingLot) {
        this.isParkingSpaceAvailable = true;
        this.isParkingLotFull = false;
    }
}
