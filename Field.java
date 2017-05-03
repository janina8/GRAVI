
public class Field {

    private char[][] field = createField(6, 7);

    public char[][] getField() {
        return this.field;
    }

    private char[][] createField(int height, int width) {

        char[][] newArray = new char[height][width];


        for (int y = 0; y < newArray.length; y++) {
            for (int x = 0; x < newArray[y].length; x++) {
                newArray[y][x] = '.';
            }
        }

        return newArray;
    }

    public boolean emptySpaceLeft(){
        for (char [] y :field){
            for (char x : y){
                if (x == '.') {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean checkWin(int y, int x) {
        return
                //E-W
                checkDirection(y, x, 0, -1)
                        //S-N
                        || checkDirection(y, x, -1, 0)
                        //SE-NW
                        || checkDirection(y, x, -1, -1)
                        //SW-NE
                        || checkDirection(y, x, -1, 1);
    }


    public boolean checkDirection(int y, int x, int yDir, int xDir) {
        char[][] field = this.field;


        int cY;
        int cX;
        int sequence = 0;
        for (int i = -4; i < 5; i++) {
            cY = i * yDir + y;
            cX = i * xDir + x;
            if (yxInField(cY, cX, field)) {
                if (field[cY][cX] == field[y][x]) {
                    sequence += 1;
                    if (sequence == 4) {
                        return true;
                    }
                } else {
                    sequence = 0;
                }
            }
        }


        return false;

    }


    private boolean yxInField(int y, int x, char[][] field) {
        return field != null
                && y >= 0
                && x >= 0
                && y < field.length
                && field[y] != null
                && x < field[y].length;
    }

    public int placeMark(int x, char mark) {

        int y = 0;
        while (yxInField(y, x, field)) {
            if (field[y][x] =='.'){
                field[y][x] = mark;
                return y;
            }
            y++;
        }
        return -1;
    }


}
