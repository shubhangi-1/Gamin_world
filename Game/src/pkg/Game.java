package pkg;

import java.util.ArrayList;
import java.util.Random;

public class Game{
	Board b;
	
	Game(Board b){
		this.b = b;
	}
	
	public void swap(int[] index, int ele, int last){
		int temp = index[last];
		index[last] = index[ele];
		index[ele] = temp;
	}
	
	public void start(){
		int[] index = {0,1,2,3};
		Random r = new Random();
		int random_row1 = r.nextInt(3);
		int random_col1 = r.nextInt(3);
		
		b.setValue(random_row1, random_col1, 2);
		
		int random_row2 = r.nextInt(3);
		int random_col2 = r.nextInt(3);
		
		if(random_row1 == random_row2){
			if(random_col1 == random_col2){
				swap(index, random_col2, 3);
				random_col2 = r.nextInt(2);
			}
		}
		
		b.setValue(random_row2, random_col2, 2);
		
	}
	
	public boolean moveUp(){
        int row, col, index, currElem, flag=0;
		
		for(col=0; col<4; col++){
			row=0;
			while(row<3){
				currElem = b.board[row][col];
				if(currElem == 0){
					row++;
					continue;
				}
				index = row+1;
				while(index<=3){
					if(b.board[row][index] == 0){
						index++;
						continue;
					}
					if(b.board[row][index] == currElem){
						b.board[row][col] = 2*currElem;
						b.board[row][index] = 0;
					}
					break;
				}
				row++;
			}
			b.adjustUp(col);
			if(checkWinCondition(row)==true)
			    return true;
		}
		postMove();
		return true;
	}
	
	public boolean moveDown(){
        int row, col, index, currElem, flag=0;
		
		for(col=0; col<4; col++){
			row=3;
			while(row>0){
				currElem = b.board[row][col];
				if(currElem == 0){
					row--;
					continue;
				}
				index = row-1;
				while(index>=0){
					if(b.board[row][index] == 0){
						index--;
						continue;
					}
					if(b.board[row][index] == currElem){
						b.board[row][col] = 2*currElem;
						b.board[row][index] = 0;
					}
					break;
				}
				row--;
			}
			b.adjustDown(col);
			if(checkWinCondition(row)==true)
			    return true;
		}
		postMove();
		return true;
	}
	
	public boolean moveLeft(){
        int row, col, index, currElem, flag=0;
		
		for(row=0; row<4; row++){
			col=0;
			while(col<3){
				currElem = b.board[row][col];
				if(currElem == 0){
					col++;
					continue;
				}
				index = col+1;
				while(index<=3){
					if(b.board[row][index] == 0){
						index++;
						continue;
					}
					if(b.board[row][index] == currElem){
						b.board[row][col] = 2*currElem;
						b.board[row][index] = 0;
					}
					break;
				}
				col++;
			}
			//b.display();
			b.adjustLeft(row);
			//b.display();
			if(checkWinCondition(row)==true)
			    return true;
		}
		postMove();
		return true;
	}
	
	public boolean moveRight(){
		int row, col, index, currElem, flag=0;
		
		for(row=0; row<4; row++){
			col=3;
			while(col>0){
				currElem = b.board[row][col];
				if(currElem == 0){
					col--;
					continue;
				}
				index = col-1;
				while(index>=0){
					if(b.board[row][index] == 0){
						index--;
						continue;
					}
					if(b.board[row][index] == currElem){
						b.board[row][col] = 2*currElem;
						b.board[row][index] = 0;
					}
					break;
				}
				col--;
			}
			b.adjustRight(row);
			if(checkWinCondition(row)==true)
			    return true;
		}
		postMove();
		return true;
	}
	
	public void postMove(){
		ArrayList<Pair> emptyCells = new ArrayList<>(); 
		Random r = new Random();
		for(int row=0;row<4;row++){
			for(int col=0;col<4;col++){
				if(b.board[row][col] == 0)
					emptyCells.add(new Pair(row, col));
			}
		}
		int index = r.nextInt(emptyCells.size());
		int row = emptyCells.get(index).row;
		int col = emptyCells.get(index).col;
		int val = (r.nextInt()%2 == 0)? 2: 4;
		
		b.board[row][col] = val;
	}
	
	public boolean checkWinCondition(int row){
		for(int col=0;col<4;col++){
			if(b.check2048(row, col) == true){
				System.out.println("Winner");
				return true;
			}
		}
		return false;
	}
	
	public boolean checkLoseCondition(){
		if(b.checkFull()==true)
			return true;
		return false;
	}
	
	public void displayGame(){
		b.display();
		System.out.println();
	}
	
}