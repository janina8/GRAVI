import java.util.Random;


public class Ai {
    Random r = new Random();

    public int makeTurn(char[][]field){
        return r.nextInt(field[0].length)+1;
    }
}
