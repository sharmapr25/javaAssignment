package parking_lot;

public class Owner implements ParkingLotObserver {

    private boolean isParkingLotFull;
    private boolean isParkingSpaceAvailable;


    public Owner() {
        this.isParkingLotFull = false;
        this.isParkingSpaceAvailable = false;

    }

    public boolean isNotifiedParkingLotFull() {
        return isParkingLotFull;
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

    public boolean isNotifiedParkingLotSpaceAvailable() {
        return isParkingSpaceAvailable;
    }
}