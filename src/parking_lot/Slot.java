package parking_lot;

public class Slot {
    private Car car;

    public Slot(Car car) {
        this.car = car;
    }

    public boolean hasCar(Car car) {
        return this.car.equals(car);
    }
}
