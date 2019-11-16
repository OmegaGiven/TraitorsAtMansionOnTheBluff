import javafx.scene.image.ImageView;

/**
 * Real version: Father Rhinehardt
 */

public class PapaKooky extends Character {

    public PapaKooky(){

        super.image = new ImageView("https://i.imgur.com/Vu005Wm.png");
        image.setFitWidth(50);
        image.setFitHeight(50);
        move = moveCount;

        this.name = "Papa Kooky";
        this.bio = "A man who turned to religion to escape persecution, " +
                "Daddy Rhinestone is haunted by the mad whispers of the confessional booth.";
        this.picUrl = "...";

        this.x = 2;
        this.y = 5;

        this.moveCount = 4;

        this.speed = 0; // index speed is at
        this.speedIncr = new int[]{7, 7, 6, 5, 4, 3, 3, 2, 0};
        this.might = 0;
        this.mightIncr = new int[]{7, 5, 5, 4, 4, 3, 3, 1};
        this.sanity = 0;
        this.sanityIncr = new int[]{8, 7, 7, 6, 5, 5, 4, 3, 0};
        this.knowledge = 0;
        this.knowledgeIncr = new int[]{8, 6, 6, 5, 4, 3, 3, 1, 0};

        this.traitor = false;
    }
}
