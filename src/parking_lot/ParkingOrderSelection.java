package parking_lot;

import java.util.List;

public enum ParkingOrderSelection {
    HIGHEST_FREE_SPACE {
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
    }, MOST_AVAILABLE {
        @Override
        ParkingLot selectedParkingLot(List<ParkingLot> parkingLots) {
            return parkingLots.get(0);
        }
    };

    abstract ParkingLot selectedParkingLot(List<ParkingLot> parkingLots);
}
