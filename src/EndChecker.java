public class EndChecker {

    private boolean isPlaying;
    private boolean isWin;
    private Entity winner;

    public EndChecker(){
        this.isPlaying = false;
        this.isWin = false;
    }

    public void setPlaying(boolean playing){
        this.isPlaying = playing;
    }

    public boolean isPlaying(){
        return this.isPlaying;
    }

    public void setWin(Entita e, Box[][] gameField, int x, int y){
        try{
            kontrola(x, y, gameField, e);
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Neni konec hry");
        }
    }

    public void kontrola(int x, int y, Box[][] gameField, Entita e){
        //VODOROVNE
        if (y == 0 && (gameField[x][y].getEntita() == e.entita && gameField[x][y+1].getEntita() == e.entita && gameField[x][y+2].getEntita() == e.entita)){
            winner = e.entita;
            isWin = true;
            System.out.println("Konec hry");
            System.out.println("Vyhral " + winner);
            System.exit(0);
        }
        if (y == 1 && (gameField[x][y].getEntita() == e.entita && gameField[x][y+1].getEntita() == e.entita && gameField[x][y-1].getEntita() == e.entita)){
            winner = e.entita;
            isWin = true;
            System.out.println("Konec hry");
            System.out.println("Vyhral " + winner);
            System.exit(0);
        }
        if (y == 2 && (gameField[x][y].getEntita() == e.entita && gameField[x][y-1].getEntita() == e.entita && gameField[x][y-2].getEntita() == e.entita)) {
            winner = e.entita;
            isWin = true;
            System.out.println("Konec hry");
            System.out.println("Vyhral " + winner);
            System.exit(0);
        }//SVISLE
        if (x == 0 && (gameField[x][y].getEntita() == e.entita && gameField[x+1][y].getEntita() == e.entita && gameField[x+2][y].getEntita() == e.entita)) {
            winner = e.entita;
            isWin = true;
            System.out.println("Konec hry");
            System.out.println("Vyhral " + winner);
            System.exit(0);
        }
        if (x == 1 && (gameField[x][y].getEntita() == e.entita && gameField[x+1][y].getEntita() == e.entita && gameField[x-1][y].getEntita() == e.entita)) {
            winner = e.entita;
            isWin = true;
            System.out.println("Konec hry");
            System.out.println("Vyhral " + winner);
            System.exit(0);
        }
        if (x == 2 && (gameField[x][y].getEntita() == e.entita && gameField[x-1][y].getEntita() == e.entita && gameField[x-2][y].getEntita() == e.entita)) {
            winner = e.entita;
            isWin = true;
            System.out.println("Konec hry");
            System.out.println("Vyhral " + winner);
            System.exit(0);
        }//DIAGONALNE ODSHORA DOLU
        if (x == 0 && y == 0 && (gameField[x][y].getEntita() == e.entita && gameField[x+1][y+1].getEntita() == e.entita && gameField[x+2][y+2].getEntita() == e.entita)) {
            winner = e.entita;
            isWin = true;
            System.out.println("Konec hry");
            System.out.println("Vyhral " + winner);
            System.exit(0);
        }
        if (x == 1 && y == 1 && (gameField[x][y].getEntita() == e.entita && gameField[x-1][y-1].getEntita() == e.entita && gameField[x+1][y+1].getEntita() == e.entita)) {
            winner = e.entita;
            isWin = true;
            System.out.println("Konec hry");
            System.out.println("Vyhral " + winner);
            System.exit(0);
        }
        if (x == 2 && y == 2 && (gameField[x][y].getEntita() == e.entita && gameField[x-1][y-1].getEntita() == e.entita && gameField[x-2][y-2].getEntita() == e.entita)) {
            winner = e.entita;
            isWin = true;
            System.out.println("Konec hry");
            System.out.println("Vyhral " + winner);
            System.exit(0);
        }//DIAGONALNE ODSPODA NAHORU
        if (x == 2 && y == 0 && (gameField[x][y].getEntita() == e.entita && gameField[x-1][y+1].getEntita() == e.entita && gameField[x-2][y+2].getEntita() == e.entita)) {
            winner = e.entita;
            isWin = true;
            System.out.println("Konec hry");
            System.out.println("Vyhral " + winner);
            System.exit(0);
        }
        if (x == 1 && y == 1 && (gameField[x][y].getEntita() == e.entita && gameField[x-1][y+1].getEntita() == e.entita && gameField[x+1][y-1].getEntita() == e.entita)) {
            winner = e.entita;
            isWin = true;
            System.out.println("Konec hry");
            System.out.println("Vyhral " + winner);
            System.exit(0);
        }
        if (x == 0 && y == 2 && (gameField[x][y].getEntita() == e.entita && gameField[x+1][y-1].getEntita() == e.entita && gameField[x+2][y-2].getEntita() == e.entita)) {
            winner = e.entita;
            isWin = true;
            System.out.println("Konec hry");
            System.out.println("Vyhral " + winner);
            System.exit(0);
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int isEnd(Box[][] gameField){
        int counter = 0;
        for (int i = 0; i < Game.fieldSize; i++) {
            for (int j = 0; j < Game.fieldSize; j++) {
                if(gameField[i][j].isJeAktivni()){
                    counter++;
                }
            }
        }
        return counter;
    }

    public boolean gameEnd(Box[][] gameField, Entita e, int x, int y){
        if (isEnd(gameField) == Math.pow(Game.fieldSize, 2) && !isWin){
            System.out.println("Remiza");
            System.exit(0);
            return true;
        }
        setWin(e, gameField, x, y);
        return false;
    }

    public boolean isWin(){
        return this.isWin;
    }

}
