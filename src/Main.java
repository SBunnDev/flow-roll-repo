import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Input output variables
        Scanner keyIn = new Scanner(System.in);
        Random rand = new Random();
        HashMap<Integer, String> positions = new HashMap<>();
        positions.put(0, "Mounted");
        positions.put(1, "Bottom Side-Control");
        positions.put(2, "Half-Guard");
        positions.put(3, "Guard");
        positions.put(4, "In Guard");
        positions.put(5, "In Half-Guard");
        positions.put(6, "Top Side-Control");
        positions.put(7, "Mount");

        //Character Variables
        String[] opponents = {"Big Bob", "Fast Freddie", "Stretchy Steve", "Relentless Randy"};
        Player playerOne = new Player ();
        int maxOppStam = 65;
        int maxOppDamage = 5;

        int stam = playerOne.stam;

        boolean running = true;

        System.out.println("Welcome to the open mats new grappler!");

        Game:
        while (running) {
            System.out.println("------------------------------------------------");
            int oppStam = rand.nextInt(maxOppStam);

            String oppName = opponents[rand.nextInt(opponents.length)];
            System.out.println("\t# " + oppName + " waves you over #\n");

            while (oppStam > 0) {
                if(stam < 1) {
                    System.out.println("\t> You have tapped due to exhaustion.... The only thing sore tomorrow will be your pride.");
                    stam += 30;
                    break;
                }
                System.out.println("\tYour Stamina: " + stam);
                System.out.println("\t" + oppName + "'s Stamina:" + oppStam);
                System.out.println("\nWhat would you like to do?");
                System.out.println("\t1. Attempt Attack");
                System.out.println("\t2. Attempt Sweep");
                System.out.println("\t3. Attempt Pass");
                System.out.println("\t4. Attempt Defend and Retreat");
                System.out.println("\t5. Defend and Breathe");
                //Selection Input
                System.out.print("Action Number >>");
                String input = keyIn.nextLine();

                if (input.equals("1")) {
                    int damTaken = rand.nextInt(maxOppDamage)-playerOne.defSkill;
                    int damDealt = playerOne.strAttack();
                    oppStam -= damDealt;
                    stam -= damTaken;

                    System.out.println("\t> You attack "+oppName+" with a non-descript attack for " + damDealt);
                    System.out.println("\t> "+oppName+" responds with an equally non-descript attack for "+damTaken);
                    if (oppStam <= 0){
                        System.out.println("After a hard-fought roll "+oppName+" taps and exits the mat.");
                    }

                }else if(input.equals("2")){
                    System.out.println("Feature coming soon");
                }else if(input.equals("3")){
                    System.out.println("Feature coming soon");
                }else if(input.equals("4")){
                    System.out.println("Feature coming soon");
                }else if(input.equals("5")){
                    int damHealed = rand.nextInt(playerOne.conDefend()+1);
                    int oppStamHealed = rand.nextInt(maxOppDamage);
                    int stamGainLow = damHealed-1;
                    int stamGainHigh = damHealed+1;
                    System.out.println("You attempt to catch your breath carefully....");
                    if ((stam < 20) && (oppStam<20)) {
                        stam += damHealed;
                        oppStam += oppStamHealed;
                        System.out.println("> You and " + oppName + " both recover some stamina.");
                    }else if ((stam > 20) && (oppStam <20)){
                        stam += stamGainLow;
                    }else{

                        stam += damHealed;
                        System.out.println("> You recover "+stamGainLow+" stamina but leave yourself open for attack.");
                        stam -= oppStamHealed;
                        System.out.println("> You take "+oppStamHealed+ " stamina damage, quit sucking wind and work!");

                    }


                }else{
                    System.out.println("Invalid Input");
                }
            }
        }
    }
}