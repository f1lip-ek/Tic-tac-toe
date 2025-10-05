public class Player extends EntityClass {

    public Player(){
        this.icon = "X";
        this.entity = Entity.PLAYER;
    }

    public void addTah(){
        this.tah++;

    }

    public int getTah(){
        return tah;
    }

}
