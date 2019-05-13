package quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static quantity.Unit.*;

class QuantityTest {

    @Test
    public void areSameMeasurement_expectReturnTrue_whenHundredCentimetersIsComparingWithOneMeter() throws InvalidUnitConversion {
        Quantity quantityInCentimeter = new Quantity(100, CENTIMETER);
        Quantity quantityInMeter = new Quantity(1, METER);

        assertTrue(quantityInCentimeter.areSameMeasurement(quantityInMeter));
    }

    @Test
    public void areSameMeasurement_expectReturnHalfMeter_whenFiftyCentimetersHaveGiven() throws InvalidUnitConversion {
        Quantity quantityInCentimeter = new Quantity(50, CENTIMETER);
        Quantity quantityInMeter = new Quantity(0.5, METER);

        assertTrue(quantityInCentimeter.areSameMeasurement(quantityInMeter));

    }

    @Test
    public void areSameMeasurement_expectReturnFalse_whenFiftyCentimeterIsComparingWithOneMeter() throws InvalidUnitConversion {
        Quantity quantityInMeter = new Quantity(50, CENTIMETER);
        Quantity quantityInCentimeter = new Quantity(1, METER);

        assertFalse(quantityInCentimeter.areSameMeasurement(quantityInMeter));
    }

    @Test
    public void areSameMeasurement_expectReturnTrue_whenLacCentimetersIsComparingWithOneKiloMeter() throws InvalidUnitConversion {
        Quantity quantity = new Quantity(100000, CENTIMETER);
        Quantity quantityInKilometer = new Quantity(1, KILOMETER);

        assertTrue(quantity.areSameMeasurement(quantityInKilometer));
    }

    @Test
    public void areSameMeasurement_expectReturnFalse_whenGiveQuantitiesAreGramAndCentimeter() throws InvalidUnitConversion {
        Quantity quantityInGram = new Quantity(0.5, GRAM);
        Quantity quantityInCentimeter = new Quantity(0.5, CENTIMETER);

        assertFalse(quantityInCentimeter.areSameMeasurement(quantityInGram));
    }

    @Test
    public void areSameMeasurement_expectReturnTrue_whenThousandMeterIsComparingWithOneKiloMeter() throws InvalidUnitConversion {
        Quantity quantityInMeter = new Quantity(1000, METER);
        Quantity quantityInKilometer = new Quantity(1, KILOMETER);

        assertTrue(quantityInMeter.areSameMeasurement(quantityInKilometer));
    }

    @Test
    public void areSameMeasurement_expectReturnTrue_whenTenMeterAreComparingWithThousandCentimeter() throws InvalidUnitConversion {
        Quantity quantityInCentimeter = new Quantity(10, METER);
        Quantity quantityInMeter = new Quantity(1000, CENTIMETER);

        assertTrue(quantityInMeter.areSameMeasurement(quantityInCentimeter));
    }

    @Test
    public void areSameMeasurement_expectReturnFalse_whenHalfMeterAreComparingWithHundredCentimeter() throws InvalidUnitConversion {
        Quantity quantityInCentimeter = new Quantity(0.5, METER);
        Quantity quantityInMeter = new Quantity(100, CENTIMETER);

        assertFalse(quantityInMeter.areSameMeasurement(quantityInCentimeter));
    }

    @Test
    public void areSameMeasurement_expectReturnTrue_whenFiveHundredMetersIsComparingWithHalfKiloMeter() throws InvalidUnitConversion {
        Quantity meter = new Quantity(500, METER);
        Quantity kilometer = new Quantity(0.5, KILOMETER);

        assertTrue(meter.areSameMeasurement(kilometer));
    }

    @Test
    public void areSameMeasurement_expectReturnFalse_whenMeterIsComparingWithGram() {
        Quantity meter = new Quantity(50, METER);
        Quantity gram = new Quantity(50, GRAM);

        assertFalse(meter.areSameMeasurement(gram));
    }

    @Test
    public void areSameMeasurement_expectReturnTrue_whenOneKilometerIsComparingWithThousandMeter() throws InvalidUnitConversion {
        Quantity kilometer = new Quantity(1, KILOMETER);
        Quantity meter = new Quantity(1000, METER);

        assertTrue(kilometer.areSameMeasurement(meter));
    }

    @Test
    public void areSameMeasurement_expectReturnTrue_whenHalfKilometerIsComparingWithFiftyThousandCentimeter() throws InvalidUnitConversion {
        Quantity kilometer = new Quantity(0.5, KILOMETER);
        Quantity centimeter = new Quantity(50000, CENTIMETER);

        assertTrue(kilometer.areSameMeasurement(centimeter));
    }

    @Test
    public void areSameMeasurement_expectReturnTrue_whenThousandGramsIsComparingWithOneKiloGram() throws InvalidUnitConversion {
        Quantity gram = new Quantity(1000, GRAM);
        Quantity kilogram = new Quantity(1, KILOGRAM);

        assertTrue(gram.areSameMeasurement(kilogram));
    }

