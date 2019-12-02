package Characters;

import javafx.scene.image.ImageView;

/**
 * Real version: Professor Longfellow
 */

public class ProfessorMatricide extends Character{

    public ProfessorMatricide(){

        super.image = new ImageView("Characters/character_images/ProfessorMatricide.png");
        traitorImage = new ImageView("Characters/character_images/ProfessorMatricide_TRAITOR.png");
        image.setFitWidth(75);
        image.setFitHeight(75);
        move = moveCount;

        this.name = "Prof. Matricide";
        this.bio = "Professor Matricide family's money was \nsquandered by his " +
        "gambling father. Now \nhe lives with his elderly mother (and her " +
        "\nsubstantial life insurance).";

        this.age = 57;

        this.speed = 4; // index speed is at
        this.speedIncr = new int[]{6, 6, 5, 5, 4, 4, 2, 2, 0};
        this.might = 5;
        this.mightIncr = new int[]{6, 6, 5, 5, 4, 3, 2, 1, 0};
        this.sanity = 5;
        this.sanityIncr = new int[]{7, 6, 5, 5, 4, 3, 3, 1, 0};
        this.knowledge = 3;
        this.knowledgeIncr = new int[]{8, 7, 6, 5, 5, 5, 5, 4, 0};

        this.moveCount = speedIncr[speed];

        this.traitor = false;
    }
}
