package parking_lot;

import org.junit.jupiter.api.Test;
import parking_lot.exception.CarAlreadyParkedException;
import parking_lot.exception.CarIsNotParkedException;
import parking_lot.exception.SpaceNotAvailableException;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    public void isParked_shouldReturnTrue_whenCarIsParkedInParkingLot() {
        Car car = new Car("EW-012-23");
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(car);

        assertTrue(parkingLot.isParked(car));
    }

    @Test
    public void isParked_shouldReturnFalse_whenCarIsNotParkedInParkingLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("EW-012-23");

        assertFalse(parkingLot.isParked(car));
    }

    @Test
    public void park_shouldThrowSpaceNotAvailableException_whenParkingLotDoesNotHaveSpaceForGivenCar() {
        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car("EW-012-23");

        assertThrows(SpaceNotAvailableException.class, () -> {
            parkingLot.park(car);
        });
    }

    @Test
    public void park_shouldThrowCarAlreadyParkedException_whenGivenCarIsAlreadyParked() {
        ParkingLot parkingLot = new ParkingLot(2);
        Car car = new Car("EW-012-23");

        parkingLot.park(car);

        assertThrows(CarAlreadyParkedException.class, () -> {
            parkingLot.park(car);
        });
    }

    @Test
    public void isParked_shouldReturnFalse_whenGiveCarIsUnparked() {
        ParkingLot parkingLot = new ParkingLot(2);
        Car car = new Car("EW-012-23");

        parkingLot.park(car);
        parkingLot.unpark(car);

        assertFalse(parkingLot.isParked(car));

    }

    @Test
    public void unpark_shouldThrowCarIsNotParkedException_whenCarHasNotParkInParkingLot() {
        ParkingLot parkingLot = new ParkingLot(2);
        Car car = new Car("EW-012-23");

        assertThrows(CarIsNotParkedException.class, () -> {
            parkingLot.unpark(car);
        });
    }

    @Test
    public void notify_shouldNotifyParkingLotOwner_whenParkingLotIsFull(){
        Owner owner = new Owner();
        ParkingLot parkingLot = new ParkingLot(1);

        Car car = new Car("EW-012-23");

        parkingLot.addObserver(owner);
        parkingLot.park(car);

        assertTrue(owner.isNotified());
    }

    @Test
    public void notify_shouldNotNotifyParkingLotOwner_whenParkingLotIsNotFull(){
        Owner owner = new Owner();
        ParkingLot parkingLot = new ParkingLot(2);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(owner);
        parkingLot.park(car);

        assertFalse(owner.isNotified());
    }

}