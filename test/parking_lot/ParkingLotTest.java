package parking_lot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    public void isCarParked_shouldReturnTrue_whenCarIsParkedInParkingLot() {
        Car car = new Car("EW-012-23");
        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.park(car);

        assertTrue(parkingLot.isCarParked(car));
    }

    @Test
    public void isCarParked_shouldReturnFalse_whenCarIsNotParkedInParkingLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("EW-012-23");

        assertFalse(parkingLot.isCarParked(car));
    }



}