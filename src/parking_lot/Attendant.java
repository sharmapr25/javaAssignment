package parking_lot;

import parking_lot.exception.CarAlreadyParkedException;
import parking_lot.exception.CarNotParkedException;
import parking_lot.exception.SpaceNotAvailableException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Attendant implements ParkingLotObserver {
    private List<ParkingLot> parkingLots;
    private List<ParkingLot> availableParkingLots;

    private Attendant(List<ParkingLot> parkingLots) {
        this.parkingLots = new ArrayList<>();
        this.parkingLots.addAll(parkingLots);
        this.availableParkingLots = new ArrayList<>();
        this.availableParkingLots.addAll(parkingLots);
    }

    public void park(Car car) {
        if (isCarAlreadyParked(car)) {
            throw new CarAlreadyParkedException();
        }
        if (availableParkingLots.isEmpty()) {
            throw new SpaceNotAvailableException();
        }
        availableParkingLots.get(0).park(car);
    }

    private boolean isCarAlreadyParked(Car car) {
        List<ParkingLot> matchedCars = parkingLots.stream().filter(parkingLot -> parkingLot.isParked(car)).collect(Collectors.toList());
        return !matchedCars.isEmpty();
    }

    public void unpark(Car car) {
        List<ParkingLot> matchedParkingLots = parkingLots.stream().filter(parkingLot -> parkingLot.isParked(car)).collect(Collectors.toList());

        if (matchedParkingLots.isEmpty()) {
            throw new CarNotParkedException();
        }
        matchedParkingLots.get(0).unpark(car);
    }

    @Override
    public void notifyParkingLotIsFull(ParkingLot parkingLot) {
        availableParkingLots.remove(parkingLot);

    }

    @Override
    public void notifyParkingLotSpaceAvailable(ParkingLot parkingLot) {
        availableParkingLots.add(parkingLot);
    }

    public boolean hasNotifiedParkingLotFull() {
        return availableParkingLots.isEmpty();
    }

    public boolean hasNotifiedParkingLotSpaceAvailable() {
        return availableParkingLots.size() > 0;
    }

    public static Attendant createAttendant(List<ParkingLot> parkingLots) {
        Attendant attendant = new Attendant(parkingLots);
        parkingLots.forEach(parkingLot -> parkingLot.addObserver(attendant));
        return attendant;
    }
}
