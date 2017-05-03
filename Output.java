public class Output {

    public void drawField (char[][] field){
     
        for (int y=field.length-1; y>=0;y--)


        {
            System.out.println();
            for (char x : field[y] ){
                System.out.print (" "+x);
            }
        }
    }

    public void drawTurn(char turn){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println ("Turn of "+turn);
    }

    public void wrongPlace (){
        System.out.println ("error");
    }

    public void drawWin (char turn){
        System.out.println ("Player "+turn+" WINS!");
    }
}
