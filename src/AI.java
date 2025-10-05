import java.util.Random;

public class AI extends Entita {

    private Random rd;


    public AI(){
        this.ikona = "0";
        this.entita = Entity.AI;
        this.rd = new Random();
    }

    public int[] getMove(){
        return new int[]{rd.nextInt(Game.fieldSize)/*x*/, rd.nextInt(Game.fieldSize)/*y*/};
    }

    public int[] getMoveAdvanced(){

        return new int[]{rd.nextInt(Game.fieldSize)/*x*/, rd.nextInt(Game.fieldSize)/*y*/};
    }

    public void addTah(){
        this.tah++;
    }

    public int getTah(){
        return tah;
    }

    public String getIkona(){
        return ikona;
    }

}
