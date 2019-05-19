package parking_lot;

import org.junit.jupiter.api.Test;
import parking_lot.exception.CarAlreadyParkedException;
import parking_lot.exception.CarNotParkedException;
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

        assertThrows(CarNotParkedException.class, () -> {
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
        Car car2 = new Car("EW-012-22");


        attendant.park(car1);
        attendant.park(car2);
    }

    @Test
    public void park_shouldThrowCarAlreadyParkedException_whenCarIsAlreadyParkedInFirstParkingLot() {
        ParkingLot parkingLot1 = ParkingLot.createParkingLot(1);
        ParkingLot parkingLot2 = ParkingLot.createParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {{
            add(parkingLot1);
            add(parkingLot2);
        }};
        Car car1 = new Car("EW-012-23");
        Car car2 = new Car("EW-012-23");
        Attendant attendant = createAttendant(parkingLots);

        attendant.park(car1);

        assertThrows(CarAlreadyParkedException.class, () -> {
            attendant.park(car2);
        });
    }

    @Test
    public void park_shouldThrowSpaceNotAvailable_whenParkingLotsAreFull() {
        ParkingLot parkingLot1 = ParkingLot.createParkingLot(1);
        ParkingLot parkingLot2 = ParkingLot.createParkingLot(1);

        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {{
            add(parkingLot1);
            add(parkingLot2);
        }};
        Car car1 = new Car("EW-012-22");
        Car car2 = new Car("EW-012-23");
        Car car3 = new Car("EW-012-24");

        Attendant attendant = createAttendant(parkingLots);

        attendant.park(car1);
        attendant.park(car2);

        assertThrows(SpaceNotAvailableException.class, () -> {
            attendant.park(car3);
        });
    }

    @Test
    public void unpark_shouldUnParkTheCar_whenItIsInSecondParkingLot() {
        ParkingLot parkingLot1 = ParkingLot.createParkingLot(1);
        ParkingLot parkingLot2 = ParkingLot.createParkingLot(2);
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {{
            add(parkingLot1);
            add(parkingLot2);
        }};

        Attendant attendant = createAttendant(parkingLots);

        Car car1 = new Car("EW-012-23");
        Car car2 = new Car("EW-012-22");
        Car car3 = new Car("EW-012-24");


        attendant.park(car1);
        attendant.park(car2);
        attendant.park(car3);

        attendant.unpark(car3);
    }


    @Test
    public void unpark_shouldThrowCarNotParkedException_whenCarIsNotParkedIn() {
        ParkingLot parkingLot1 = ParkingLot.createParkingLot(1);
        ParkingLot parkingLot2 = ParkingLot.createParkingLot(2);

        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {{
            add(parkingLot1);
            add(parkingLot2);
        }};

        Car car = new Car("EW-012-23");

        Attendant attendant = createAttendant(parkingLots);

        assertThrows(CarNotParkedException.class, () -> {
            attendant.unpark(car);
        });

    }

    @Test
    public void notify_shouldNotifyAttendant_WhenParkingLotsGotSpaceAvailable() {
        ParkingLot parkingLot1 = ParkingLot.createParkingLot(1);
        ParkingLot parkingLot2 = ParkingLot.createParkingLot(1);

        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>() {{
            add(parkingLot1);
            add(parkingLot2);
        }};

        Car car1 = new Car("EW-012-22");
        Car car2 = new Car("EW-012-23");

        Attendant attendant = createAttendant(parkingLots);

        attendant.park(car1);
        attendant.park(car2);
        attendant.unpark(car2);

        assertTrue(attendant.hasNotifiedParkingLotSpaceAvailable());
    }

}