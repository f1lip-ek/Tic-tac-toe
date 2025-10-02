import java.util.Scanner;

public class Game {

    private Box[][] hraciPole;
    public static int velikost = 3;
    private Player player;
    private AI ai;
    private boolean isPlaying;

    private int[] aiPole;

    private Scanner sc = new Scanner(System.in);

    public Game() {
        this.hraciPole = new Box[velikost][velikost];
        this.player = new Player();
        this.ai = new AI();
        this.isPlaying = false;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public void setHraciPole(){
        for (int i = 0; i < velikost; i++) {
            for (int j = 0; j < velikost; j++) {
                hraciPole[i][j] = new Box();
            }
        }
    }

    public void setPole(){
//        hraciPole[0][0].setJeAktivni(player);
//        hraciPole[0][1].setJeAktivni(player);
//        hraciPole[0][2].setJeAktivni(player);
//        hraciPole[1][0].setJeAktivni(player);
//        hraciPole[1][1].setJeAktivni(player);
//        hraciPole[1][2].setJeAktivni(player);
//        hraciPole[2][2].setJeAktivni(player);
//        hraciPole[2][0].setJeAktivni(player);
    }

    public void start(){
        setHraciPole();
        setPole();
        while(isPlaying){
            System.out.println(printHraciPole());
            setPrvek(player);
            setPrvek(ai);
        }
    }

    public String printHraciPole(){
        String pole = "";
        for (int i = 0; i < velikost; i++) {
            for (int j = 0; j < velikost; j++) {
                pole += hraciPole[i][j].toString();
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
                if (!hraciPole[x][y].isJeAktivni()) {
                    this.hraciPole[x][y].setJeAktivni(e);
                    break;
                } else {
                    System.out.println("Nejde, Zkus znovu\n");
                }
            }
        } else if (e == ai) {
            this.aiPole = ai.getMove();
            while(true){
                int i = 0;
                if(!hraciPole[aiPole[0]][aiPole[1]].isJeAktivni()){
                    this.hraciPole[aiPole[0]][aiPole[1]].setJeAktivni(e);
                    break;
                }else/* if (hraciPole[aiPole[0]][aiPole[1]].isJeAktivni())*/{
                    this.aiPole = ai.getMove();
                    System.out.println(i);
                }
                i++;
            }
        }
    }
}
