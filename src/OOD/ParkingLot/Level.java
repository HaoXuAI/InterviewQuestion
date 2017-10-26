package OOD.ParkingLot;

import java.util.List;

/**
 * Created by hao on 10/26/17.
 */
public class Level {

    private int floor;
    private final int SPOTS_PER_ROW = 10;
    private ParkingSpot[] parkingSpots;
    private int availableSpots = 0;

    public Level(int floor, int numberSpots) {
        this.floor = floor;
        parkingSpots = new ParkingSpot[numberSpots];
        availableSpots = numberSpots;

        for (int i = 0; i < numberSpots / SPOTS_PER_ROW; i++) {
            int j = i * 10;
            VehicleSize sz = VehicleSize.Bus;
            if (i >= 1 && i <= 2) sz = VehicleSize.Car;
            if (i > 2) sz = VehicleSize.Motorcycle;
            parkingSpots[j] = new ParkingSpot(sz, i, j, this);
        }
    }

    public int getAvailableSpots() {
        return availableSpots;
    }

    public boolean parkVehicle(Vehicle v) {
        if (availableSpots < v.getSpotsNeeded()) return false;
        int spotNumber = findAvailableSpot(v);
        if (spotNumber == -1) return false;
        for (int i = spotNumber; i < spotNumber + v.getSpotsNeeded(); i++) {
            parkingSpots[i].park(v);
        }
        availableSpots -= v.getSpotsNeeded();
        return true;
    }

    private int findAvailableSpot(Vehicle v) {
        int spotsNeeded = v.getSpotsNeeded();
        int lastRow = -1;
        int spotsFound = 0;
        for (int i = 0; i < parkingSpots.length; i++) {
            ParkingSpot spot = parkingSpots[i];
            if (lastRow != spot.getRow()) {
                spotsFound = 0;
                lastRow = spot.getRow();
            }
            if (spot.canFitVehicle(v)) {
                spotsFound++;
            } else {
                spotsFound = 0;
            }
            if (spotsFound == spotsNeeded) {
                return  i - (spotsNeeded - 1);
            }
        }
        return -1;
    }

    public void spotFreed() {
        availableSpots++;
    }
}
