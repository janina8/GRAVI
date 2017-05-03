import java.util.Scanner;

public class Controller {

    GameLogic gl = new GameLogic();
    Ai ai = new Ai();
    Scanner sc = new Scanner(System.in);

    Controller (){
        newGame();
    }

    public void newGame (){
        View.requestGameType();

        boolean playWithAi = (sc.nextInt() != 1 );
        boolean placed = false;
        gl.newGame();
        while (!gl.checkGameOver()){
            //human turn
            placed = false;
            while (!gl.checkGameOver() && !placed){
                placed = gl.makeTurn(sc.nextInt()-1);
            }

            //ai turn
            placed = false;
            while (playWithAi && !gl.checkGameOver() && !placed) {
                placed = gl.makeTurn(ai.makeTurn(gl.getField().getField()));
            }
        }
    }
}
