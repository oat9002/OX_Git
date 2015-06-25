 
public class Move {
	String[][] table = new String[3][3];
	int heuristicVal;
	Move firstchild;
	Move nextSibling;
	
	public Move(String[][] table)
	{
		this.table = new String(table);
		heuristicVal = getHeuristic(this.table);
		firstchild = null;
		nextSibling = null;
	}
	
	public void createMove(Move node,int row,int col,String str)
	{
		while(row < 3) {
			while(col < 3) {
				if(node.table[row][col].equals(" ")) {
					Move move = new Move(node.table);
					move.setMove(move.table,row,col,str);
					if(isEmpty(node.firstchild)) {
						node.firstchild = move;
						if(str.equals("X")) {
							createMove(move,row,col,"O");
						}
						else if(str.equals("O")) {
							createMove(move,row,col,"X");
						}
					}
					else {
						node.nextSibling = move;
						if(str.equals("X")) {
							createMove(move,row,col,"O");
						}
						else if(str.equals("O")) {
							createMove(move,row,col,"X");
						}
					}
				}
				col++;
			}
			col = 0;
			row++;
		}
	}
	
	public boolean isEmpty(Move move)
	{
		if(move == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setMove(String[][] table,int row,int col,String str)
	{
		this.table = table;
		this.table[row][col] = str;
		heuristicVal = getHeuristic(table);
	}
	
	public int getHeuristic(String[][] table)
	{
		// X is bot  O is player
		int value = 0;
		int subVal = 0; //subVal = x-o

		////////////////////
		//Horizontal check//
		////////////////////
		for(int row=0;row<3;row++) 
		{
			subVal = 0;
			for(int col=0;col<3;col++)
			{
				if(table[row][col].equals("X"))
				{
					subVal++;
				}
				if(table[row][col].equals("O"))
				{
					subVal--;
				}
			}
			switch (subVal)
			{
				case 3 :
					return 99; // bot win
				case -3 :
					return -99; // player win
				case 2 :
					value += 1; // 1 move and bot win
					break;
				case -2 :
					value -= 1; // 1 move and player win
					break;
				default :
					break;
			}
		}

		//////////////////
		//Vertical check//
		//////////////////
		for(int col=0;col<3;col++)
		{
			subVal = 0;
			for(int row=0;row<3;row++)
					{
				if(table[row][col].equals("X"))
				{
					subVal++;
				}
				if(table[row][col].equals("O"))
				{
					subVal--;
				}
			}
			switch (subVal)
			{
				case 3 :
					return 99; // bot win
				case -3 :
					return -99; // player win
				case 2 :
					value += 1; // 1 move and bot win
					break;
				case -2 :
					value -= 1; // 1 move and player win
					break;
				default :
					break;
			}
		}
		//////////////////
		//Diagonal check//	(\)
		//////////////////
		subVal = 0;
		if(table[0][0].equals("X")) subVal++;
		if(table[0][0].equals("O")) subVal--;
		if(table[1][1].equals("X")) subVal++;
		if(table[1][1].equals("O")) subVal--;
		if(table[2][2].equals("X")) subVal++;
		if(table[2][2].equals("O")) subVal--;

		switch (subVal)
		{
			case 3 :
				return 99; // bot win
			case -3 :
				return -99; // player win
			case 2 :
				value += 1; // 1 move and bot win
				break;
			case -2 :
				value -= 1; // 1 move and player win
				break;
			default :
				break;
		}

		//////////////////
		//Diagonal check//	(/)
		//////////////////
		subVal = 0;
		if(table[2][0].equals("X")) subVal++;
		if(table[2][0].equals("O")) subVal--;
		if(table[1][1].equals("X")) subVal++;
		if(table[1][1].equals("O")) subVal--;
		if(table[0][2].equals("X")) subVal++;
		if(table[0][2].equals("O")) subVal--;

		switch (subVal)
		{
			case 3 :
				return 99; // bot win
			case -3 :
				return -99; // player win
			case 2 :
				value += 1; // 1 move and bot win
				break;
			case -2 :
				value -= 1; // 1 move and player win
				break;
			default :
				break;
		}
		return value;
	}
}
