import java.io.FileNotFoundException;


public class recursiveMaze {
	public static void main(String[]args) throws FileNotFoundException, InterruptedException{
		Maze test = new Maze(9,9,'0','1');
		test.fillMaze();
		test.printMaze();
		System.out.println();
		test.traverseMaze(0, 0);
		test.printMaze();
	}
}
