
import java.util.Scanner;

public class Controller {
    private GameLogic gl = new GameLogic();
    private Ai ai = new Ai();
    private Scanner sc = new Scanner(System.in);


    public void newGame() {
        View.requestGameType();
        boolean playWithAi = (sc.nextInt() != 1);
        gl.drawFieldAndTurn();
        while (!gl.checkGameOver()) {
            makeTurn(false);
            if (playWithAi) {
                makeTurn(true);
            }
        }
    }

    public void makeTurn(boolean aiTurn) {
        boolean placed = false;
        while (!gl.checkGameOver() && !placed) {
            placed = gl.makeTurn(aiTurn ?
                    ai.makeTurn(gl.getField().getField()) :
                    sc.nextInt() - 1);
        }
    }
}
