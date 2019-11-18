import javafx.scene.image.ImageView;

public class Tile {

    private ImageView image;
    private boolean special;
    private boolean nDr;
    private boolean sDr;
    private boolean wDr;
    private boolean eDr;


    Tile() {
        image = new ImageView();
        special = false;
        nDr = false;
        sDr = false;
        wDr = false;
        eDr = false;
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
