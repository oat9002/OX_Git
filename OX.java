
public class OX {
	
	String[][] table = new String[5][5]; 
	
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
}
