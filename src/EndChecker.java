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

    public void setWin(EntityClass e, Box[][] gameField, int x, int y){
        try{
            checkEnd(x, y, gameField, e);
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Neni konec hry");
        }
    }

    public void checkEnd(int x, int y, Box[][] gameField, EntityClass e){
        //VODOROVNE
        if (y == 0 && (gameField[x][y].getEntity() == e.entity && gameField[x][y+1].getEntity() == e.entity && gameField[x][y+2].getEntity() == e.entity)){
            doEnd(e);
        }
        if (y == 1 && (gameField[x][y].getEntity() == e.entity && gameField[x][y+1].getEntity() == e.entity && gameField[x][y-1].getEntity() == e.entity)){
            doEnd(e);
        }
        if (y == 2 && (gameField[x][y].getEntity() == e.entity && gameField[x][y-1].getEntity() == e.entity && gameField[x][y-2].getEntity() == e.entity)) {
            doEnd(e);
        }//SVISLE
        if (x == 0 && (gameField[x][y].getEntity() == e.entity && gameField[x+1][y].getEntity() == e.entity && gameField[x+2][y].getEntity() == e.entity)) {
            doEnd(e);
        }
        if (x == 1 && (gameField[x][y].getEntity() == e.entity && gameField[x+1][y].getEntity() == e.entity && gameField[x-1][y].getEntity() == e.entity)) {
            doEnd(e);
        }
        if (x == 2 && (gameField[x][y].getEntity() == e.entity && gameField[x-1][y].getEntity() == e.entity && gameField[x-2][y].getEntity() == e.entity)) {
            doEnd(e);
        }//DIAGONALNE ODSHORA DOLU
        if (x == 0 && y == 0 && (gameField[x][y].getEntity() == e.entity && gameField[x+1][y+1].getEntity() == e.entity && gameField[x+2][y+2].getEntity() == e.entity)) {
            doEnd(e);
        }
        if (x == 1 && y == 1 && (gameField[x][y].getEntity() == e.entity && gameField[x-1][y-1].getEntity() == e.entity && gameField[x+1][y+1].getEntity() == e.entity)) {
            doEnd(e);
        }
        if (x == 2 && y == 2 && (gameField[x][y].getEntity() == e.entity && gameField[x-1][y-1].getEntity() == e.entity && gameField[x-2][y-2].getEntity() == e.entity)) {
            doEnd(e);
        }//DIAGONALNE ODSPODA NAHORU
        if (x == 2 && y == 0 && (gameField[x][y].getEntity() == e.entity && gameField[x-1][y+1].getEntity() == e.entity && gameField[x-2][y+2].getEntity() == e.entity)) {
            doEnd(e);
        }
        if (x == 1 && y == 1 && (gameField[x][y].getEntity() == e.entity && gameField[x-1][y+1].getEntity() == e.entity && gameField[x+1][y-1].getEntity() == e.entity)) {
            doEnd(e);
        }
        if (x == 0 && y == 2 && (gameField[x][y].getEntity() == e.entity && gameField[x+1][y-1].getEntity() == e.entity && gameField[x+2][y-2].getEntity() == e.entity)) {
            doEnd(e);
        }
    }

    public void doEnd(EntityClass e){
        winner = e.entity;
        isWin = true;
        System.out.println("Konec hry");
        System.out.println("Vyhral " + winner);
        System.exit(0);
    }

    public int isEnd(Box[][] gameField){
        int counter = 0;
        for (int i = 0; i < Game.fieldSize; i++) {
            for (int j = 0; j < Game.fieldSize; j++) {
                if(gameField[i][j].isActive()){
                    counter++;
                }
            }
        }
        return counter;
    }

    public boolean gameEnd(Box[][] gameField, EntityClass e, int x, int y){
        if (isEnd(gameField) == Math.pow(Game.fieldSize, 2) && !isWin){
            System.out.println("Remiza");
            System.exit(0);
            return true;
        }
        setWin(e, gameField, x, y);
        return false;
    }

}
