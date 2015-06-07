import java.util.Scanner;;

public class OX {
	
	String[][] table = new String[5][5];
	private Scanner input; 
	
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
		int  x,y = 0;
		input = new Scanner(System.in);
		while(true) {
			System.out.print("Insert O position : ");
			x = input.nextInt();
			y = input.nextInt();
			if(x <= 3 && y <= 3 && x > 0 && y > 0) {
				break;
			}
		}
		if(x == 1) {
			x -= 1;
		}
		else if(x == 3) {
			x += 1;
		}
		if(y == 1) {
			y -= 1;
		}
		else if(y == 3) {
			y += 1;
		}
		table[y][x] = "o";
	}
}
