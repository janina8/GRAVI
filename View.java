

public class View {

    public static void drawField (Field f) {
        char[][] field = f.getField();
        for (int y=field.length-1; y>=0;y--)
        {
            System.out.println();
            for (char x : field[y] ){
                System.out.print (" "+x);
            }
        }
        System.out.println();
        for (int x=1; x<= field[0].length;x++){
            System.out.print (" "+x);
        }
        System.out.println();
    }

    public static void drawTurn(char turn){
        System.out.println ("Turn of "+turn);
    }

    public static void drawWin (char turn){
        System.out.println ("Player "+turn+" WINS !!!!!111111111");
    }

    public static void drawStale (){
        System.out.println ("Stale");
    }

    public static void requestGameType () {
        System.out.println ("Press 1 to play PvP, Press any other digit to play PvAi");
    }
}
