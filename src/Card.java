import javafx.scene.image.Image;

import java.io.*;
import java.util.ArrayList;

public class Card {
    private String cardName;
    private Image cardImage;
    private String cardDescription;
    private String type;

    public Card(String name, String image, String t, String desc) {
        this.cardName = name;
        //this.cardImage = new Image(image);
        this.cardDescription = desc;
        this.type = t;
    }
    public Card(){
        this.cardName = "blank";
        this.cardImage = null;
        this.cardDescription = "blank";
        this.type = "blank";
    }

    @Override
    public String toString(){
        return this.getCardName() + "\n" + getCardImage() + "\n" + getType() + "\n" + getCardDescription() + "\n";
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

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public static void main(String[] args) {
        Card card = new Card();
        ArrayList<Card> test = card.readCards("cards.txt");
        for(Card derek : test){
            System.out.println(derek);
        }
    }

    public ArrayList<Card> readCards(String filename){
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            String line = file.readLine();
            String[] tempLine;
            ArrayList<Card> returnCard = new ArrayList<Card>();
            while(line != null){
                tempLine = line.split(",");
                returnCard.add(new Card(tempLine[0], tempLine[1], tempLine[2], tempLine[3]));
                line = file.readLine();
            }
            return returnCard;
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException t){
            t.printStackTrace();
        }
        return null;
    }
}
