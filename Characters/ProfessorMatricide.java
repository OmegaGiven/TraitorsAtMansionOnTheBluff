/**
 * Real version: Professor Longfellow
 */

public class ProfessorMatricide extends Character{

    public ProfessorMatricide(){
        this.name = "Professor Matricide";
        this.bio = "An aristocrat by birth, Professor Matricide now lives with " +
                "his mother, broke and wondering about her life insurance policy.";
        this.picUrl = "...";

        this.x = 0;
        this.y = 0;

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
