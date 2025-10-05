import java.util.Scanner;

public class Game {

    private final Box[][] gameField;
    public static int fieldSize = 3;
    private final Player player;
    private final AI ai;
    private final EndChecker endChecker;

    private Scanner sc;

    public Game() {
        this.endChecker = new EndChecker();
        this.gameField = new Box[fieldSize][fieldSize];
        this.player = new Player();
        this.ai = new AI();
        this.sc = new Scanner(System.in);
    }

    public EndChecker getEndChecker(){
        return this.endChecker;
    }

    public void setHraciPole(){
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                gameField[i][j] = new Box();
            }
        }
    }

    public void setPole(){
        gameField[0][0].setJeAktivni(player);
        gameField[0][1].setJeAktivni(player);
        gameField[0][2].setJeAktivni(player);
        gameField[1][0].setJeAktivni(player);
        gameField[1][1].setJeAktivni(player);
        gameField[1][2].setJeAktivni(player);
        gameField[2][2].setJeAktivni(player);
        gameField[2][0].setJeAktivni(player);
    }

    public void start(){
        setHraciPole();
        //setPole();
        while(endChecker.isPlaying()){
            System.out.println(printHraciPole());
            setPrvek(player);
            setPrvek(ai);
        }
    }

    public String printHraciPole(){
        String pole = "";
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                pole += gameField[i][j].toString();
            }
            pole += "\n";
        }
        return pole;
    }

    public void setPrvek(Entita e){
        if(e == player){
            while(true){
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                if (!gameField[x][y].isJeAktivni()) {
                    this.gameField[x][y].setJeAktivni(e);
                    endChecker.gameEnd(gameField, e, x, y);
                    break;
                } else {
                    System.out.println("Nejde, Zkus znovu\n");
                }
            }
        } else if (e == ai) {
            int[] aiPole = ai.getMove();
            int i = 1;
            while(/*!endChecker.gameEnd(gameField, e, aiPole[0], aiPole[1])*/true){
                if(!gameField[aiPole[0]][aiPole[1]].isJeAktivni()){
                    this.gameField[aiPole[0]][aiPole[1]].setJeAktivni(e);
                    break;
                }else /*if (hraciPole[aiPole[0]][aiPole[1]].isJeAktivni())*/{
                    aiPole = ai.getMove();
                    //System.out.print("\n"+ i + "\n\n");
                    i++;
                }
            }
            endChecker.gameEnd(gameField, e, aiPole[0], aiPole[1]);
        }
    }


}
