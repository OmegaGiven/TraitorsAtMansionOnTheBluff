import javafx.scene.image.ImageView;

/**
 * Real version: Vivian Lopez
 */

public class TheArsonGal extends Character {

    public TheArsonGal(){

        super.image = new ImageView("https://i.imgur.com/xB0U8hs.png");
        image.setFitWidth(50);
        image.setFitHeight(50);
        move = moveCount;

        this.name = "The Arson Gal";
        this.bio = "A small bookshop owner who, when finances become " +
                "difficult, has thoughts of arson.";
        this.picUrl = "...";

        this.x = 2;
        this.y = 5;

        this.moveCount = 4;

        this.speed = 0; // index speed is at
        this.speedIncr = new int[]{8, 7, 6, 4, 4, 4, 4, 3, 0};
        this.might = 0;
        this.mightIncr = new int[]{6, 6, 5, 4, 4, 2, 2, 2, 0};
        this.sanity = 0;
        this.sanityIncr = new int[]{8, 8, 7, 6, 5, 4, 4, 4, 0};
        this.knowledge = 0;
        this.knowledgeIncr = new int[]{7, 6, 6, 5, 5, 5, 5, 4, 0};

        this.traitor = false;
    }
}
