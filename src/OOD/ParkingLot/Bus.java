package OOD.ParkingLot;

/**
 * Created by hao on 10/26/17.
 */
public class Bus extends Vehicle {
    private final int spotsNeeded = 4;
    private final VehicleSize size = VehicleSize.Bus;

    public Bus() {
    }


    @Override
    public boolean canFitInSpot(ParkingSpot s) {
        return false;
    }
}
