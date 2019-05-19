package parking_lot;

public class Notifiable implements ParkingLotObserver {

    private boolean isParkingLotFull;
    private boolean isParkingSpaceAvailable;


    public Notifiable() {
        this.isParkingLotFull = false;
        this.isParkingSpaceAvailable = false;

    }

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
