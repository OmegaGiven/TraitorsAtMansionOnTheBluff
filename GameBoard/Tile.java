import javafx.scene.image.ImageView;

public class Tile {

    private ImageView image;
    private boolean special;


    Tile() {
        image = new ImageView();
        special = false;
    }

    Tile(ImageView image, boolean special) {
        this.special = special;
        this.image = image;
    }

    public ImageView image() {
        return this.image;
    }

    public boolean isSpecial() {
        return this.special;
    }


}
