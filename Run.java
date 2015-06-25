
public class Run {
	public static void main(String args[])
	{
		String[][] table = new String[3][3];
		for(int row = 0;row < 3;row++) {
			for(int col = 0;col < 3;col++) {
				if(row == 1 && col == 1) {
					table[row][col] = "O";
				}
				else {
					table[row][col] = " ";
				}
			}
		}
		int count = 0;
		Move move = new Move(table);
		move.createMove(move.table,0,0,"X");
		Move temp = move;;
		while(temp.firstchild != null) {
			count++;
			temp = temp.firstchild;
		}
		System.out.println("count = " + count);
		/*OX table = new OX();
		Player player = new Player();
		Bot bot = new Bot("x");
		table.setup();
		table.printTable();
		while(true) {
			player.playerTurn();
			table.setValue(player.getRow(),player.getColumn(), "o");
			table.printTable();
			if(table.checkWin("o")) {
				System.out.println("Win!!!");
				break;
			}
		}*/
	}
}
