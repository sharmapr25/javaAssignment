package probability;

import static java.lang.Double.compare;

public class Probability {
    private double ratio;

    public Probability(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Probability that = (Probability) o;

        return compare(that.ratio, ratio) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(ratio);
        return (int) (temp ^ (temp >>> 32));
    }

    public int compareWith(Probability probability) {
        return compare(this.ratio, probability.ratio);
    }
}
