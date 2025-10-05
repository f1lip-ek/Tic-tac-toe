import java.util.Random;

public class AI extends EntityClass {

    private final Random rd;


    public AI(){
        this.icon = "0";
        this.entity = Entity.AI;
        this.rd = new Random();
    }

    public int[] getMove(){
        return new int[]{rd.nextInt(Game.fieldSize)/*x*/, rd.nextInt(Game.fieldSize)/*y*/};
    }

    //TODO
    public int[] getMoveAdvanced(){
        return new int[]{rd.nextInt(Game.fieldSize)/*x*/, rd.nextInt(Game.fieldSize)/*y*/};
    }

}
