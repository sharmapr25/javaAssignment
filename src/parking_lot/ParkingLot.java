package parking_lot;

import parking_lot.exception.CarAlreadyParkedException;
import parking_lot.exception.CarNotParkedException;
import parking_lot.exception.InvalidParkingLotException;
import parking_lot.exception.SpaceNotAvailableException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLot {
    private List<Slot> slots;
    private int maxCapacity;
    private List<ParkingLotObserver> observers;


    private ParkingLot(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.slots = new ArrayList<>();
        observers = new ArrayList<>();
    }


    public void park(Car car) {
        if (isParked(car)) {
            throw new CarAlreadyParkedException();
        }
        if (isFull()) {
            throw new SpaceNotAvailableException();
        }
        slots.add(new Slot(car));

        if (isFull()) {
            observers.forEach(observer -> observer.notifyParkingLotIsFull(this));
        }
    }


    public boolean isParked(Car car) {
        return !slots.stream().filter(slot -> slot.hasCar(car)).collect(Collectors.toList()).isEmpty();
    }

    private boolean isFull() {
        return slots.size() == maxCapacity;
    }

    public void unpark(Car car) {
        if (!isParked(car)) {
            throw new CarNotParkedException();
        }
        if (isFull()) {
            observers.forEach(observer -> observer.notifyParkingLotSpaceAvailable(this));
        }
        slots = slots.stream().filter(slot -> !slot.hasCar(car)).collect(Collectors.toList());
    }

    public void addObserver(ParkingLotObserver observer) {
        observers.add(observer);
    }

    public static ParkingLot createParkingLot(int maxCapacity) {
        if (maxCapacity > 0) {
            return new ParkingLot(maxCapacity);
        }
        throw new InvalidParkingLotException();
    }
}