    @Test
    public void areSameMeasurement_expectReturn_whenHalfKilogramsIsComparingWithFiveHundredGram() throws InvalidUnitConversion {
        Quantity kilogram = new Quantity(0.5, KILOGRAM);
        Quantity gram = new Quantity(500, GRAM);

        assertTrue(kilogram.areSameMeasurement(gram));
    }

    @Test
    public void areSameMeasurement_expectReturn_whenHalfKilogramsIsComparingWithThousandGram() throws InvalidUnitConversion {
        Quantity kilogram = new Quantity(0.5, KILOGRAM);
        Quantity gram = new Quantity(1000, GRAM);

        assertFalse(kilogram.areSameMeasurement(gram));
    }

    @Test
    public void areSameMeasurement_expectReturnFalse_whenGivenQuantitiesAreCelsiusAndCentimeter() throws InvalidUnitConversion {
        Quantity quantityInCentimeter = new Quantity(32, CENTIMETER);
        Quantity quantityInCelsius = new Quantity(0, CELSIUS);

        assertFalse(quantityInCelsius.areSameMeasurement(quantityInCentimeter));
    }

    @Test
    public void areSameMeasurement_expectReturnTrue_whenHundredCelsiusIsComparingWithTwoHundredTwelveFahrenheit() throws InvalidUnitConversion {
        Quantity quantityInFahrenheit = new Quantity(212, FAHRENHEIT);
        Quantity quantityInCelsius = new Quantity(100, CELSIUS);

        assertTrue(quantityInCelsius.areSameMeasurement(quantityInFahrenheit));
    }

    @Test
    public void add_expectReturnTrue_whenAddedHundredCentimeterWithOneMeterAndComparingWIthTwoHundredCentimeter() throws InvalidUnitConversion {
        Quantity hundredCentimeter = new Quantity(100, CENTIMETER);
        Quantity meter = new Quantity(1, METER);

        Quantity compoundQuantity = hundredCentimeter.add(meter);
        Quantity twoHundredCentimeter = new Quantity(200, CENTIMETER);

        assertEquals(twoHundredCentimeter, compoundQuantity);
    }

    @Test
    public void add_expectReturnUnitInKilometer_whenLeftUnitIsKilometer() throws InvalidUnitConversion {
        Quantity quantity = new Quantity(1, KILOMETER);
        Quantity quantityInMeter = new Quantity(100, METER);
        Quantity compoundQuantity = quantity.add(quantityInMeter);

        Quantity expectedQuantity = new Quantity(1.1, KILOMETER);

        assertEquals(expectedQuantity, compoundQuantity);
    }

    @Test
    public void subtract_expectReturnUnitInKilometer_whenLeftUnitIsKilometer() throws InvalidUnitConversion {
        Quantity quantity = new Quantity(1, KILOMETER);
        Quantity quantityInMeter = new Quantity(100, METER);
        Quantity compoundQuantity = quantity.subtract(quantityInMeter);

        Quantity expectedQuantity = new Quantity(0.9, KILOMETER);

        assertEquals(expectedQuantity, compoundQuantity);
    }

    @Test
    public void areSameMeasurement_expectReturnTrue_whenZeroDegreeCelsiusIsComparingWithThirtyTwoDegreeFahrenheit() throws InvalidUnitConversion {
        Quantity celsius = new Quantity(0, CELSIUS);
        Quantity fahrenheit = new Quantity(32, FAHRENHEIT);

        assertTrue(celsius.areSameMeasurement(fahrenheit));
    }

    @Test
    public void areSameMeasurement_expectReturnTrue_whenFiveDegreeCelsiusIsComparingWithFortyOneDegreeFahrenheit() throws InvalidUnitConversion {
        Quantity celsius = new Quantity(5, CELSIUS);
        Quantity fahrenheit = new Quantity(41, FAHRENHEIT);

        assertTrue(celsius.areSameMeasurement(fahrenheit));
    }

    @Test
    public void areSameMeasurement_expectReturnTrue_whenThirtyTwoDegreeFahrenheitIsComparingWithZeroDegreeCelsius() throws InvalidUnitConversion {
        Quantity fahrenheit = new Quantity(32, FAHRENHEIT);

        Quantity celsius = new Quantity(0, CELSIUS);

        assertTrue(fahrenheit.areSameMeasurement(celsius));
    }

    @Test
    public void areSameMeasurement_expectReturnFalse_whenFortyOneDegreeFahrenheitIsComparingWithTwoDegreeCelsius() throws InvalidUnitConversion {
        Quantity fahrenheit = new Quantity(41, FAHRENHEIT);
        Quantity celsius = new Quantity(2, CELSIUS);

        assertFalse(fahrenheit.areSameMeasurement(celsius));
    }

}