import javafx.scene.image.ImageView;

/**
 * Real version: Signora Zopstrumm
 */

public class SpookyWitchLady extends Character{

    public SpookyWitchLady(){

        super.image = new ImageView("https://i.imgur.com/lbzgVih.png");
        image.setFitWidth(50);
        image.setFitHeight(50);
        move = moveCount;

        this.name = "Spooky Witch Lady";
        this.bio = "Spooky Witch Lady, also known by her nickname \"The Bubster\", "+
        "runs an astrology business from home, but she's too much of a coward to " +
        "look into her own future.";
        this.age = 37;

        this.x = 2;
        this.y = 5;

        this.speed = 5; // index speed is at
        this.speedIncr = new int[]{7, 6, 6, 5, 5, 3, 3, 2, 0};
        this.might = 4;
        this.mightIncr = new int[]{6, 5, 5, 5, 4, 3, 3, 2, 0};
        this.sanity = 5;
        this.sanityIncr = new int[]{8, 8, 7, 6, 5, 4, 4, 4, 0};
        this.knowledge = 4;
        this.knowledgeIncr = new int[]{6, 6, 5, 4, 4, 4, 3, 1, 0};

        this.moveCount = speedIncr[speed];

        this.traitor = false;
    }
}
