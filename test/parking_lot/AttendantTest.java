package parking_lot;

import org.junit.jupiter.api.Test;
import parking_lot.exception.CarAlreadyParkedException;
import parking_lot.exception.CarIsNotParkedException;
import parking_lot.exception.SpaceNotAvailableException;

import static org.junit.jupiter.api.Assertions.*;

class AttendantTest {

    @Test
    public void park_shouldParkCar_whenThereIsSpaceInParkingLot() {
        ParkingLot parkingLot = new ParkingLot(2);
        Attendant attendant = new Attendant(parkingLot);
        Car car = new Car("EW-012-23");

        attendant.park(car);
    }

    @Test
    public void park_shouldThrowSpaceNotAvailableException_whenThereIsNoSpaceInParkingLot() {
        ParkingLot parkingLot = new ParkingLot(0);
        Attendant attendant = new Attendant(parkingLot);
        Car car = new Car("EW-012-23");

        assertThrows(SpaceNotAvailableException.class, () -> {
            attendant.park(car);
        });
    }

    @Test
    public void park_shouldThrowCarAlreadyParkException_whenCarIsAlreadyPark() {
        ParkingLot parkingLot = new ParkingLot(1);
        Attendant attendant = new Attendant(parkingLot);
        Car car = new Car("EW-012-23");

        attendant.park(car);

        assertThrows(CarAlreadyParkedException.class, () -> {
            attendant.park(car);
        });
    }

    @Test
    public void unpark_shouldUnparkCar_whenGivenCarIsParkInParkingLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        Attendant attendant = new Attendant(parkingLot);
        Car car = new Car("EW-012-23");

        attendant.park(car);
        attendant.unpark(car);
    }

    @Test
    public void unpark_shouldThrowCarIsNotParkedException_whenGivenCarIsNotParkInParkingLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        Attendant attendant = new Attendant(parkingLot);
        Car car = new Car("EW-012-23");

        assertThrows(CarIsNotParkedException.class, () -> {
            attendant.unpark(car);
        });
    }

    @Test
    public void notify_shouldNotifyAttendant_whenParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        Attendant attendant = new Attendant(parkingLot);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(attendant);
        attendant.park(car);


        assertTrue(attendant.hasNotifiedParkingLotFull());
    }

    @Test
    public void notify_shouldNotNotifyAttendant_whenParkingLotIsNotFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        Attendant attendant = new Attendant(parkingLot);

        parkingLot.addObserver(attendant);

        assertFalse(attendant.hasNotifiedParkingLotFull());
    }

    @Test
    public void notify_shouldNotifyAttendant_WhenParkingLotHasSpaceAvailable() {
        ParkingLot parkingLot = new ParkingLot(1);
        Attendant attendant = new Attendant(parkingLot);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(attendant);
        attendant.park(car);
        attendant.unpark(car);

        assertTrue(attendant.hasNotifiedParkingLotSpaceAvailable());
    }


    @Test
    public void notify_shouldNotNotifyAttendant_WhenParkingLotHasNoSpaceAvailable() {
        ParkingLot parkingLot = new ParkingLot(0);
        Attendant attendant = new Attendant(parkingLot);

        parkingLot.addObserver(attendant);

        assertFalse(attendant.hasNotifiedParkingLotSpaceAvailable());
    }

}