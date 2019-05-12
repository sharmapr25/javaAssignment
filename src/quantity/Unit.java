package quantity;

public enum Unit {
    CENTIMETER {
        @Override
        public double convertTo(double measurement, Unit toUnit) throws InvalidUnitConversion {
            if (toUnit.equals(METER)) {
                return measurement * 0.01;
            }
            if (toUnit.equals(KILOMETER)) {
                return measurement * 0.00001;
            }
            throw new InvalidUnitConversion();
        }
    }, METER {
        @Override
        public double convertTo(double measurement, Unit toUnit) throws InvalidUnitConversion {
            if (toUnit.equals(CENTIMETER)) {
                return measurement * 100;
            }
            if (toUnit.equals(KILOMETER)) {
                return measurement * 0.001;
            }
            throw new InvalidUnitConversion();
        }
    }, KILOMETER {
        @Override
        public double convertTo(double measurement, Unit toUnit) throws InvalidUnitConversion {
            if (toUnit.equals(CENTIMETER)) {
                return measurement * 100000;
            }
            if (toUnit.equals(METER)) {
                return measurement * 1000;
            }
            throw new InvalidUnitConversion();
        }
    },
    GRAM {
        @Override
        public double convertTo(double measurement, Unit toUnit) throws InvalidUnitConversion {
            if (toUnit.equals(KILOGRAM)) {
                return measurement * 0.001;
            }
            throw new InvalidUnitConversion();
        }
    },
    KILOGRAM {
        @Override
        public double convertTo(double measurement, Unit toUnit) throws InvalidUnitConversion {
            if (toUnit.equals(GRAM)) {
                return measurement * 1000;
            }
            throw new InvalidUnitConversion();
        }
    },
    CELSIUS {
        @Override
        public double convertTo(double measurement, Unit toUnit) throws InvalidUnitConversion {
            if (toUnit.equals(FAHRENHEIT)) {
                return ((measurement * 9) / 5) + 32;
            }
            throw new InvalidUnitConversion();

        }
    }, FAHRENHEIT {
        @Override
        public double convertTo(double measurement, Unit toUnit) throws InvalidUnitConversion {
            if (toUnit.equals(CELSIUS)) {
                return (measurement - 32) * 5 / 9;
            }
            throw new InvalidUnitConversion();

        }
    };

    public abstract double convertTo(double measurement, Unit toUnit) throws InvalidUnitConversion;
}
