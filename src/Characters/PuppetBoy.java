package Characters;
import javafx.scene.image.ImageView;

/**
 * Real version: Brandon Jaspers
 */

public class PuppetBoy extends Character {

    public PuppetBoy(){

        super.image = new ImageView("Characters/character_images/PuppetBoy.png");
        traitorImage = new ImageView("Characters/character_images/PuppetBoy_TRAITOR.png");
        image.setFitWidth(75);
        image.setFitHeight(75);
        move = moveCount;

        this.name = "Puppet Boy";
        this.bio = "Puppet Boy is a kid that loves camping \nand coding, and HATES " +
        "clowns. When \nhe was little, his clown puppet moved \ncloser to him when he " +
        "slept.";
        this.age = 12;

        this.x = 2;
        this.y = 5;

        this.speed = 5; // index speed is at
        this.speedIncr = new int[]{8, 7, 6, 5, 4, 4, 4, 3, 0};
        this.might = 4;
        this.mightIncr = new int[]{7, 6, 6, 5, 4, 3, 3, 2, 0};
        this.sanity = 4;
        this.sanityIncr = new int[]{8, 7, 6, 5, 4, 3, 3, 2, 0};
        this.knowledge = 5;
        this.knowledgeIncr = new int[]{7, 6, 6, 5, 5, 4, 4, 1, 0};

        this.moveCount = speedIncr[speed];

        this.traitor = false;
    }
}
