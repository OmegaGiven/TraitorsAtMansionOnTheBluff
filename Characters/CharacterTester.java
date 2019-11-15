public class CharacterTester {

    public static void main(String[] args){
        BugBoy jasp = new BugBoy();
        System.out.println(jasp.getBio());
        System.out.println("==== SPEED ====");
        System.out.println("EXPECTED:       8");
        System.out.println("ACTUAL:         " + jasp.getSpeed());
        System.out.println("AFTER -2");
        System.out.println("EXPECTED:       6");
        System.out.println("ACTUAL:         " + jasp.changeSpeed(2));
        System.out.println("AFTER +1");
        System.out.println("EXPECTED:       7");
        System.out.println("ACTUAL:         " + jasp.changeSpeed(-1));
        System.out.println("==== MIGHT ====");
        System.out.println("EXPECTED:       7");
        System.out.println("ACTUAL:         " + jasp.getMight());
        System.out.println("AFTER -2");
        System.out.println("EXPECTED:       6");
        System.out.println("ACTUAL:         " + jasp.changeMight(2));
        System.out.println("==== SANITY ====");
        System.out.println("EXPECTED:       8");
        System.out.println("ACTUAL:         " + jasp.getSanity());
        System.out.println("AFTER -2");
        System.out.println("EXPECTED:       6");
        System.out.println("ACTUAL:         " + jasp.changeSanity(2));
        System.out.println("==== KNOWLEDGE ====");
        System.out.println("EXPECTED:       7");
        System.out.println("ACTUAL:         " + jasp.getKnowledge());
        System.out.println("AFTER -2");
        System.out.println("EXPECTED:       6");
        System.out.println("ACTUAL:         " + jasp.changeKnowledge(2));
        System.out.println("==== TRAITOR ====");
        System.out.println("EXPECTED:       FALSE");
        System.out.println("ACTUAL:         " + jasp.isTraitor());
        System.out.println("AFTER TRAITOR");
        jasp.setTraitor(true);
        System.out.println("EXPECTED:       TRUE");
        System.out.println("ACTUAL:         " + jasp.isTraitor());
    }
}
