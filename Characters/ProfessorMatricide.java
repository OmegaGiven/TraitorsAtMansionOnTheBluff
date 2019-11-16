import javafx.scene.image.ImageView;

/**
 * Real version: Professor Longfellow
 */

public class ProfessorMatricide extends Character{

    public ProfessorMatricide(){

        super.image = new ImageView("https://i.imgur.com/rJZwA1T.png");
        image.setFitWidth(50);
        image.setFitHeight(50);
        move = moveCount;

        this.name = "Professor Matricide";
        this.bio = "An aristocrat by birth, Professor Matricide now lives with " +
                "his mother, broke and wondering about her life insurance policy.";
        this.picUrl = "...";

        this.x = 2;
        this.y = 5;

        this.moveCount = 4;

        this.speed = 0; // index speed is at
        this.speedIncr = new int[]{6, 6, 5, 5, 4, 4, 2, 2, 0};
        this.might = 0;
        this.mightIncr = new int[]{6, 6, 5, 5, 4, 3, 2, 1, 0};
        this.sanity = 0;
        this.sanityIncr = new int[]{7, 6, 5, 5, 4, 3, 3, 1, 0};
        this.knowledge = 0;
        this.knowledgeIncr = new int[]{8, 7, 6, 5, 5, 5, 5, 4, 0};

        this.traitor = false;
    }
}
