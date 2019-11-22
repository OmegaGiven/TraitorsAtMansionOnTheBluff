package GameBoard;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Stairs extends Tile {
//    Button up = new Button("Go Up");
//    Button down = new Button("Go Down");
    int pane;
    int x = 0;
    int y = 5;

    Stairs() {
        super();
    }
    Stairs(String image, boolean n, boolean s, boolean w, boolean e) {
        super(new ImageView(image), true, n, s, w, e);
    }

    void upDown(GridPane pane, int pane1, Button up, Button down) {
        this.pane = pane1;
        if(this.pane < 4) {
            pane.add(up,0, 0);
        }
        if(this.pane >= 0) {
            pane.add(down, 0, 1);
        }
//        return panes[this.pane];
    }

}
