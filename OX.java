import java.util.Scanner;;

public class OX {
	
	String[][] table = new String[3][3];
	int row;
	int col;
	
	public void setup()
	{
		for(int row = 0;row < table.length;row++) {
			for(int col = 0;col < table[row].length;col++) {
				table[row][col] = " ";
			}
		}
	}
	
	public void printTable()
	{
		int row_table = 0;
		int col_table = 0;
		for(int row = 0;row < 5;row++) {
			for(int col = 0;col < 5;col++) {
				if(row % 2 != 0) {
					System.out.print("-");
				}
				else {
					if(col % 2 != 0) {
						System.out.print("|");
					}
					else {
						System.out.print(table[row_table][col_table]);
						col_table++;
					}
				}
			}
			if(row % 2 == 0) {
				row_table++;
				col_table = 0;
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
		row -= 1;
		col -= 1;
		table[row][col] = "o";
	}
	
	public boolean checkWin(String str) 
	{
		int score = 1;
		/////////////////////
		// Win by Vertical //
		/////////////////////
		int row_t = row;
		int col_t = col;
		while(row - 1 >= 0) {
			if(table[row - 1][col].equals(str)) {
				score++;
			}
			row -= 1;
		}
		if(score == 3) {
			return true;
		}
		else {
			row = row_t;
		}
		while(row + 1 < table.length) {
			if(table[row + 1][col].equals(str)) {
				score++;
			}
			row += 1;
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
		while(col - 1 >= 0) {
			if(table[row][col - 1].equals(str)) {
				score++;
			}
			col -= 1;
		}
		if(score == 3) {
			return true;
		}
		else {
			col = col_t;
		}
		while(col + 1 < table[row].length) {
			if(table[row][col + 1].equals(str)) {
				score++;
			}
			col += 1;
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
		while(row - 1 >= 0 && col - 1 >= 0) {
			if(table[row - 1][col - 1].equals(str)) {
				score++;
			}
			row -= 1;
			col -= 1;
		}
		if(score == 3) {
			return true;
		}
		else {
			row = row_t;
			col = col_t;
		}
		while(row + 1 < table.length && col + 1 < table[row].length) {
			if(table[row + 1][col + 1].equals(str)) {
				score++;
			}
			row += 1;
			col += 1;
		}
		if(score == 3) {
			return true;
		}
		else {
			row = row_t;
			col = col_t;
			score = 1;
		}
		while(row - 1 >= 0 && col + 1 < table[row].length) {
			if(table[row - 1][col + 1].equals(str)) {
				score++;
			}
			row -= 1;
			col += 1;
		}
		if(score == 3) {
			return true;
		}
		else {
			row = row_t;
			col = col_t;
		}
		while(row + 1 < table.length && col - 1 >= 0) {
			if(table[row + 1][col - 1].equals(str)) {
				score++;
			}
			row += 1;
			col -= 1;
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
