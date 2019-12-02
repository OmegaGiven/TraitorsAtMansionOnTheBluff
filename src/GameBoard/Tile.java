package GameBoard;
import javafx.scene.image.ImageView;
import Card.Card;


public class Tile {

    private ImageView image;
    private boolean special;
     boolean nDr;
     boolean sDr;
     boolean wDr;
     boolean eDr;
     private Card[] cards;


    Tile() {
        image = new ImageView();
        special = false;
        nDr = false;
        sDr = false;
        wDr = false;
        eDr = false;
        cards = new Card[3];
    }

    Tile(ImageView image, boolean special) {
        this.special = special;
        this.image = image;
        this.nDr = true;
        this.sDr = true;
        this.wDr = true;
        this.eDr = true;
    }

    Tile(ImageView image, boolean special, boolean n, boolean s, boolean w, boolean e) {
        this.special = special;
        this.image = image;
        this.nDr = n;
        this.sDr = s;
        this.wDr = w;
        this.eDr = e;
    }

    public ImageView image() {
        return this.image;
    }

    public boolean isSpecial() {
        return this.special;
    }


}
