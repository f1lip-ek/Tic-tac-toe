public class Console {

    private final Game game = new Game();

    public void start(){
        game.getEndChecker().setPlaying(true);
        game.start();
    }

}
