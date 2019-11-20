import javafx.scene.image.ImageView;

/**
 * Real version: Jenny LeClerc
 */

public class SadBookGirl extends Character{

    public SadBookGirl(){

        super.image = new ImageView("https://i.imgur.com/cH1IjHy.png");
        image.setFitWidth(50);
        image.setFitHeight(50);
        move = moveCount;

        this.name = "Sad Book Girl";
        this.bio = "Sad Book Girl's mother disappeared when she was seven, leaving " +
        "her completely alone. Now her only solace is found in books.";
        this.age = 21;

        this.x = 2;
        this.y = 5;

        this.speed = 4; // index speed is at
        this.speedIncr = new int[]{8, 6, 5, 4, 4, 4, 3, 2, 0};
        this.might = 5;
        this.mightIncr = new int[]{8, 6, 5, 4, 4, 4, 4, 3, 0};
        this.sanity = 3;
        this.sanityIncr = new int[]{6, 5, 4, 4, 4, 2, 1, 1, 0};
        this.knowledge = 5;
        this.knowledgeIncr = new int[]{8, 6, 5, 4, 4, 3, 3, 2, 0};

        this.moveCount = speedIncr[speed];

        this.traitor = false;
    }
}
