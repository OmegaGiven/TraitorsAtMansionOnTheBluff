import javafx.scene.image.ImageView;

/**
 * Super class for the other characters
 * ### QUESTIONS ###
 */

public class Character {

    ImageView image;
    int move;

    protected String name;
    protected String bio;
    protected int age;

    protected int x;
    protected int y;

    protected int moveCount; // when turn starts, moveCount = speedIncr[speed]; when moveCount = 0, player has no more moves

    protected int speed;
    protected int[] speedIncr;
    protected int might;
    protected int[] mightIncr;
    protected int sanity;
    protected int[] sanityIncr;
    protected int knowledge;
    protected int[] knowledgeIncr;
    protected boolean traitor;

    public Character(){
        this.image = new ImageView();
        this.name = "";
        this.bio = "";
        this.age = 0;

        this.x = 0;
        this.y = 0;

        this.speed = 0;
        this.speedIncr = new int[8];
        this.might = 0;
        this.mightIncr = new int[8];
        this.sanity = 0;
        this.sanityIncr = new int[8];
        this.knowledge = 0;
        this.knowledgeIncr = new int[8];
        this.traitor = false;
    }

    public Character(String name, String bio, ImageView image, int age, int x, int y, int moveCount, int speed,
                     int[] speedIncr, int might, int[] mightIncr, int sanity,
                     int[] sanityIncr, int knowledge, int[] knowledgeIncr){
        this.name = name;
        this.bio = bio;
        this.image = image;
        this.age = age;
        this.moveCount = moveCount;
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
    }

    /**
     *
     * @param amt Amount by which the speed decreases
     * @return new stat
     */
    public int changeSpeed(int amt){
        speed = speed + amt;
        return speedIncr[speed];
    }

    public int changeMight(int amt){
        might = might + amt;
        return mightIncr[might];
    }

    public int changeSanity(int amt){
        sanity = sanity + amt;
        return sanityIncr[sanity];
    }

    public int changeKnowledge(int amt){
        knowledge = knowledge + amt;
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
        this.traitor = traitor;
    }


}