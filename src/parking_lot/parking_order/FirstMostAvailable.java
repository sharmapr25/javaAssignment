package parking_lot.parking_order;

import parking_lot.ParkingLot;

import java.util.List;

public class FirstMostAvailable implements ParkingOrderSelection {
    @Override
    public ParkingLot selectedParkingLot(List<ParkingLot> parkingLots) {
        return parkingLots.get(0);
    }
}
