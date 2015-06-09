import java.util.Scanner;;

public class OX {
	
	String[][] table = new String[5][5];
	int row;
	int col;
	
	public void setup()
	{
		drawTable();
	}
	
	public void drawTable()
	{
		for(int row = 0;row < table.length;row++) {
			for(int col = 0;col < table[row].length;col++) {
				if(row % 2 == 0) {
					if(col % 2 != 0) {
						table[row][col] = "|";
					}
					else {
						table[row][col] = " ";
					}
				}
				else {
					table[row][col] = "-";
				}
			}
		}
	}
	
	public void printTable()
	{
		for(int row = 0;row < table.length;row++) {
			for(int col = 0;col < table[row].length;col++) {
				System.out.print(table[row][col]);
			}
			System.out.println();
		}
	}
	
	public void playerTurn() 
	{
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.print("Insert O position : ");
			row = input.nextInt();
			col = input.nextInt();
			if(row <= 3 && col <= 3 && row > 0 && col > 0) {
				break;
			}
		}
		setValue(row, col, "o");
	}
	
	public void setValue(int row,int col,String str) 
	{
		if(row == 1) {
			row -= 1;
		}
		else if(row == 3) {
			row += 1;
		}
		if(col == 1) {
			col -= 1;
		}
		else if(col == 3) {
			col += 1;
		}
		table[row][col] = str;
	}
	
	public boolean checkWin(String str) 
	{
		int score = 1;
		if(row == 1) {
			row -= 1;
		}
		else if(row == 3) {
			row += 1;
		}
		if(col == 1) {
			col -= 1;
		}
		else if(col == 3) {
			col += 1;
		}
		/////////////////////
		// Win by Vertical //
		/////////////////////
		int row_t = row;
		int col_t = col;
		while(row - 2 >= 0) {
			if(table[row - 2][col].equals(str)) {
				score++;
			}
			row -= 2;
		}
		if(score == 3) {
			return true;
		}
		else {
			row = row_t;
		}
		while(row + 2 <= table.length) {
			if(table[row + 2][col].equals(str)) {
				score++;
			}
			row += 2;
		}
		if(score == 3) {
			return true;
		}
		else {
			score = 1;
			row = row_t;
		}
		////////////////////////
		//  Win by Horizontal //
		////////////////////////
		while(col - 2 >= 0) {
			if(table[row][col - 2].equals(str)) {
				score++;
			}
			col -= 2;
		}
		if(score == 3) {
			return true;
		}
		else {
			col = col_t;
		}
		while(col + 2 <= table[row].length) {
			if(table[row][col + 2].equals(str)) {
				score++;
			}
			col += 2;
		}
		if(score == 3) {
			return true;
		}
		else {
			score = 1;
			col = col_t;
		}
		/////////////////////
		// Win by Diagonal //
		/////////////////////
		while(row - 2 >= 0 && col - 2 >= 0) {
			if(table[row - 2][col - 2].equals(str)) {
				score++;
			}
			row -= 2;
			col -= 2;
		}
		if(score == 3) {
			return true;
		}
		else {
			row = row_t;
			col = col_t;
		}
		while(row + 2 <= table.length && col + 2 <= table[row].length) {
			if(table[row + 2][col + 2].equals(str)) {
				score++;
			}
			row += 2;
			col += 2;
		}
		if(score == 3) {
			return true;
		}
		else {
			row = row_t;
			col = col_t;
			score = 1;
		}
		while(row - 2 >= 0 && col + 2 <= table[row].length) {
			if(table[row - 2][col + 2].equals(str)) {
				score++;
			}
			row -= 2;
			col += 2;
		}
		if(score == 3) {
			return true;
		}
		else {
			row = row_t;
			col = col_t;
		}
		while(row + 2 <= table.length && col - 2 >= 0) {
			if(table[row + 2][col - 2].equals(str)) {
				score++;
			}
			row += 2;
			col -= 2;
		}
		if(score == 3) {
			return true;
		}
		else {
			row = row_t;
			col = col_t;
		}
		return false;
	}
}
