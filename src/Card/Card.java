package Card;

import javafx.scene.image.ImageView;

import java.io.*;
import java.util.ArrayList;

public class Card {
    private String name;
    private String description;
    private String type;

    private int damage;
    private String category;

    private ImageView image;

    public Card(String name, String type, String desc, int damage, String category, ImageView image) {
        this.name = name;
        this.type = type;
        this.description = desc;
        this.damage = damage;
        this.category = category;
        this.image = image;
    }
    public Card(String name, String type, String desc, int damage, String category){
        this.name = name;
        this.type = type;
        this.description = desc;
        this.damage = damage;
        this.category = category;
    }
    public Card(String name, String type, String desc){
        this.name = name;
        this.type = type;
        this.description = desc;
    }



    public Card(){
        this.name = "";
        this.description = "";
        this.type = "";
        this.damage = 0;
        this.category = "";
        this.image = null;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString(){
        return this.getCardName() + "\n" + getCardDescription() + "\n";
    }

    public String getCardName() {
        return name;
    }

    public void setCardName(String cardName) {
        this.name = cardName;
    }

    public String getCardDescription() {
        return this.description;
    }

    public void setCardDescription(String description) {
        this.description = description;
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

//    public static void main(String[] args) {
//        Card card = new Card();
//        ArrayList<Card> test = card.readCards("cards.txt");
//        ArrayList<Card> items = new ArrayList<>();
//        ArrayList<Card> omens = new ArrayList<>();
//        for(Card derek : test){
//            if(derek.getType().equals("Item")){
//                items.add(derek);
//            }
//            else if(derek.getType().equals("Card.Omen")){
//                omens.add(derek);
//            }
//            System.out.println(derek);
//        }
//    }

    public ArrayList<Card> readCards(String filename){
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            String line = file.readLine();
            String[] tempLine;
            ArrayList<Card> returnCard = new ArrayList<Card>();
            while(line != null){
                tempLine = line.split(",");
                if(tempLine[1].equals("Omen")){
                    returnCard.add(new Card(tempLine[0], tempLine[1], tempLine[2]));
                    line = file.readLine();
                }
                else if(tempLine[1].equals("Event")){
                    int damage =  Integer.parseInt(tempLine[3]);
                    returnCard.add(new Card(tempLine[0], tempLine[1], tempLine[2],damage,tempLine[4]));
                    line = file.readLine();
                }
                else{
                    int damage =  Integer.parseInt(tempLine[3]);
                    ImageView picture = new ImageView(tempLine[5]);
                    returnCard.add(new Card(tempLine[0], tempLine[1], tempLine[2], damage, tempLine[4], picture));
                    line = file.readLine();
                }
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
//    public Card drawCard(String cardType){
//        switch(cardType){
//            case "Item":
//
//            case "Card.Omen":
//
//        }
//        return null;
//    }
}
