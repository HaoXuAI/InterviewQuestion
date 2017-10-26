package OOD.ParkingLot;

/**
 * Created by hao on 10/26/17.
 */
public class Car extends Vehicle {

    private final VehicleSize size = VehicleSize.Car;
    private final int spotsNeeded = 1;

    public Car() {
    }

    @Override
    public boolean canFitInSpot(ParkingSpot s) {
        return false;
    }
}
