package OOD.ParkingLot;

/**
 * Created by hao on 10/26/17.
 */
public class ParkingSpot {
    private VehicleSize size;
    private Vehicle vehicle;
    private int row;
    private int spotNum;
    private Level level;

    public ParkingSpot(VehicleSize size, int row, int spotNum, Level level) {
        this.size = size;
        this.row = row;
        this.spotNum = spotNum;
        this.level = level;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle v) {
        return isAvailable() && v.canFitInSpot(this);
    }

    public boolean park(Vehicle v) {
        if (!canFitVehicle(v)) return false;
        vehicle = v;
        v.parkInSpot(this);
        return true;
    }

    public VehicleSize getSize() {
        return size;
    }

    public int getRow() {
        return row;
    }

    public int getSpotNum() {
        return spotNum;
    }

    public Level getLevel() {
        return level;
    }


}
