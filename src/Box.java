public class Box {

    private String ikona = "N";
    private boolean jeAktivni;
    private Entity entita;

    public Box(){
        this.jeAktivni = false;
    }

    public Entity getEntita(){
        return this.entita;
    }


    public boolean isJeAktivni(){
        return this.jeAktivni;
    }

    public void setJeAktivni(Entita e){
        this.jeAktivni = true;
        this.ikona = e.getIkona();
        this.entita = e.entita;
    }

    public String toString(){
        return this.ikona;
    }

}
