package pkg;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Pair{
	int row;
	int col;
	
	Pair(int row, int col){
		this.row = row;
		this.col = col;
	}
}

public class Game2048 {
	public static void main(String[] args) {
		Scanner sb = new Scanner(System.in); String dir;
		Board b = new Board();
		Game g = new Game(b);
		g.start();
		g.displayGame();
		while(1>0){
			dir = sb.nextLine();
			if(dir.equals("l"))
				g.moveLeft();
			else if(dir.equals("r"))
				g.moveRight();
			else if(dir.equals("u"))
				g.moveUp();
			else if(dir.equals("d"))
				g.moveDown();
			g.displayGame();
		}
	}
}
