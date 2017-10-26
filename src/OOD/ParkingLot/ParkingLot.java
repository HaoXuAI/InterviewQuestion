package OOD.ParkingLot;

/**
 * Created by hao on 10/26/17.
 */
public class ParkingLot {
    private  int levelNum;
    private Level[] levels;
    private final int NUM_SPOTS_PER_LEVEL = 30;

    public ParkingLot(int levelNum) {
        this.levelNum = levelNum;
        levels = new Level[levelNum];
        for (int i = 0; i < levelNum; i++) {
            levels[i] = new Level(i, NUM_SPOTS_PER_LEVEL);
        }
    }

    public boolean parkVehicle(Vehicle v) {
        for (int i = 0; i < levels.length; i++) {
            if (levels[i].parkVehicle(v)) {
                return true;
            }
        }
        return false;
    }
    
}
