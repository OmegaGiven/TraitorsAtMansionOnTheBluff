package Spook;
import GameBoard.Tile;
public class Spook {

    protected boolean Spook = false;
    protected Tile lastTile;
    // protected Card.Omen lastOmen;
    protected Character traitor;

    protected String traitorDescription;
    protected String survivorDescription;

    public Spook() {

    }

    public Character getTraitor(){
        return this.traitor;
    }

    public String getTraitorDescription() {
        return this.traitorDescription;
    }

    public String getSurvivorDescription() {
        return this.survivorDescription;
    }

//    public int calculateHorror() {
//        int count = 0;
//        for (int i = 0; i <= 6; i++) {
//            count += Math.nextInt(2)
//        }
//        if (count == 6)
//    }
}