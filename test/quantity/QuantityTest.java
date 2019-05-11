package quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static quantity.Unit.*;

class QuantityTest {

    @Test
    public void convert_expectReturnOneMeter_whenHundredCentimetersHaveGiven() throws InvalidUnitConversion {
        Quantity quantity = new Quantity(100, CENTIMETER);
        Quantity quantityInMeter = quantity.convert(METER);

        Quantity expectedQuantity = new Quantity(1, METER);
        assertEquals(expectedQuantity, quantityInMeter);
    }

    @Test
    public void convert_expectReturnOneKiloMeter_whenLacCentimetersHaveGiven() throws InvalidUnitConversion {
        Quantity quantity = new Quantity(100000, CENTIMETER);
        Quantity quantityInMeter = quantity.convert(KILOMETER);

        Quantity expectedQuantity = new Quantity(1, KILOMETER);
        assertEquals(expectedQuantity, quantityInMeter);
    }

    @Test
    public void convert_expectReturnHalfMeter_whenFiftyCentimetersHaveGiven() throws InvalidUnitConversion {
        Quantity quantity = new Quantity(50, CENTIMETER);
        Quantity quantityInKilometer = quantity.convert(METER);

        Quantity expectedQuantity = new Quantity(0.5, METER);
        assertEquals(expectedQuantity, quantityInKilometer);
    }

    @Test
    public void convert_expectThrowAnError_whenGivenUnitIsNotValidForConversionForCentimeter() {
        Quantity quantity = new Quantity(50, CENTIMETER);
        assertThrows(InvalidUnitConversion.class, () -> {
            quantity.convert(GRAM);
        });
    }

    @Test
    public void convert_expectReturnOneKiloMeter_whenThousandMetersHaveGiven() throws InvalidUnitConversion {
        Quantity quantity = new Quantity(1000, METER);
        Quantity quantityInKilometer = quantity.convert(KILOMETER);

        Quantity expectedQuantity = new Quantity(1, KILOMETER);
        assertEquals(expectedQuantity, quantityInKilometer);
    }

    @Test
    public void convert_expectReturnThousandCentimeter_whenTenMetersHaveGiven() throws InvalidUnitConversion {
        Quantity quantity = new Quantity(10, METER);
        Quantity quantityInMeter = quantity.convert(CENTIMETER);

        Quantity expectedQuantity = new Quantity(1000, CENTIMETER);
        assertEquals(expectedQuantity, quantityInMeter);
    }

    @Test
    public void convert_expectReturnHalfKiloMeter_whenFiveHundredMetersHaveGiven() throws InvalidUnitConversion {
        Quantity quantity = new Quantity(500, METER);
        Quantity quantityInMeter = quantity.convert(KILOMETER);

        Quantity expectedQuantity = new Quantity(0.5, KILOMETER);
        assertEquals(expectedQuantity, quantityInMeter);
    }

    @Test
    public void convert_expectThrowAnError_whenGivenUnitIsNotValidForConversionForMeter() {
        Quantity quantity = new Quantity(50, METER);
        assertThrows(InvalidUnitConversion.class, () -> {
            quantity.convert(GRAM);
        });
    }

    @Test
    public void convert_expectReturnOneKiloGram_whenThousandGramsHaveGiven() throws InvalidUnitConversion {
        Quantity quantity = new Quantity(1000, GRAM);
        Quantity quantityInKilogram = quantity.convert(KILOGRAM);

        Quantity expectedQuantity = new Quantity(1, KILOGRAM);

        assertEquals(expectedQuantity, quantityInKilogram);
    }

    @Test
    public void convert_expectReturnFiveHundredGram_whenHalfKilogramsHaveGiven() throws InvalidUnitConversion {
        Quantity quantity = new Quantity(0.5, KILOGRAM);
        Quantity quantityInGram = quantity.convert(GRAM);

        Quantity expectedQuantity = new Quantity(500, GRAM);

        assertEquals(expectedQuantity, quantityInGram);
    }

    @Test
    public void areSameMeasurement_expectReturnFalse_whenGiveQuantitiesAreGramAndCentimeter() throws InvalidUnitConversion {
        Quantity quantityInGram = new Quantity(0.5, GRAM);
        Quantity quantityInCentimeter = new Quantity(0.5, CENTIMETER);

        assertFalse(quantityInCentimeter.areSameMeasurement(quantityInGram));
    }

    @Test
    public void areSameMeasurement_expectReturnTrue_whenHundredCentimetersAreComparingWithOneMeter() throws InvalidUnitConversion {
        Quantity quantityInCentimeter = new Quantity(100, CENTIMETER);
        Quantity quantityInMeter= new Quantity(1, METER);

        assertTrue(quantityInCentimeter.areSameMeasurement(quantityInMeter));
    }


    @Test
    public void add_expectReturnUnitInCentimeter_whenLeftUnitIsCentimeter() throws InvalidUnitConversion {
        Quantity quantity = new Quantity(100, CENTIMETER);
        Quantity quantityInMeter = new Quantity(1, METER);
        Quantity compoundQuantity = quantity.add(quantityInMeter);

        Quantity expectedQuantity = new Quantity(200, CENTIMETER);

        assertEquals(expectedQuantity, compoundQuantity);
    }

    @Test
    public void add_expectReturnUnitInKilometer_whenLeftUnitIsKilometer() throws InvalidUnitConversion {
        Quantity quantity = new Quantity(1,  KILOMETER);
        Quantity quantityInMeter = new Quantity(100, METER);
        Quantity compoundQuantity = quantity.add(quantityInMeter);

        Quantity expectedQuantity = new Quantity(1.1, KILOMETER);

        assertEquals(expectedQuantity, compoundQuantity);
    }

    @Test
    public void subtract_expectReturnUnitInKilometer_whenLeftUnitIsKilometer() throws InvalidUnitConversion {
        Quantity quantity = new Quantity(1,  KILOMETER);
        Quantity quantityInMeter = new Quantity(100, METER);
        Quantity compoundQuantity = quantity.subtract(quantityInMeter);

        Quantity expectedQuantity = new Quantity(0.9, KILOMETER);

        assertEquals(expectedQuantity, compoundQuantity);
    }

}