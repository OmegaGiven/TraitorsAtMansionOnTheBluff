package Characters;

import javafx.scene.image.ImageView;

/**
 * Real version: Father Rhinehardt
 */

public class PapaKooky extends Character {

    public PapaKooky(){

        super.image = new ImageView("Characters/character_images/PapaKooky.png");
        traitorImage = new ImageView("Characters/character_images/PapaKooky_TRAITOR.png");
        image.setFitWidth(75);
        image.setFitHeight(75);
        move = moveCount;

        this.name = "Papa Kooky";
        this.bio = "Papa Kooky is a German immigrant who \nbecame a priest in order " +
        "to understand \nevil in the world. He is haunted by \nthoughts of blood and" +
        " pain and death.";
        this.age = 62;


        this.speed = 5; // index speed is at
        this.speedIncr = new int[]{7, 7, 6, 5, 4, 3, 3, 2, 0};
        this.might = 5;
        this.mightIncr = new int[]{7, 5, 5, 4, 4, 3, 3, 1};
        this.sanity = 3;
        this.sanityIncr = new int[]{8, 7, 7, 6, 5, 5, 4, 3, 0};
        this.knowledge = 4;
        this.knowledgeIncr = new int[]{8, 6, 6, 5, 4, 3, 3, 1, 0};

        this.moveCount = speedIncr[speed];

        this.traitor = false;
    }
}
