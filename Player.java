import java.util.Scanner;


public class Player {
	int row,col;
	
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
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getColumn()
	{
		return col;
	}
}
