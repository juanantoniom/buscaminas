package buscaminas;

import buscaminas.model.Board;
import buscaminas.services.BoardService;

public class buscaminas {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Board miBoard = new Board();
				
		boolean quitGame = false;
		
		BoardService.loadGame( 12 , miBoard );
		
		while(!quitGame) { //while quitGame be false
						
			
			
			boolean mineTouch = BoardService.show(miBoard); //show board on console
			
			if(mineTouch) {
				System.out.println(" Has tocado una mina ");
				
				System.out.println(" Fin del juego ");
				
				quitGame = true;
				
			}else {
				
				miBoard.setMiSelect(BoardService.chooseUser());//we collect x and y from the user
				
								
			}
										
		}
		
		
	}
				
}
