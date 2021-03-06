package parking_lot.parking_order;

import parking_lot.ParkingLot;

import java.util.List;

public class MostFreeSpace implements ParkingOrderSelection {
    @Override
    public ParkingLot selectedParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot selectedParkingLot = parkingLots.get(0);

        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasMoreFreeSpace(selectedParkingLot)) {
                selectedParkingLot = parkingLot;
            }
        }
        return selectedParkingLot;
    }
}
