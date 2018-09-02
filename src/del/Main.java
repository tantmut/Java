package del;

public class Main {
    public static void main(String[] args) {


        Game game = new Game(5,"Nazar", 4);

        SuperGame sgame = new SuperGame(game.a,"Bazar", game.c);

        game.printAandC();
        sgame.printAandC();

        gameOver(sgame);

        game.printAandC();
        sgame.printAandC();

    }

    public static void gameOver(Game game){
        game.setA(60);
        game.setC(50);
//        System.out.println(game.addTwoNumber(game.a, game.c));
    }
}
