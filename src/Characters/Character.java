package Characters;
import Card.Card;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

/**
 * Super class for the other characters
 * ### QUESTIONS ###
 */

public class Character {

    ImageView image;
    ImageView traitorImage;
    int move;

    protected String name;
    protected String bio;
    protected int age;

    protected int x;
    protected int y;

    protected int moveCount; // when turn starts, moveCount = speedIncr[speed]; when moveCount = 0, player has no more moves
    ArrayList<Card> items;

    protected int speed;
    protected int[] speedIncr;
    protected int might;
    protected int[] mightIncr;
    protected int sanity;
    protected int[] sanityIncr;
    protected int knowledge;
    protected int[] knowledgeIncr;
    protected boolean traitor;
    protected boolean isAlive;

    public Character(){
        this.image = new ImageView();
        this.name = "";
        this.bio = "";
        this.age = 0;

        this.x = 0;
        this.y = 0;

        this.moveCount = 0;
        this.items = new ArrayList<Card>();

        this.speed = 0;
        this.speedIncr = new int[8];
        this.might = 0;
        this.mightIncr = new int[8];
        this.sanity = 0;
        this.sanityIncr = new int[8];
        this.knowledge = 0;
        this.knowledgeIncr = new int[8];
        this.traitor = false;
        this.isAlive = true;
    }

    public Character(String name, String bio, ImageView image, int age, int x, int y, int moveCount, int speed,
                     ArrayList<Card> items, int[] speedIncr, int might, int[] mightIncr, int sanity,
                     int[] sanityIncr, int knowledge, int[] knowledgeIncr){
        this.name = name;
        this.bio = bio;
        this.image = image;
        this.age = age;
        this.moveCount = moveCount;
        this.items = items;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.speedIncr = speedIncr;
        this.might = might;
        this.mightIncr = mightIncr;
        this.sanity = sanity;
        this.sanityIncr = sanityIncr;
        this.knowledge = knowledge;
        this.knowledgeIncr = knowledgeIncr;

        this.traitor = false;
        this.isAlive = true;
    }

    public String getStats(){
        String stats = "SPEED                  :    " + speed;
        stats +=       "\nMIGHT                 :    " + might;
        stats +=       "\nSANITY                :    " + sanity;
        stats +=       "\nKNOWLEDGE       :    " + knowledge;
        return stats;
    }

    public void addItem(Card item){
        items.add(item);
    }

    public ArrayList<Card> getCards(){
        return items;
    }

    public void removeItem(Card item){
        items.remove(item);
    }

    public boolean isAlive(){
        return isAlive;
    }

    public void setAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    public int changeSpeed(int amt){
        speed = speed + amt;
        if(speedIncr[speed] == 0) isAlive = false;
        return speedIncr[speed];
    }

    public int changeMight(int amt){
        might = might + amt;
        if(mightIncr[might] == 0) isAlive = false;
        return mightIncr[might];
    }

    public int changeSanity(int amt){
        sanity = sanity + amt;
        if(sanityIncr[sanity] == 0) isAlive = false;
        return sanityIncr[sanity];
    }

    public int changeKnowledge(int amt){
        knowledge = knowledge + amt;
        if(knowledgeIncr[knowledge] == 0) isAlive = false;
        return knowledgeIncr[knowledge];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public ImageView getImage(){ return image;}

    public void setImage(ImageView image){ this.image = image;}

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }


    public int getSpeed() {
        return speedIncr[speed];
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int[] getSpeedIncr() {
        return speedIncr;
    }

    public void setSpeedIncr(int[] speedIncr) {
        this.speedIncr = speedIncr;
    }


    public int getMight() {
        return mightIncr[might];
    }

    public void setMight(int might) {
        this.might = might;
    }

    public int[] getMightIncr() {
        return mightIncr;
    }

    public void setMightIncr(int[] mightIncr) {
        this.mightIncr = mightIncr;
    }


    public int getSanity() {
        return sanityIncr[sanity];
    }

    public void setSanity(int sanity) {
        this.sanity = sanity;
    }

    public int[] getSanityIncr() {
        return sanityIncr;
    }

    public void setSanityIncr(int[] sanityIncr) {
        this.sanityIncr = sanityIncr;
    }


    public int getKnowledge() {
        return knowledgeIncr[knowledge];
    }

    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }

    public int[] getKnowledgeIncr() {
        return knowledgeIncr;
    }

    public void setKnowledgeIncr(int[] knowledgeIncr) {
        this.knowledgeIncr = knowledgeIncr;
    }


    public boolean isTraitor() {
        return traitor;
    }

    public void setTraitor(boolean traitor) {
        traitorImage.setFitWidth(75);
        traitorImage.setFitHeight(75);
        this.image = traitorImage;
        this.traitor = traitor;
    }


}