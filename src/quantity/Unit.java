package quantity;

import static quantity.QuantityType.DISTANCE;
import static quantity.QuantityType.TEMPERATURE;
import static quantity.QuantityType.WEIGHT;

/*
Represent units for distance, weight and temperature
 */
public enum Unit {
    CENTIMETER(1, DISTANCE),
    METER(100, DISTANCE),
    KILOMETER(100000, DISTANCE),
    GRAM(1, WEIGHT),
    KILOGRAM(1000, WEIGHT),
    CELSIUS(9, TEMPERATURE, 0),
    FAHRENHEIT(5, TEMPERATURE, 32);

    private final double factor;
    private final QuantityType type;
    private double intercept;

    Unit(double factor, QuantityType type) {
        this.factor = factor;
        this.type = type;
    }

    Unit(double factor, QuantityType type, double intercept) {
        this.factor = factor;
        this.type = type;
        this.intercept = intercept;
    }

    public double convertTo(double measurement, Unit toUnit) throws InvalidUnitConversion {
        if(!this.type.equals(toUnit.type)){
           throw new InvalidUnitConversion();
        }
        double baseValue = measurement - this.intercept;
        double factorDivision = this.factor / toUnit.factor;
        return baseValue * factorDivision + toUnit.intercept;
    }
}
