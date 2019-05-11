package quantity;

public enum DistanceUnit {
    CENTIMETER(100000), METER(1000), KILOMETER(1);

    public boolean isValueLessThan(DistanceUnit distanceUnit) {
        return this.getValue() < distanceUnit.getValue();
    }

    private double value;

    DistanceUnit(double measurement) {
        this.value = measurement;
    }


    public double getValue() {
        return value;
    }
}
