package pkg;

public class Board{
	int[][] board;
	
	Board(){
		board = new int[4][4];
		
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				board[i][j] = 0;
			}
		}
	}
	
	public void setValue(int row, int col, int value){
		board[row][col] = value;
	}
	
	public boolean adjustUp(int col){
		int row=0, rowtemp, flag=0;
		while(row < 3){
			rowtemp = row;
			while(rowtemp <=3 && board[rowtemp][col] != 0)
				rowtemp++;
			for(int r=rowtemp;r<3;r++){
				board[r][col] = board[r+1][col];
				flag=1;
				board[r+1][col] = 0;
			}
			if(board[rowtemp][col] == 0)
				break;
			row = rowtemp;
		}
		if(flag==1)
			return true;
		return false;
	}
	
	/*public boolean adjustDown(int col){
		int row=3, rowtemp, flag=0;
		while(row > 0){
			rowtemp = row;
			while(rowtemp >=0 && board[rowtemp][col] != 0)
				rowtemp--;
			for(int r=rowtemp;r>0;r--){
				board[r][col] = board[r-1][col];
				flag=1;
				board[r-1][col] = 0;
			}
			if(board[rowtemp][col] == 0)
				break;
			row = rowtemp;
		}
		if(flag==1)
			return true;
		return false;
	}*/
	
	public boolean adjustDown(int col){
		int row=3, rowtemp, temp;
		while(row>0){
			if(board[row][col] != 0){
				row--; continue;
			}
			rowtemp = row-1;
			while(rowtemp >= 0){
				if(board[rowtemp][col] != 0)
					break;
				rowtemp--;
			}
			if(rowtemp >= 0){
				temp = board[row][col];
				board[row][col] = board[rowtemp][col];
				board[rowtemp][col] = temp;
			}
			row--;
		}
		return true;
	}
	
	public boolean adjustLeft(int row){
		int col=0, coltemp, temp;
		while(col<3){
			if(board[row][col] != 0){
				col++; continue;
			}
			coltemp = col+1;
			while(coltemp <= 3){
				if(board[row][coltemp] != 0)
					break;
				coltemp++;
			}
			if(coltemp <= 3){
				temp = board[row][col];
				board[row][col] = board[row][coltemp];
				board[row][coltemp] = temp;
			}
			col++;
		}
		return true;
	}
	
	public boolean adjustRight(int row){
		int col=3, coltemp, temp;
		while(col>0){
			if(board[row][col] != 0){
				col--; continue;
			}
			coltemp = col-1;
			while(coltemp >= 0){
				if(board[row][coltemp] != 0)
					break;
				coltemp--;
			}
			if(coltemp >= 0){
				temp = board[row][col];
				board[row][col] = board[row][coltemp];
				board[row][coltemp] = temp;
			}
			col--;
		}
		return true;
	}
	
	public boolean check2048(int row, int col){
		if(board[row][col] == 2048)
			return true;
		return false;
	}
	
	public boolean checkFull(){
		int flag = 0;
		for(int row=0;row<4;row++){
			for(int col=0;col<4;col++){
				if(board[row][col] == 0){
					flag = 1;
					break;
				}
			}
		}
		if(flag==0)
			return true;
		return false;
	}
	
	public void display(){
		for(int row=0;row<4;row++){
			for(int col=0;col<4;col++){
				if(board[row][col] == 0)
					System.out.print(".");
				else
					System.out.print(board[row][col]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
