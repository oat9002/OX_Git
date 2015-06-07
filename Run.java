
public class Run {
	public static void main(String args[])
	{
		OX start = new OX();
		start.setup();
		start.printTable();
		while(true) {
			start.playerTurn();
			start.printTable();
		}
	}
}
