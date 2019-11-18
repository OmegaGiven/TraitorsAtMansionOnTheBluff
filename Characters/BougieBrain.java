import javafx.scene.image.ImageView;

/**
 * Real version: Heather Granville
 */


public class BougieBrain extends Character {

    public BougieBrain(){

        super.image = new ImageView("https://i.imgur.com/CRKiRqz.png");
        image.setFitWidth(50);
        image.setFitHeight(50);
        move = moveCount;

        this.name = "Bougie Brain";
        this.bio = "Seen as perfect in both her eyes and the eyes of others, " +
                "Bougie Brain feels like something's trying to claw its way out of her " +
                "when things aren't perfect. She keeps smiling anyway.";
        this.picUrl = "...";

        this.x = 2;
        this.y = 5;

        this.moveCount = 4;

        this.speed = 5; // index speed is at
        this.speedIncr = new int[]{8, 7, 6, 6, 5, 4, 3, 3, 0};
        this.might = 5;
        this.mightIncr = new int[]{8, 7, 6, 5, 4, 3, 3, 3, 0};
        this.sanity = 5;
        this.sanityIncr = new int[]{6, 6, 6, 5, 4, 3, 3, 3, 0};
        this.knowledge = 3 ;
        this.knowledgeIncr = new int[]{8, 7, 6, 5, 4, 3, 3, 2, 0};

        this.traitor = false;
    }
}
