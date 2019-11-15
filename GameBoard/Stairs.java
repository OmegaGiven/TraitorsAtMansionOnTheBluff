import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Stairs extends Tile {
//    Button up = new Button("Go Up");
//    Button down = new Button("Go Down");
//    int pane;
    int x = 0;
    int y = 5;

    Stairs() {
        super(new ImageView(), true);
//        up.setOnMouseClicked(event -> {
//            this.pane++;
//        });
//        down.setOnMouseClicked(event -> {
//            this.pane--;
//        });
    }
    Stairs(String image) {
        super(new ImageView(image), true);
//        up.setOnMouseClicked(event -> {
//            this.pane++;
//        });
//        down.setOnMouseClicked(event -> {
//            this.pane--;
//        });
    }

    void upDown(GridPane pane, int paneInt, Button up, Button down) {
//        this.pane = paneInt;
        if(paneInt < 4) {
            pane.add(up,0, 0);
        }
        if(paneInt >= 0) {
            pane.add(down, 0, 1);
        }
//        return panes[this.pane];
    }

}
