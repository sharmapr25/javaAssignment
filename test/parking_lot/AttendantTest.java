package parking_lot;

import org.junit.jupiter.api.Test;
import parking_lot.exception.CarAlreadyParkedException;
import parking_lot.exception.CarIsNotParkedException;
import parking_lot.exception.SpaceNotAvailableException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static parking_lot.Attendant.createAttendant;

class AttendantTest {

    @Test
    public void park_shouldParkCar_whenThereIsSpaceInParkingLot() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(2);
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {{
            add(parkingLot);
        }};
        Attendant attendant = createAttendant(parkingLots);
        Car car = new Car("EW-012-23");

        attendant.park(car);
    }

    @Test
    public void park_shouldThrowSpaceNotAvailableException_whenThereIsNoSpaceInParkingLot() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {{
            add(parkingLot);
        }};
        Attendant attendant = createAttendant(parkingLots);
        Car car1 = new Car("EW-012-23");
        Car car2 = new Car("EW-012-20");

        attendant.park(car1);
        assertThrows(SpaceNotAvailableException.class, () -> {
            attendant.park(car2);
        });
    }

    @Test
    public void park_shouldThrowCarAlreadyParkException_whenCarIsAlreadyPark() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {{
            add(parkingLot);
        }};
        Attendant attendant = createAttendant(parkingLots);
        Car car = new Car("EW-012-23");

        attendant.park(car);

        assertThrows(CarAlreadyParkedException.class, () -> {
            attendant.park(car);
        });
    }

    @Test
    public void unpark_shouldUnparkCar_whenGivenCarIsParkInParkingLot() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {{
            add(parkingLot);
        }};
        Attendant attendant = createAttendant(parkingLots);
        Car car = new Car("EW-012-23");

        attendant.park(car);
        attendant.unpark(car);
    }

    @Test
    public void unpark_shouldThrowCarIsNotParkedException_whenGivenCarIsNotParkInParkingLot() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {{
            add(parkingLot);
        }};
        Attendant attendant = createAttendant(parkingLots);
        Car car = new Car("EW-012-23");

        assertThrows(CarIsNotParkedException.class, () -> {
            attendant.unpark(car);
        });
    }

    @Test
    public void notify_shouldNotifyAttendant_whenParkingLotIsFull() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {{
            add(parkingLot);
        }};
        Attendant attendant = createAttendant(parkingLots);
        Car car = new Car("EW-012-23");

        attendant.park(car);


        assertTrue(attendant.hasNotifiedParkingLotFull());
    }

    @Test
    public void notify_shouldNotNotifyAttendant_whenParkingLotIsNotFull() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {{
            add(parkingLot);
        }};
        Attendant attendant = createAttendant(parkingLots);


        assertFalse(attendant.hasNotifiedParkingLotFull());
    }

    @Test
    public void notify_shouldNotifyAttendant_WhenParkingLotHasSpaceAvailable() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {{
            add(parkingLot);
        }};
        Attendant attendant = createAttendant(parkingLots);
        Car car = new Car("EW-012-23");

        attendant.park(car);
        attendant.unpark(car);

        assertTrue(attendant.hasNotifiedParkingLotSpaceAvailable());
    }


    @Test
    public void notify_shouldNotNotifyAttendant_WhenParkingLotHasNoSpaceAvailable() {
        ParkingLot parkingLot = ParkingLot.createParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {{
            add(parkingLot);
        }};
        Attendant attendant = createAttendant(parkingLots);
        Car car = new Car("EW-012-23");

        attendant.park(car);

        assertFalse(attendant.hasNotifiedParkingLotSpaceAvailable());
    }

    @Test
    public void park_shouldParkTheCar_whenSecondParkingLotHasSpace() {
        ParkingLot parkingLot1 = ParkingLot.createParkingLot(1);
        ParkingLot parkingLot2 = ParkingLot.createParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {{
            add(parkingLot1);
            add(parkingLot2);
        }};

        Attendant attendant = createAttendant(parkingLots);

        Car car1 = new Car("EW-012-23");
        Car car2 = new Car("EW-012-23");


        attendant.park(car1);
        attendant.park(car2);
    }



}