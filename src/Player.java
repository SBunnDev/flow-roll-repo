import java.util.Random;

public class Player {
    String name = "Steven";
    int str = 2;
    int spd = 2;
    int con = 2;
    int dex = 2;
    int defSkill = 2;
    int offSkill = 2;
    Random rand = new Random();
    int stam=25*con;

    //Attack method blocks
    public int strAttack(){
        int dmg=str+offSkill;
        int atkVal=rand.nextInt(dmg);
        return atkVal;
    }
    public int dexAttack(){
        int dmg=dex+offSkill;
        int atkVal=rand.nextInt(dmg);
        return atkVal;
    }
    public int conAttack(){
        int dmg=con+offSkill;
        int atkVal=rand.nextInt(dmg);
        return atkVal;
    }
    public int spdAttack(){
        int dmg=spd+offSkill;
        int atkVal=rand.nextInt(dmg);
        return atkVal;
    }
    public int strDefend(){
        int def=str+defSkill;
        int defVal=rand.nextInt(def);
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
