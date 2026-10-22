package observer;

import entities.Board;

public class PrintBoardObserver implements BoardObserver{

	@Override
	public void update(Board board){
	    board.print();
	}
}