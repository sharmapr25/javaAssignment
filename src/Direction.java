public enum Direction {
    NORTH {
        @Override
        public Point changeCoordinates(Point point) {
            return point.incrementY();
        }

        @Override
        public Direction left() {
            return WEST;
        }

        @Override
        public Direction right() {
            return EAST;
        }
    }, EAST {
        @Override
        public Point changeCoordinates(Point point) {
            return point.incrementX();
        }

        @Override
        public Direction left() {
            return NORTH;
        }

        @Override
        public Direction right() {
            return SOUTH;
        }
    }, WEST {
        @Override
        public Point changeCoordinates(Point point) {
            return point.decrementX();
        }

        @Override
        public Direction left() {
            return SOUTH;
        }

        @Override
        public Direction right() {
            return NORTH;
        }
    }, SOUTH {
        @Override
        public Point changeCoordinates(Point point) {
            return point.decrementY();
        }

        @Override
        public Direction left() {
            return EAST;
        }

        @Override
        public Direction right() {
            return WEST;
        }
    };

    public abstract Point changeCoordinates(Point point);

    public abstract Direction left();
    public abstract Direction right();
}
