package parking_lot;

import java.util.List;

public enum ParkingOrderSelection {
    MOST_FREE_SPACE {
        @Override
        ParkingLot selectedParkingLot(List<ParkingLot> parkingLots) {
            ParkingLot selectedParkingLot = parkingLots.get(0);

            for(ParkingLot parkingLot: parkingLots){
                if(parkingLot.hasMoreFreeSpace(selectedParkingLot)){
                    selectedParkingLot = parkingLot;
                }
            }
            return selectedParkingLot;
        }
    }, FIRST_MOST_AVAILABLE {
        @Override
        ParkingLot selectedParkingLot(List<ParkingLot> parkingLots) {
            return parkingLots.get(0);
        }
    }, MOST_CAPACITY {
        @Override
        ParkingLot selectedParkingLot(List<ParkingLot> parkingLots) {
            ParkingLot selectedParkingLot = parkingLots.get(0);

            for(ParkingLot parkingLot: parkingLots){
                if(parkingLot.hasMoreCapacity(selectedParkingLot)){
                    selectedParkingLot = parkingLot;
                }
            }
            return selectedParkingLot;
        }
    };

    abstract ParkingLot selectedParkingLot(List<ParkingLot> parkingLots);
}
