import java.util.Random;

public class Player {
    String name = "Steven";//placeholder
    int str = 2;
    int spd = 2;
    int con = 2;
    int dex = 2;
    int defSkill = 2;
    int offSkill = 2;
    Random rand = new Random();
    int stam=3*con;

    //Attack method blocks
    public int strAttack(){
        int atkPool=str+offSkill;
        int atkPass=8;
        int atkVal=0;
        for (int i=0; i<atkPool; ++i) {
            int atkTemp=0;
            atkTemp = DiceRoller.rollD10();
            if (atkTemp >= atkPass)
                atkVal++;
        }
        System.out.println("Offense Value ="+atkVal);
        return atkVal;
    }
    public int dexAttack(){
        int dmg=(dex*2)+offSkill;
        int atkVal=rand.nextInt(dmg);
        return atkVal;
    }
    public int conAttack(){
        int dmg=(con*2)+offSkill;
        int atkVal=rand.nextInt(dmg);
        return atkVal;
    }
    public int spdAttack(){
        int dmg=(spd*2)+offSkill;
        int atkVal=rand.nextInt(dmg);
        return atkVal;
    }
    public int strDefend(){
        int defPool=str+defSkill;
        int defPass=8;
        int defVal=0;
        for (int i=0; i<defPool; ++i) {
            int defTemp=0;
            defTemp = DiceRoller.rollD10();
            if (defTemp >= defPass)
                defVal++;
        }
        System.out.println("Defense value ="+defVal);
        return defVal;
    }

    public int dexDefend(){
        int def=dex+defSkill;
        int defVal=rand.nextInt(def);
        return defVal;
    }public int conDefend(){
        int def=con+defSkill;
        int defVal=rand.nextInt(def);
        return defVal;
    }public int spdDefend(){
        int def=spd+defSkill;
        int defVal=rand.nextInt(def);
        return defVal;
    }
}
