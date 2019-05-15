package parking_lot;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ParkingLot {
    private int space;
    private ArrayList<Slot> slots;



    public ParkingLot(int space) {
        this.slots = new ArrayList<>(space);
    }


    public void park(Car car) {
        slots.add(new Slot(car));
    }

    public boolean isCarParked(Car car) {
        return !slots.stream().filter(slot -> slot.hasCar(car)).collect(Collectors.toList()).isEmpty();
    }
}
