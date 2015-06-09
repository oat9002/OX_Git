import java.util.Scanner;;

public class OX {
	
	char[][] table = new char[3][3];
	
	public void setup()
	{
		initTable();
		drawTable();
	}
	
	public void initTable()
	{
		for(int row = 0;row < table.length;row++) {
			for(int col = 0;col < table[row].length;col++) {
				table[row][col] = ' ';
			}
		}
	}
	
	public void drawTable()
	{
		for(int row = 0;row < table.length;row++) {
			for(int col = 0;col < table[row].length;col++) {
				System.out.print(table[row][col]);
			}
			System.out.println();
			System.out.println("-----");
		}
	}
	
	public void playerTurn() 
	{
		int  x,y = 0;
		Scanner input = new Scanner(System.in);
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
		
		if (table[x][y]==' ')
		{
			table[x][y] = 'O';
		}
	}
}
