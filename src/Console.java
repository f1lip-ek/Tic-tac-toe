public class Console {

    private Game game = new Game();

    public void print(String text){
        System.out.println(text);
    }

    public void start(){
        game.setPlaying(true);
        game.start();
    }

}
