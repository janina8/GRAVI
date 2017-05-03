public class GameLogic {
    Field field = new Field();
    Output out = new Output();
    boolean won = false;

    private Character turn ='X';


    public void newGame (){
        turn = 'X';
        this.won = false;
        field.clearField();
        out.drawField(field.getField());
    }

    public boolean makeNewTurn(int x){

     
        String turnResult = field.placeMark(x,turn);
        if ( turnResult.equals("placed")) {
          
            if (turn.equals('X')) {
                turn = 'O';
            } else if (turn.equals('O')) {
                turn = 'X';
            }


            out.drawTurn(turn);
            out.drawField(field.getField());
            return true;
        } else if (turnResult.equals("win")) {

            this.won = true;
            out.drawTurn(turn);
            out.drawField(field.getField());
            out.drawWin(turn);
            return true;
        } else {

            out.wrongPlace ();
            return false;
        }
    }

    public boolean getWon () {
        return this.won;
    }
}
