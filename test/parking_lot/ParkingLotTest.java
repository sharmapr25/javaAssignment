package parking_lot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parking_lot.exception.CarAlreadyParkedException;
import parking_lot.exception.CarNotParkedException;
import parking_lot.exception.InvalidParkingLotException;
import parking_lot.exception.SpaceNotAvailableException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static parking_lot.ParkingLot.*;

class ParkingLotTest {
    ParkingLotObserver owner;

    @BeforeEach
    public void setup() {
        owner = mock(ParkingLotObserver.class);
    }

    @Test
    public void isParked_shouldReturnTrue_whenCarIsParkedInParkingLot() {
        Car car = new Car("EW-012-23");
        ParkingLot parkingLot = createParkingLot(1);
        parkingLot.park(car);

        assertTrue(parkingLot.isParked(car));
    }

    @Test
    public void creatingParkingLot_shouldThrowInvalidParkingLotException_whenInitiatingParkingLotWithZero() {
        assertThrows(InvalidParkingLotException.class, () -> {
            createParkingLot(0);
        });
    }

    @Test
    public void isParked_shouldReturnFalse_whenCarIsNotParkedInParkingLot() {
        ParkingLot parkingLot = createParkingLot(1);
        Car car = new Car("EW-012-23");

        assertFalse(parkingLot.isParked(car));
    }

    @Test
    public void park_shouldThrowSpaceNotAvailableException_whenParkingLotDoesNotHaveSpaceForGivenCar() {
        ParkingLot parkingLot = createParkingLot(1);
        Car car1 = new Car("EW-012-23");
        Car car2 = new Car("EW-322-33");

        parkingLot.park(car1);

        assertThrows(SpaceNotAvailableException.class, () -> {
            parkingLot.park(car2);
        });
    }

    @Test
    public void park_shouldThrowCarAlreadyParkedException_whenGivenCarIsAlreadyParked() {
        ParkingLot parkingLot = createParkingLot(2);
        Car car = new Car("EW-012-23");

        parkingLot.park(car);

        assertThrows(CarAlreadyParkedException.class, () -> {
            parkingLot.park(car);
        });
    }

    @Test
    public void isParked_shouldReturnFalse_whenGiveCarIsUnparked() {
        ParkingLot parkingLot = createParkingLot(2);
        Car car = new Car("EW-012-23");

        parkingLot.park(car);
        parkingLot.unpark(car);

        assertFalse(parkingLot.isParked(car));

    }

    @Test
    public void unpark_shouldThrowCarIsNotParkedException_whenCarHasNotParkInParkingLot() {
        ParkingLot parkingLot = createParkingLot(2);
        Car car = new Car("EW-012-23");

        assertThrows(CarNotParkedException.class, () -> {
            parkingLot.unpark(car);
        });
    }

    @Test
    public void notify_shouldNotifyParkingLotOwner_whenParkingLotIsFull() {
        ParkingLot parkingLot = createParkingLot(1);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(owner);
        parkingLot.park(car);

        verify(owner, times(1)).notifyParkingLotIsFull(parkingLot);
    }

    @Test
    public void notify_shouldNotNotifyParkingLotOwner_whenParkingLotIsNotFull() {
        ParkingLot parkingLot = createParkingLot(2);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(owner);
        parkingLot.park(car);

        verify(owner, never()).notifyParkingLotIsFull(parkingLot);
    }

    @Test
    public void notify_shouldNotifyParkingLotOwner_whenParkingLotGetFreeSpace() {
        ParkingLot parkingLot = createParkingLot(1);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(owner);
        parkingLot.park(car);
        parkingLot.unpark(car);


        verify(owner, times(1)).notifyParkingLotSpaceAvailable(parkingLot);
    }

    @Test
    public void notify_shouldNotNotifyParkingLotOwner_whenParkingLotAlreadyHasFreeSpaceAndSomebodyUnparkTheCar() {
        ParkingLot parkingLot = createParkingLot(2);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(owner);
        parkingLot.park(car);
        parkingLot.unpark(car);

        verify(owner, never()).notifyParkingLotSpaceAvailable(parkingLot);

    }

