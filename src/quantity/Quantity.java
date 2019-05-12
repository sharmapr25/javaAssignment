package quantity;

public class Quantity {
    private final double measurement;
    private final Unit unit;

    public Quantity(double measurement, Unit unit) {
        this.measurement = measurement;
        this.unit = unit;
    }

    public Quantity convert(Unit toUnit) throws InvalidUnitConversion {
        return new Quantity(unit.convertTo(measurement, toUnit), toUnit);
    }

    public Quantity add(Quantity quantityToAdd) throws InvalidUnitConversion {
        Quantity convertedQuantity = quantityToAdd.convert(this.unit);
        return new Quantity(measurement + convertedQuantity.measurement, unit);
    }

    public Quantity subtract(Quantity quantityToSubtract) throws InvalidUnitConversion {
        Quantity convertedQuantity = quantityToSubtract.convert(this.unit);
        return new Quantity(measurement - convertedQuantity.measurement, unit);
    }

    public boolean areSameMeasurement(Quantity quantityToCheck) {
        try {
            Quantity convertedQuantity = quantityToCheck.convert(this.unit);
            return this.equals(convertedQuantity);
        } catch (InvalidUnitConversion invalidUnitConversion) {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quantity quantity = (Quantity) o;

        if (Double.compare(quantity.measurement, measurement) != 0) return false;
        return unit == quantity.unit;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(measurement);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}
