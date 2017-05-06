package XOGame;

public class GameLogic {
    private Field field= new Field(6,7);
    private Character turn ='X';
    private boolean win = false;


    public boolean checkGameOver (){
        return win || field.checkStale();
    }

    public void drawFieldAndTurn (){
        View.drawTurn(turn);
        View.drawField(field);
    }

    public Field getField (){
        return field;
    }

    public boolean makeTurn(int x){
        int y = field.placeMark (x,turn);
        if (y != -1 ){


            if (field.checkStale ()){
                View.drawStale();
            }
            if (field.checkWin(y,x)){
                win = true;
                View.drawWin(turn);
            }



            turn = (turn.equals('X')? 'O' : 'X');
            drawFieldAndTurn();
            return true;
        }
        return false;
    }


}
