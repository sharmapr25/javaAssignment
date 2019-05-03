public enum Direction {
    NORTH {
        @Override
        public void changeCoordinates(Point point) {
            point.incrementY();
        }
    }, EAST {
        @Override
        public void changeCoordinates(Point point) {
            point.incrementX();
        }
    }, WEST {
        @Override
        public void changeCoordinates(Point point) {
            point.decrementX();
        }
    }, SOUTH {
        @Override
        public void changeCoordinates(Point point) {
            point.decrementY();
        }
    };

    public abstract void changeCoordinates(Point point);
}
