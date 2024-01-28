package playerlib;

import shiplib.Ship;

public class APlayer {
    private Ship[] ships = new Ship[10];

    void setShips(Ship[] ships) {
        this.ships = ships;
    }

    boolean takeShot(String shotCoordinates) {
        for (Ship ship : ships) {
            if (ship.takeDamage(shotCoordinates)) {
                return true;
            }
        }
        return false;
    }
}