    @Test
    public void notify_shouldNotifyParkingLotOwnerTwoTimesParkingLotFullAndOneTimeSpaceWasAvailable_whenParkCarTwiceAndUnparkOneTime() {
        ParkingLot parkingLot = createParkingLot(1);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(owner);
        parkingLot.park(car);
        parkingLot.unpark(car);

        parkingLot.park(car);

        verify(owner, times(2)).notifyParkingLotIsFull(parkingLot);
        verify(owner, times(1)).notifyParkingLotSpaceAvailable(parkingLot);

    }

    @Test
    public void notify_shouldNotifyParkingLotObserver_whenParkingLotIsFull() {
        ParkingLotObserver trafficCop = mock(ParkingLotObserver.class);
        ParkingLot parkingLot = createParkingLot(1);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(trafficCop);
        parkingLot.park(car);

        verify(trafficCop, times(1)).notifyParkingLotIsFull(parkingLot);
    }

    @Test
    public void notify_shouldNotNotifyParkingLotObserver_whenParkingLotIsNotFull() {
        ParkingLotObserver trafficCop = mock(ParkingLotObserver.class);
        ParkingLot parkingLot = createParkingLot(2);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(trafficCop);
        parkingLot.park(car);

        verify(trafficCop, never()).notifyParkingLotIsFull(parkingLot);
    }

    @Test
    public void notify_shouldNotifyParkingLotObserver_whenParkingLotHasSpaceAvailable() {
        ParkingLotObserver trafficCop = mock(ParkingLotObserver.class);
        ParkingLot parkingLot = createParkingLot(1);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(trafficCop);
        parkingLot.park(car);
        parkingLot.unpark(car);


        verify(trafficCop, times(1)).notifyParkingLotSpaceAvailable(parkingLot);
    }

    @Test
    public void notify_shouldNotNotifyParkingLotObserver_whenParkingLotSpaceIsAvailableAndNotParkedAnyCar() {
        ParkingLotObserver trafficCop = mock(ParkingLotObserver.class);
        ParkingLot parkingLot = createParkingLot(2);

        parkingLot.addObserver(trafficCop);

        verify(trafficCop, never()).notifyParkingLotSpaceAvailable(parkingLot);
    }

    @Test
    public void hasMoreFreeSpace_shouldReturnTrue_whenGivenParkingLotHasMoreSpaceThanOtherParkingLot() {
        ParkingLot parkingLot1 = createParkingLot(2);
        ParkingLot parkingLot2 = createParkingLot(1);

        assertTrue(parkingLot1.hasMoreFreeSpace(parkingLot2));
    }

    @Test
    public void hasMoreFreeSpace_shouldReturnFalse_whenGivenParkingLotHasLessSpaceThanOtherParkingLot() {
        ParkingLot parkingLot1 = createParkingLot(1);
        ParkingLot parkingLot2 = createParkingLot(2);

        assertFalse(parkingLot1.hasMoreFreeSpace(parkingLot2));
    }

    @Test
    public void hasMoreFreeCapacity_shouldReturnTrue_whenGivenParkingLotHasMoreFreeCapacityThanOtherParkingLot() {
        ParkingLot parkingLot1 = createParkingLot(3);
        ParkingLot parkingLot2 = createParkingLot(2);

        Car car1 = new Car("EW-012-23");

        parkingLot1.park(car1);

        assertTrue(parkingLot1.hasMoreCapacity(parkingLot2));
    }

    @Test
    public void hasMoreFreeCapacity_shouldReturnFalse_whenGivenParkingLotHasLessFreeCapacityThanOtherParkingLot() {
        ParkingLot parkingLot1 = createParkingLot(2);
        ParkingLot parkingLot2 = createParkingLot(3);

        Car car1 = new Car("EW-012-23");

        parkingLot2.park(car1);

        assertFalse(parkingLot1.hasMoreCapacity(parkingLot2));
    }

}