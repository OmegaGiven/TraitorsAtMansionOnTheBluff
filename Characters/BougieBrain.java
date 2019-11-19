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
        this.bio = "Bougie Brain is a young girl who is obsessed with perfection." +
        " If things aren't perfect, she feels like something angry is trying to dig" +
        " its way out of her skull.";
        this.age = 18;

        this.x = 2;
        this.y = 5;

        this.speed = 5; // index speed is at
        this.speedIncr = new int[]{8, 7, 6, 6, 5, 4, 3, 3, 0};
        this.might = 5;
        this.mightIncr = new int[]{8, 7, 6, 5, 4, 3, 3, 3, 0};
        this.sanity = 5;
        this.sanityIncr = new int[]{6, 6, 6, 5, 4, 3, 3, 3, 0};
        this.knowledge = 3 ;
        this.knowledgeIncr = new int[]{8, 7, 6, 5, 4, 3, 3, 2, 0};

        this.moveCount = speedIncr[speed];

        this.traitor = false;
    }
}
