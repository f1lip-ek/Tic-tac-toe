import java.util.Random;

public class AI extends Entita {

    private Random rd;


    public AI(){
        this.ikona = "0";
        this.rd = new Random();
    }

    public int[] getMove(){
        return new int[]{rd.nextInt(Game.velikost)/*x*/, rd.nextInt(Game.velikost)/*y*/};
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
