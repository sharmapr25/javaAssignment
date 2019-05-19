package parking_lot.parking_order;

import parking_lot.ParkingLot;

import java.util.List;

public interface ParkingOrderSelection {
    public ParkingLot selectedParkingLot(List<ParkingLot> parkingLots);
}
