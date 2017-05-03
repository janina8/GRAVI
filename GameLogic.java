public class GameLogic {

    private Field field = new Field();
    private Character turn ='X';

    private boolean win = false;
    private boolean stale = false;

    public boolean checkGameOver (){
        return win || stale;
    }


    public void newGame (){
        win = false;
        stale = false;
        turn = 'X';
        field = new Field();
        View.drawTurn(turn);
        View.drawField(field.getField());
    }
    public Field getField (){
        return field;
    }

    public boolean makeTurn(int x){
        int y = field.placeMark (x,turn);
        if (y != -1 ){
            if (checkStale ()){
                stale = true;
                View.drawStale();

            }
            if (checkWin(y,x)){
                win = true;
                View.drawWin(turn);
            }

            turn = (turn.equals('X')? 'O' : 'X');
            View.drawTurn(turn);
            View.drawField(field.getField());

            return true;
        }

        return false;
    }

    public boolean checkWin (int y, int x){
        return field.checkWin(y,x);
    }

    public boolean checkStale (){
        return !field.emptySpaceLeft();
    }

}
