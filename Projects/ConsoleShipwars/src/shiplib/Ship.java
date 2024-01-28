package shiplib;

import java.util.Objects;

public class Ship {
    private int shipSize;
    private boolean isAlive = true;
    private String headCoordinates;
    private Directions direction;
    private String[] partsCoordinates;
    private boolean[] destroyedParts;
    private int destroyedPartsCNT = 0;

    public Ship(int shipSize, String headCoordinates, Directions direction) {
        this.shipSize = shipSize;
        this.headCoordinates = headCoordinates;
        this.direction = direction;
        this.partsCoordinates = new String[shipSize];
        this.destroyedParts = new boolean[shipSize];

        for (int i = 0; i < this.shipSize; i++) {
            if (direction == Directions.VERTICAL) {
                partsCoordinates[i] = String.valueOf(headCoordinates.charAt(0) + i) + headCoordinates.charAt(1);
            }
            if (direction == Directions.HORIZONTAL) {
                partsCoordinates[i] = headCoordinates.charAt(0) + String.valueOf(headCoordinates.charAt(1) + i);
            }
        }
    }

    public void printCoords() {
        for ()
    }

    public boolean takeDamage(String shotCoordinates) {
        for (int i = 0; i < partsCoordinates.length; i++) {
            if (Objects.equals(partsCoordinates[i], shotCoordinates)) {
                destroyedParts[i] = true;
                destroyedPartsCNT++;
                break;
            }
            if (i == partsCoordinates.length - 1) {
                return false;
            }
        }

        isAlive = false;
        for (boolean part : destroyedParts) {
            if (part == false) {
                isAlive = true;
                break;
            }
        }
        return true;
    }

    final boolean getIsAlive() {
        return isAlive;
    }

    final String[] getDestroyedParts() {
        String[] destroyedPartsCoords = new String[destroyedPartsCNT];
        int counter = 0;
        for (int i = 0; i < partsCoordinates.length; i++) {
            if (destroyedParts[i]) {
                destroyedPartsCoords[counter] = partsCoordinates[i];
            }
        }
        return destroyedPartsCoords;
    }
}
