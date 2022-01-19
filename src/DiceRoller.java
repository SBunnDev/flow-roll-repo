import java.util.Random;

public class DiceRoller {

    //Dice Rollers for d20,d12,d10,d8,d6,d4 and d2 (i.e. coin flip)
    public static int rollD20() {
        Random r = new Random();
        int d20Val = r.nextInt(20) + 1;
        return d20Val;
    }
    public static int rollD12() {
        Random r = new Random();
        int d12Val = r.nextInt(12) + 1;
        return d12Val;
    }
    public static int rollD10(){
        Random r = new Random();
        int d10Val = r.nextInt(10)+1;
        return d10Val;
    }
    public static int rollD6(){
        Random r = new Random();
        int d6Val = r.nextInt(6)+1;
        return d6Val;
    }
    public static int rollD4() {
        Random r = new Random();
        int d4Val = r.nextInt(4) + 1;
        return d4Val;
    }
    public static int rollD2() {
        Random r = new Random();
        int d2Val = r.nextInt(2) + 1;
        return d2Val;
    }
}