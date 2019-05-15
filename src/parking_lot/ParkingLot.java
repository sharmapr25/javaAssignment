package parking_lot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLot {
    private List<Slot> slots;
    private int maxCapacity;


    public ParkingLot(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.slots = new ArrayList<>();
    }


    public void park(Car car) {
        if (isCarParked(car)) {
            throw new CarAlreadyParkedException();
        }
        if (!isSpaceAvailable()) {
            throw new SpaceNotAvailableException();
        }
        slots.add(new Slot(car));
    }


    public boolean isCarParked(Car car) {
        return !slots.stream().filter(slot -> slot.hasCar(car)).collect(Collectors.toList()).isEmpty();
    }

    private boolean isSpaceAvailable() {
        return slots.size() < maxCapacity;
    }

    public void unpark(Car car) {
        if (!isCarParked(car)) {
            throw new CarIsNotParkedException();
        }
        slots = slots.stream().filter(slot -> !slot.hasCar(car)).collect(Collectors.toList());
    }
}
