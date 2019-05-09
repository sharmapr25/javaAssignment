package quantity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static quantity.Unit.*;

class QuantityTest {

    @Test
    @DisplayName("convert hundred centimeters to one meter")
    public void testConvertHundredCentimetersToOneMeter() {
        Quantity quantity = new Quantity((double) 100, CENTIMETER);
        Quantity quantityInMeter = quantity.convertCentimeterToMeter();

        Quantity expectedQuantity = new Quantity((double) 1, METER);
        assertEquals(expectedQuantity, quantityInMeter);
    }

    @Test
    @DisplayName("convert thousand centimeters to ten meters")
    public void testConvertThousandCentimetersToTenMeters() {
        Quantity quantity = new Quantity((double) 1000, CENTIMETER);
        Quantity quantityInMeters = quantity.convertCentimeterToMeter();

        Quantity expectedQuantity = new Quantity((double) 10, METER);
        assertEquals(expectedQuantity, quantityInMeters);
    }

    @Test
    @DisplayName("convert thousand meters to one kilometer")
    public void testConvertThousandMetersToOneKilometer() {
        Quantity quantity = new Quantity((double) 1000, METER);
        Quantity quantityInKiloMeter = quantity.convertMeterToKiloMeter();

        Quantity expectedQuantity = new Quantity((double) 1, KILOMETER);
        assertEquals(expectedQuantity, quantityInKiloMeter);
    }

    @Test
    @DisplayName("convert hundred meters to 0.1 kilometer")
    public void testConvertHundredMetersToHalfKilometer() {
        Quantity quantity = new Quantity((double) 100, METER);
        Quantity quantityInKiloMeter = quantity.convertMeterToKiloMeter();

        Quantity expectedQuantity = new Quantity(0.1, KILOMETER);
        assertEquals(expectedQuantity, quantityInKiloMeter);
    }

    @Test
    @DisplayName("convert one lakh centimeters to 1 kilometer")
    public void testConvertOneLakhCentimetersToOneKilometer() {
        Quantity quantity = new Quantity((double) 100000, CENTIMETER);
        Quantity quantityInKiloMeter = quantity.convertCentimeterToKiloMeter();

        Quantity expectedQuantity = new Quantity((double) 1, KILOMETER);
        assertEquals(expectedQuantity, quantityInKiloMeter);
    }

    @Test
    @DisplayName("convert hundred grams to 1 kilogram")
    public void testConvertHundredGramsToOneKilogram() {
        Quantity quantity = new Quantity((double) 1000, GRAM);
        Quantity quantityInKiloGram = quantity.convertGramToKiloGram();

        Quantity expectedQuantity = new Quantity((double) 1, KILOGRAM);
        assertEquals(expectedQuantity, quantityInKiloGram);
    }

}