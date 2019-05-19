package parking_lot;

public class Car {
    private String plateNumber;

    public Car(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return plateNumber != null ? plateNumber.equals(car.plateNumber) : car.plateNumber == null;
    }

    @Override
    public int hashCode() {
        return plateNumber != null ? plateNumber.hashCode() : 0;
    }
}
