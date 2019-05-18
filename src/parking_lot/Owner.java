package parking_lot;

public class Owner implements ParkingLotObserver{

    private boolean isParkingLotFull;


    public Owner() {
        this.isParkingLotFull = false;
    }

    public boolean isNotified() {
        return isParkingLotFull;
    }

    @Override
    public void notifyParkingLotIsFull() {
        this.isParkingLotFull = true;
    }
}
