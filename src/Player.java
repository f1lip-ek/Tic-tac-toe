public class Player extends Entita{

    public Player(){
        this.ikona = "X";
        this.entita = Entity.PLAYER;
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
