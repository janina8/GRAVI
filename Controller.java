package XOGame;

import java.util.Scanner;

public class Controller {
    private GameLogic gl = new GameLogic();
    private Ai ai = new Ai();
    private Scanner sc = new Scanner(System.in);


    public void newGame (){
        View.requestGameType();
        boolean playWithAi = (sc.nextInt() != 1 );
        boolean placed = false;
        gl.drawFieldAndTurn();
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
