package quantity;

import static quantity.Constant.HUNDRED;
import static quantity.Constant.THOUSAND;
import static quantity.Unit.KILOMETER;
import static quantity.Unit.METER;

public class Quantity {


    private final Double value;
    private final Unit unit;

    public Quantity(Double value, Unit unit) {

        this.value = value;
        this.unit = unit;
    }

    public Quantity convertCentimeterToMeter() {
        return new Quantity(value/HUNDRED, METER);
    }

    public Quantity convertMeterToKiloMeter() {
        return new Quantity(value/THOUSAND, KILOMETER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quantity quantity = (Quantity) o;

        if (value != null ? !value.equals(quantity.value) : quantity.value != null) return false;
        return unit == quantity.unit;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }

    public Quantity convertCentimeterToKiloMeter() {
        return convertCentimeterToMeter().convertMeterToKiloMeter();
    }
}
