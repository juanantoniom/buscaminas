package buscaminas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import buscaminas.model.Board;
import buscaminas.model.Mina;
import buscaminas.model.UserSelect;

public class BoardService {
	
	public static void loadGame(int nMinas , Board miBoard ) {
		
		
		//We start the user's position at -1 to start the game without any position set by the user
		UserSelect userSelect = miBoard.getMiSelect();
		
		userSelect.setFila(-1);
		userSelect.setColumna(-1);
		
		miBoard.setMiSelect(userSelect);
		
		
		
		
		
		//We load the mines on the Board and set the mine in row and column
		List<Mina> listaMina = new ArrayList<Mina>();
				
		
		for(int i = 1 ; i <= nMinas ; i++) {
			Mina miMina = new Mina();
			
			miMina.setFila((int)(Math.random()*8+1));
			miMina.setColumna((int)(Math.random()*8+1));
			
			listaMina.add(miMina);
		}
		
		miBoard.setListaMina(listaMina);
		
		
	}

	public static boolean show(Board miBoard) {
				
		boolean mineTouch = false;
		//get UserSelect object
		UserSelect userSelect = miBoard.getMiSelect();
		
		for(int i = 0 ; i < 8 ; i++ ) {
			
			for(int j = 0 ; j < 8 ; j++) {
				
				
				
				if(i == userSelect.getFila() && j == userSelect.getColumna() ) {
					
					//if the checkMine function returns true we have stepped on the mine
					if( BoardService.checkMine( i , j , miBoard.getListaMina() )) {
						
						System.out.print(" O "); //you have stepped on a mine
						
						
						mineTouch = true;
						
					}else {
						
						System.out.print(" X ");//If you have not stepped on a mine mark the place with an X
					}
					
					
					
					
				}else {
					System.out.print(" - "); //print the board
				}
				
				
			}
			
			System.out.println("");//line break
		}
		
		return mineTouch;
		
	}
	
	private static boolean checkMine(int x , int y, List<Mina> listaMina) {
		// TODO Auto-generated method stub
		
		boolean result = false;
		
		//we go through the list
		for( int i = 0 ; i < listaMina.size() ; i++) {
			
			Mina mina = listaMina.get(i);
			
			
			//we check if the X and the Y is in the list of mines
			if(x == mina.getFila() && y == mina.getColumna() ) {  
				
				result = true;
				
				break;
			}
			
			
			
		}
		
		return result;
	}

	
	
	
	//the boxes that the user has selected
	public static  UserSelect chooseUser() {
		

		UserSelect userSelect = new UserSelect();
		
		Scanner enterUser = new Scanner(System.in);
		
		System.out.println(" Introduce fila X: ");
		
		int X = enterUser.nextInt();
		
		System.out.println(" Introduce columna Y: ");
		int Y = enterUser.nextInt();
		
		userSelect.setFila(X);
		userSelect.setColumna(Y);
		
		
		
		return userSelect;
		
		
		
	}

}
