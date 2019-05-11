package quantity;

public class Distance {
    private final double measurement;
    private final DistanceUnit unit;

    public Distance(double measurement, DistanceUnit unit) {

        this.measurement = measurement;
        this.unit = unit;
    }

    public Distance convert(DistanceUnit toUnit) {
        double newMeasurement = measurement * getUnitDifference(toUnit);
        return new Distance(newMeasurement, toUnit);
    }

    private double getUnitDifference(DistanceUnit toUnit) {
        if (unit.isValueLessThan(toUnit)) {
            return unit.getValue() / toUnit.getValue();
        }
        return toUnit.getValue() / unit.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Distance distance = (Distance) o;

        if (Double.compare(distance.measurement, measurement) != 0) return false;
        return unit == distance.unit;
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