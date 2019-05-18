package parking_lot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parking_lot.exception.CarAlreadyParkedException;
import parking_lot.exception.CarIsNotParkedException;
import parking_lot.exception.SpaceNotAvailableException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ParkingLotTest {
    Owner owner;

    @BeforeEach
    public void setup() {
        owner = mock(Owner.class);
    }

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
    public void notify_shouldNotifyParkingLotOwner_whenParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(owner);
        parkingLot.park(car);

        verify(owner, times(1)).notifyParkingLotIsFull();
    }

    @Test
    public void notify_shouldNotNotifyParkingLotOwner_whenParkingLotIsNotFull() {
        ParkingLot parkingLot = new ParkingLot(2);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(owner);
        parkingLot.park(car);

        verify(owner, never()).notifyParkingLotIsFull();
    }

    @Test
    public void notify_shouldNotifyParkingLotOwner_whenParkingLotGetFreeSpace() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(owner);
        parkingLot.park(car);
        parkingLot.unpark(car);


        verify(owner, times(1)).notifyParkingLotSpaceAvailable();
    }

    @Test
    public void notify_shouldNotNotifyParkingLotOwner_whenParkingLotAlreadyHasFreeSpaceAndSomebodyUnparkTheCar() {
        ParkingLot parkingLot = new ParkingLot(2);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(owner);
        parkingLot.park(car);
        parkingLot.unpark(car);

        verify(owner, never()).notifyParkingLotSpaceAvailable();

    }

    @Test
    public void notify_shouldNotifyParkingLotOwnerTwoTimesParkingLotFullAndOneTimeSpaceWasAvailable_whenParkCarTwiceAndUnparkOneTime() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(owner);
        parkingLot.park(car);
        parkingLot.unpark(car);

        parkingLot.park(car);

        verify(owner, times(2)).notifyParkingLotIsFull();
        verify(owner, times(1)).notifyParkingLotSpaceAvailable();

    }

}