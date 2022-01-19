import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;
/*
    BJJ decision making rolling simulator, the goal of this program is to cement Java concepts and "get miles under the wheels"

    Combat system: Roll a number d10 dice equal to relevant stat system. 8,9,and 10s count as a success for an attack. The same system
        is used as the opponents defense with their relevant stats. The delta in success determines the outcome, with said value being applied
        as stamina or position "damage" (position advantage gained or lost which will impart roll modifiers). If a roll features a number (variable trait)
        of successes over an opponent and the opponents defense roll is all failures the result is a tapout.

     Trait system: Modifiers will be confered to the player as well as to enemies based off of their traits. Rank and skillsets/body traits
        will make each roll unique.

 */
public class Main {

    public static void main(String[] args) {
        //Input output variables
        Scanner keyIn = new Scanner(System.in);
        Random rand = new Random();
        //Position Map (Not Implemented yet)
        /*
        HashMap<Integer, String> positions = new HashMap<>();
        positions.put(0, "Mounted");
        positions.put(1, "Bottom Side-Control");
        positions.put(2, "Half-Guard");
        positions.put(3, "Guard");
        positions.put(4, "In Guard");
        positions.put(5, "In Half-Guard");
        positions.put(6, "Top Side-Control");
        positions.put(7, "Mount");
        */
        //Character Variables (opponent generation will be moved into more robust constructor once modifiers are fleshed out)
        String[] opponents = {"Big Bob", "Fast Freddie", "Stretchy Steve", "Relentless Randy"};
        Player playerOne = new Player ();
        Player opponent = new Player ();
        //Player stam outside of game loop *currently to degrade over multiple rolls
        int stam = playerOne.stam;
        //Game State, will eventually be used for coming in and out of start menu
        boolean running = true;

        System.out.println("Welcome to the open mats new grappler!");
        //Label I need to figure out how to use
        Game:
        while (running) {
            System.out.println("------------------------------------------------");
            int oppStam = opponent.stam;

            String oppName = opponents[rand.nextInt(opponents.length)];
            System.out.println("\t# " + oppName + " waves you over #\n");

            while (oppStam > 0) {
                //Action Option Block
                System.out.println("\tYour Stamina: " + stam);
                System.out.println("\t" + oppName + "'s Stamina:" + oppStam);
                System.out.println("\nWhat would you like to do?");
                System.out.println("\t1. Attempt Attack");
                System.out.println("\t2. Attempt Sweep(Temporarily old Dex Attack");
                System.out.println("\t3. Attempt Pass");
                System.out.println("\t4. Attempt Defend and Retreat");
                System.out.println("\t5. Defend and Breathe");
                //Selection Input
                System.out.print("Action Number >>");
                String input = keyIn.nextLine();

                if (input.equals("1")) {

                    int damTaken = opponent.strAttack() - playerOne.strDefend();
                    System.out.println("^^ Opponent attack vv Player attack");
                    int damDealt = playerOne.strAttack() - opponent.strDefend();

                    oppStam -= damDealt;
                    stam -= damTaken;

                    System.out.println("\t> You attack "+oppName+" with a non-descript attack for " + damDealt);
                    System.out.println("\t> "+oppName+" responds with an equally non-descript attack for "+damTaken);
                    if (oppStam <= 0){
                        System.out.println("After a hard-fought roll "+oppName+" taps and exits the mat.");
                    }
                }else if(input.equals("2")){
                    System.out.println("Temp Dex Attack Space");
                    int damTaken = opponent.dexAttack() - playerOne.defSkill;
                    int damDealt = playerOne.dexAttack() - opponent.defSkill;
                    oppStam -= damDealt;
                    stam -= damTaken;

                    System.out.println("\t> You attack "+oppName+" with a non-descript attack for " + damDealt);
                    System.out.println("\t> "+oppName+" responds with an equally non-descript attack for "+damTaken);
                    if (oppStam <= 0){
                        System.out.println("After a hard-fought roll "+oppName+" taps and exits the mat.");
                    }
                }else if(input.equals("3")){
                    System.out.println("Feature coming soon");
                }else if(input.equals("4")){
                    System.out.println("Feature coming soon");
                }else if(input.equals("5")){
                    int damHealed = playerOne.conDefend()+1;
                    int oppStamHealed = opponent.conDefend()+1;

                    System.out.println("You attempt to catch your breath carefully....");
                    if ((stam < 2) && (oppStam < 2)) {
                        stam += damHealed + playerOne.con;
                        oppStam += oppStamHealed;
                        System.out.println("> You and " + oppName + " both rest.");
                    }else if ((stam > 2) && (oppStam < 2)){
                        stam += damHealed;
                        oppStam+= oppStamHealed+1;
                        System.out.println("> You and " + oppName + " both rest, but "+ oppName +" appears more refreshed");
                    }else{
                        stam += damHealed-1;
                        System.out.println("> You recover "+ (damHealed-1) +" stamina but leave yourself open for attack.");
                        stam -= oppStamHealed;
                        System.out.println("> You take "+oppStamHealed+ " stamina drain as "+oppName+" attacks, quit sucking wind and work!");
                    }

                }else{
                    System.out.println("Invalid Input");
                }
                if(stam < 1) {
                    System.out.println("\t> You have tapped due to exhaustion.... The only thing sore tomorrow will be your pride.");
                    stam += playerOne.stam;
                    break;
                }
            }
        }
    }
}