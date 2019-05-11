package quantity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static quantity.DistanceUnit.CENTIMETER;
import static quantity.DistanceUnit.KILOMETER;
import static quantity.DistanceUnit.METER;

class DistanceTest {

    @Test
    @DisplayName("convert should return 1 m when given distance is 100 cm")
    public void convertWhenGivenDistancIsHundredCentimeter() {
        Distance distance = new Distance(100, CENTIMETER);
        Distance distanceInMeter = distance.convert(METER);

        Distance expectedDistance = new Distance(1, METER);
        assertEquals(expectedDistance, distanceInMeter);

    }

    @Test
    @DisplayName("convert should return 1 km when given distance is 1000 m")
    public void convertWhenGivenDistancIsThousandMeter() {
        Distance distance = new Distance(1000, METER);
        Distance distanceInMeter = distance.convert(KILOMETER);

        Distance expectedDistance = new Distance(1, KILOMETER);
        assertEquals(expectedDistance, distanceInMeter);

    }

    @Test
    @DisplayName("convert should return 1 km when given distance is 100000 cm")
    public void convertWhenGivenDistancIsLacCentimeter() {
        Distance distance = new Distance(100000, CENTIMETER);
        Distance distanceInMeter = distance.convert(KILOMETER);

        Distance expectedDistance = new Distance(1, KILOMETER);
        assertEquals(expectedDistance, distanceInMeter);

    }

    @Test
    @DisplayName("convert should return 0.001 m when given distance is 1 km")
    public void convertWhenGivenDistancIsOneKilometer() {
        Distance distance = new Distance(1, KILOMETER);
        Distance distanceInMeter = distance.convert(METER);

        Distance expectedDistance = new Distance(0.001, METER);
        assertEquals(expectedDistance, distanceInMeter);

    }

    @Test
    @DisplayName("convert should return 0.0001 cm when given distance is 10 km")
    public void convertWhenGivenDistancIsTenKilometer() {
        Distance distance = new Distance(10, KILOMETER);
        Distance distanceInMeter = distance.convert(CENTIMETER);

        Distance expectedDistance = new Distance(0.0001, CENTIMETER);
        assertEquals(expectedDistance, distanceInMeter);

    }

}