import javafx.scene.image.ImageView;

/**
 * Real version: Peter Akimoto
 */

public class BugBoy extends Character {

    public BugBoy(){

        super.image = new ImageView("https://p7.hiclipart.com/preview/604/28/893/lola-bunny-bugs-bunny-tasmanian-devil-tweety-daffy-duck-disney-characters.jpg");
        image.setFitWidth(50);
        image.setFitHeight(50);
        move = moveCount;

        this.name = "Bug Boy";
        this.bio = "Seriously bullied by his family, Bug Boy likes to hide  " +
                "under his house and look at bugs. He wants to be an entomologist.";
        this.picUrl = "...";

        this.x = 0;
        this.y = 0;

        this.moveCount = 4;

        this.speed = 0; // index speed is at
        this.speedIncr = new int[]{7, 7, 6, 6, 4, 3, 3, 3, 0};
        this.might = 0;
        this.mightIncr = new int[]{8, 6, 5, 5, 4, 3, 3, 2, 0};
        this.sanity = 0;
        this.sanityIncr = new int[]{7, 6, 6, 5, 4, 4, 4, 3, 0};
        this.knowledge = 0;
        this.knowledgeIncr = new int[]{8, 7, 7, 6, 5, 4, 4, 3, 0};

        this.traitor = false;
    }
}
