
import java.util.Scanner;

public class Trees {
	static char[][] field = new char[6][7];
	static Boolean gameOver = false;
	
	public static void out(){
		for (int x = 0; x < field[0].length; x++) {
			System.out.print(" "+ x + " ");
		}
		for (int y = 0 ; y < field.length; y++){
		
			System.out.println();
	
			
			for (int x = 0; x < field[y].length; x++){
				System.out.print(" "+ field[y][x]+" ");
				
			}
		} 
	}
	public static void setUp() {
		for (int y = 0; y < field.length; y++){
			
			for (int x = 0; x < field[y].length; x++){
				field[y][x] = '.';
			}
		}
	}

	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		
		char turnOf ='X';
		setUp();
		out();
		while (!gameOver) {

			System.out.println("Player 1:");
			int coordinate = input.nextInt();
			
	//		 field[0][coordinate] = turnOf;
			Boolean coordinatePlaced = false;
			int y = field.length-1;
			while (!coordinatePlaced) {
				if (field[y][coordinate] == '.') {
					field[y][coordinate] = turnOf;
					coordinatePlaced = true;
				}
				else {
					y -= 1;
				}
			
			}
			 if (turnOf == 'X') {
				 turnOf ='O';
			 }
			 
			 else {
			 	turnOf = 'X';
			 
				 }
			if (coordinate == 9) {
				gameOver = true;
			}
			out();
				  
		}

	}

	
}

