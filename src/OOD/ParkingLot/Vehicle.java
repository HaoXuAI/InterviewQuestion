package OOD.ParkingLot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hao on 10/26/17.
 */
public abstract class Vehicle {

    private int SpotsNeeded;

    private VehicleSize size;

    private String type;

    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    public int getSpotsNeeded() {
        return SpotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void parkInSpot(ParkingSpot s) {
        parkingSpots.add(s);
    }

    public void clearSpots() {}

    public abstract boolean canFitInSpot(ParkingSpot s);
}
