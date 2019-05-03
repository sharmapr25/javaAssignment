public enum Direction {
    NORTH {
        @Override
        public Point changeCoordinates(Point point) {
            return point.incrementY();
        }
    }, EAST {
        @Override
        public Point changeCoordinates(Point point) {
            return point.incrementX();
        }
    }, WEST {
        @Override
        public Point changeCoordinates(Point point) {
            return point.decrementX();
        }
    }, SOUTH {
        @Override
        public Point changeCoordinates(Point point) {
            return point.decrementY();
        }
    };

    public abstract Point changeCoordinates(Point point);
}
