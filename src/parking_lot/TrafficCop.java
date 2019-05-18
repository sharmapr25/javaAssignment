package parking_lot;

public class TrafficCop implements ParkingLotObserver{
    private boolean isParkingLotFull;
    private boolean isParkingSpaceAvailable;

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
}
