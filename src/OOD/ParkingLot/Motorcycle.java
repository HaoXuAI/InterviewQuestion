package OOD.ParkingLot;

/**
 * Created by hao on 10/26/17.
 */
public class Motorcycle extends Vehicle{
    private final int spotsNeeded = 1;
    private final VehicleSize size = VehicleSize.Motorcycle;

    public Motorcycle() {
    }


    @Override
    public boolean canFitInSpot(ParkingSpot s) {
        return false;
    }
}
