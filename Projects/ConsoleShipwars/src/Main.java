import shiplib.Directions;
import shiplib.Ship;

public class Main {

    /*

    Ship wars

    contains:
    1. ships
    2. two field
    3. players PC and NPC

    Ships should be able to:
        1. take damage
        2. get destroyed

    Field should be able to:
        1. load with ships
        2. update where the shot was taken

    Player should be able to:
        1. set the ships
        2. fire | choose square to shoot

        NPC shoots at a random spot then if it shot then if the ship is destroyed it does the first step,
        if not it attempts to shoot the whole ship trying to find its direction.

     */






    public static void main(String[] args) {

        Ship ship = new Ship(3, "c3", Directions.VERTICAL);
        if (ship.takeDamage("c4")) {
            System.out.println("Damage taken c4");
        }

        if (ship.takeDamage("d3")) {
            System.out.println("Damage taken d3");
        }
    }
}