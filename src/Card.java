import javafx.scene.image.Image;

public class Card {
    private String cardName;
    private Image cardImage;
    private String cardDescription;

    public Card(String name, String image, String desc) {
        this.cardName = name;
        this.cardImage = new Image(image);
        this.cardDescription = desc;
    }
    public Card(){
        this.cardName = "blank";
        this.cardImage = null;
        this.cardDescription = "blank";
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Image getCardImage() {
        return cardImage;
    }

    public void setCardImage(Image cardImage) {
        this.cardImage = cardImage;
    }

    public String getCardDescription() {
        return this.cardDescription;
    }

    public void setCardDescription(String description) {
        this.cardDescription = description;
    }


}
