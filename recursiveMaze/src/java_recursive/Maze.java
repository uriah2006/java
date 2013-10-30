package java_recursive;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Maze {
	private int			row, col;
	private char		wall;
	private char[][]	map	= new char[row][col];
	
	public Maze(int row, int col, char wall, char space) {
		/*
		 * This constructor stores the parameters into the private data members
		 * and allocates a character array with the number of rows and columns
		 * indicated. The wall and path characters can NOT be either a ‘3’ or
		 * ‘7’
		 */
		this.row = row;
		this.col = col;
		this.wall = wall;
		map = new char[row][col];
	}
	
	public void fillMaze() throws FileNotFoundException {
		/*
		 * This method prompts the user for the name of an input data file, and
		 * reads the contents of the file into the maze array. The contents of
		 * the file will be a series of characters, separated by spaces.For
		 * example, the following is a 4x4 maze where spaces are X and walls are
		 * P.
		 */

		// X P P P
		// X X X P
		// X P X P
		// P P X X
		Scanner input = new Scanner(System.in);
		String choice;
		System.out.print("what file do you want to open to fill your maze: ");
		choice = input.next();
		Scanner mazeFile = new Scanner(new FileReader(choice));
		for (int r = 0; r < (row); r++) {
			for (int c = 0; c < (col); c++) {
				map[r][c] = (mazeFile.next()).charAt(0);
			}
		}
		mazeFile.close();
		input.close();
	}
	
	public void printMaze() {
		/*
		 * the contents of the maze array, one row per line.
		 */
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	public Boolean traverseMaze(int currentr, int currentc)
			throws InterruptedException {
		
		/*
		 * traverses the maze. Cells visited should have the character ‘3’
		 * stored in them, and the correct path should contain the character ‘7’
		 * 
		 * receives two integer values, a “row/column” pair that represents your
		 * current location in the maze. When the method is called for the first
		 * time it will receive the pair [0,0]. The traversal is successful when
		 * the end of the array is reached, which is when the method receives
		 * the pair [14,14]. When the end of the maze is reached, your method
		 * should return TRUE. It should return FALSE, if a move runs into a
		 * wall, a square that has already been visited, or the row/column pair
		 * outside the bounds of the array. AS we traverse the maze, we mark
		 * each cell visited, by using a ‘3’, finally, the correct path through
		 * your maze, should be marked by storing a ‘7’ in the array elements. A
		 * sample maze is:
		 */
		boolean rightWay = false;
		double encounter;
		int sent = 2;
		if ((currentr == row - 1) && (currentc == col - 1)) {
			// /////////////////////////////////////for/////fun////////////////////////////////////
			Scanner input = new Scanner(System.in);
			System.out.println("OH GOD!!! you where attacked by Chuck Norris");
			System.out
					.println("you where hit with a critical round house kick and you are now DEAD!!");
			System.out
					.println("send me a check for $20 to get your map to your dead body");
			System.out
					.println("did you send it?: 1 for yes or 2 for no (try other numbers to)");
			while (sent != 1) {
				sent = input.nextInt();
				if (sent == 1) {
					System.out.println("here is your map");
					rightWay = true;
				}
				else if (sent == 2) {
					System.out.println("ok i can wait.....");
					Thread.sleep(6000);
					System.out.println("how about now?: 1 for yes or 2 for no");
				}
				else {
					System.out.println("this is for being a smart #%* ");
					map[-1][-1] = 1;
				}
				
			}
			input.close();
			// /////////////////////////////////////for/////fun////////////////////////////////////
		}
		if ((currentc >= 0) && (currentc < col) && (currentr >= 0)
				&& (currentr < row) && (map[currentr][currentc] != '3')
				&& rightWay == false) {
			map[currentr][currentc] = '3';
			
			// ////////////////////////////for//fun//////////////////////////////
			
			encounter = (Math.random()) * 100;
			if (encounter > 85) {
				this.printMaze();
				String bad = "bat";
				int choice = 2;
				Scanner input = new Scanner(System.in);
				if (encounter > 85 && encounter < 90)
					bad = "pikachu";
				if (encounter > 90 && encounter < 94)
					bad = "chocobo";
				if (encounter > 95 && encounter < 100)
					bad = "Godzilla";
				
				System.out.println("you where attacked by " + bad);
				System.out.println("enter 1 for attack");
				System.out.println("enter 2 for run");
				choice = input.nextInt();
				if (choice == 1) {
					System.out.println("yay you killed " + bad
							+ " and you move on");
				}
				else {
					System.out.println("you run from the " + bad
							+ ", here is your map out");
					rightWay = true;
				}
				input.close();
			}
			// ///////////////////////////for//fun/////////////////////////////////////////
			// down
			if ((currentr + 1 < row) && (map[currentr + 1][currentc] != wall)
					&& (rightWay == false)) {
				rightWay = traverseMaze(currentr + 1, currentc);
				
			}
			// left
			if ((currentc - 1 >= 0) && (map[currentr][currentc - 1] != wall)
					&& (rightWay == false)) {
				rightWay = traverseMaze(currentr, currentc - 1);
				
			}
			// up
			if ((currentr - 1 >= 0) && (map[currentr - 1][currentc] != wall)
					&& (rightWay == false)) {
				rightWay = traverseMaze(currentr - 1, currentc);
			}
			// right
			if ((currentc + 1 < col) && (map[currentr][currentc + 1] != wall)
					&& (rightWay == false)) {
				rightWay = traverseMaze(currentr, currentc + 1);
				
			}
		}
		// System.out.print(rightWay);
		if (rightWay == true)
			map[currentr][currentc] = '7';
		return rightWay;
	}
}
