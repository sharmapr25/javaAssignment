package parking_lot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parking_lot.exception.CarAlreadyParkedException;
import parking_lot.exception.CarNotParkedException;
import parking_lot.exception.InvalidParkingLotException;
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
        ParkingLot parkingLot = ParkingLot.createParkingLot(1);
        parkingLot.park(car);

        assertTrue(parkingLot.isParked(car));
    }

    @Test
    public void creatingParkingLot_shouldThrowInvalidParkingLotException_whenInitiatingParkingLotWithZero() {
       assertThrows(InvalidParkingLotException.class, ()->{ParkingLot.createParkingLot(0);});
    }

    @Test
    public void isParked_shouldReturnFalse_whenCarIsNotParkedInParkingLot() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(1);
        Car car = new Car("EW-012-23");

        assertFalse(parkingLot.isParked(car));
    }

    @Test
    public void park_shouldThrowSpaceNotAvailableException_whenParkingLotDoesNotHaveSpaceForGivenCar() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(1);
        Car car1 = new Car("EW-012-23");
        Car car2 = new Car("EW-322-33");

        parkingLot.park(car1);

        assertThrows(SpaceNotAvailableException.class, () -> {
            parkingLot.park(car2);
        });
    }

    @Test
    public void park_shouldThrowCarAlreadyParkedException_whenGivenCarIsAlreadyParked() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(2);
        Car car = new Car("EW-012-23");

        parkingLot.park(car);

        assertThrows(CarAlreadyParkedException.class, () -> {
            parkingLot.park(car);
        });
    }

    @Test
    public void isParked_shouldReturnFalse_whenGiveCarIsUnparked() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(2);
        Car car = new Car("EW-012-23");

        parkingLot.park(car);
        parkingLot.unpark(car);

        assertFalse(parkingLot.isParked(car));

    }

    @Test
    public void unpark_shouldThrowCarIsNotParkedException_whenCarHasNotParkInParkingLot() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(2);
        Car car = new Car("EW-012-23");

        assertThrows(CarNotParkedException.class, () -> {
            parkingLot.unpark(car);
        });
    }

    @Test
    public void notify_shouldNotifyParkingLotOwner_whenParkingLotIsFull() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(1);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(owner);
        parkingLot.park(car);

        verify(owner, times(1)).notifyParkingLotIsFull(parkingLot);
    }

    @Test
    public void notify_shouldNotNotifyParkingLotOwner_whenParkingLotIsNotFull() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(2);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(owner);
        parkingLot.park(car);

        verify(owner, never()).notifyParkingLotIsFull(parkingLot);
    }

    @Test
    public void notify_shouldNotifyParkingLotOwner_whenParkingLotGetFreeSpace() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(1);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(owner);
        parkingLot.park(car);
        parkingLot.unpark(car);


        verify(owner, times(1)).notifyParkingLotSpaceAvailable(parkingLot);
    }

    @Test
    public void notify_shouldNotNotifyParkingLotOwner_whenParkingLotAlreadyHasFreeSpaceAndSomebodyUnparkTheCar() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(2);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(owner);
        parkingLot.park(car);
        parkingLot.unpark(car);

        verify(owner, never()).notifyParkingLotSpaceAvailable(parkingLot);

    }

    @Test
    public void notify_shouldNotifyParkingLotOwnerTwoTimesParkingLotFullAndOneTimeSpaceWasAvailable_whenParkCarTwiceAndUnparkOneTime() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(1);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(owner);
        parkingLot.park(car);
        parkingLot.unpark(car);

        parkingLot.park(car);

        verify(owner, times(2)).notifyParkingLotIsFull(parkingLot);
        verify(owner, times(1)).notifyParkingLotSpaceAvailable(parkingLot);

    }

    @Test
    public void notify_shouldNotifyTrafficCop_whenParkingLotIsFull() {
        TrafficCop trafficCop = mock(TrafficCop.class);
        ParkingLot parkingLot = ParkingLot.createParkingLot(1);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(trafficCop);
        parkingLot.park(car);

        verify(trafficCop, times(1)).notifyParkingLotIsFull(parkingLot);
    }

    @Test
    public void notify_shouldNotNotifyTrafficCop_whenParkingLotIsNotFull() {
        TrafficCop trafficCop = mock(TrafficCop.class);
        ParkingLot parkingLot = ParkingLot.createParkingLot(2);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(trafficCop);
        parkingLot.park(car);

        verify(trafficCop, never()).notifyParkingLotIsFull(parkingLot);
    }

    @Test
    public void notify_shouldNotifyTrafficCop_whenParkingLotHasSpaceAvailable() {
        TrafficCop trafficCop = mock(TrafficCop.class);
        ParkingLot parkingLot = ParkingLot.createParkingLot(1);
        Car car = new Car("EW-012-23");

        parkingLot.addObserver(trafficCop);
        parkingLot.park(car);
        parkingLot.unpark(car);


        verify(trafficCop, times(1)).notifyParkingLotSpaceAvailable(parkingLot);
    }

    @Test
    public void notify_shouldNotNotifyTrafficCop_whenParkingLotSpaceIsAvailableAndNotParkedAnyCar() {
        TrafficCop trafficCop = mock(TrafficCop.class);
        ParkingLot parkingLot = ParkingLot.createParkingLot(2);

        parkingLot.addObserver(trafficCop);

        verify(trafficCop, never()).notifyParkingLotSpaceAvailable(parkingLot);
    }

}