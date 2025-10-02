public class Box {

    private String ikona = "N";
    private boolean jeAktivni;

    public Box(){
        this.jeAktivni = false;
    }

    public void setJeAktivni(boolean jeAktivni){
        this.jeAktivni = jeAktivni;
    }

    public boolean isJeAktivni(){
        return this.jeAktivni;
    }

    public void setJeAktivni(Entita e){
        this.jeAktivni = true;
        this.ikona = e.getIkona();
    }

    public String toString(){
        return this.ikona;
    }

}
