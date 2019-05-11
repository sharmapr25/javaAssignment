package quantity;

public enum Unit {
    CENTIMETER {
        @Override
        public double getDifference(Unit toUnit) throws InvalidUnitConversion {
            if(toUnit.equals(METER)){
                return 0.01;
            }
            if(toUnit.equals(KILOMETER)){
                return 0.00001;
            }
            throw new InvalidUnitConversion();
        }
    }, METER {
        @Override
        public double getDifference(Unit toUnit) throws InvalidUnitConversion {
            if(toUnit.equals(CENTIMETER)){
                return 100;
            }
            if(toUnit.equals(KILOMETER)){
                return 0.001;
            }
            throw new InvalidUnitConversion();
        }
    }, KILOMETER {
        @Override
        public double getDifference(Unit toUnit) {
            return 0;
        }
    },
    GRAM {
        @Override
        public double getDifference(Unit toUnit) throws InvalidUnitConversion {
            if(toUnit.equals(KILOGRAM)){
                return 0.001;
            }
            throw new InvalidUnitConversion();
        }
    },
    KILOGRAM{
        @Override
        public double getDifference(Unit toUnit) throws InvalidUnitConversion {
            if(toUnit.equals(GRAM)){
                return 1000;
            }
            throw new InvalidUnitConversion();
        }
    };

    public abstract double getDifference(Unit toUnit) throws InvalidUnitConversion;
}
