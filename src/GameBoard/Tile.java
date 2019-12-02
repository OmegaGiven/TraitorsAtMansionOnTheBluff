package GameBoard;
import javafx.scene.image.ImageView;
import Card.*;


public class Tile {

    private ImageView image;
    private boolean special;
     boolean nDr;
     boolean sDr;
     boolean wDr;
     boolean eDr;
     private Card card;


    Tile() {
        image = new ImageView();
        special = false;
        nDr = false;
        sDr = false;
        wDr = false;
        eDr = false;
        card = generateCard();
    }

    Tile(ImageView image, boolean special) {
        this.special = special;
        this.image = image;
        this.nDr = true;
        this.sDr = true;
        this.wDr = true;
        this.eDr = true;
        card = generateCard();
    }

    Tile(ImageView image, boolean special, boolean n, boolean s, boolean w, boolean e) {
        this.special = special;
        this.image = image;
        this.nDr = n;
        this.sDr = s;
        this.wDr = w;
        this.eDr = e;
        card = generateCard();
    }

    public ImageView image() {
        return this.image;
    }

    public boolean isSpecial() {
        return this.special;
    }

    private static Card generateCard(){
        int which = (int)(Math.random() * ((3 - 1) + 1)) + 1;
        if(which == 1){
            return new EventCard();
        }
        else if (which == 2){
            return new ItemCard();
        }
        else return new Omen();
    }
//    public static void main(String[] args){
//        for(int i = 0; i < 10; i++){
//            System.out.println(generateCard());
//        }
//    }
}
