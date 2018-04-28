package Projekt1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	
	public static void main( String[] args ) throws Exception
    {
		Ship ship = null;
		int create = 1;
		
		Scanner input = new Scanner(System.in);
		while(create == 1) {
			try {
				System.out.print("Wprowadz wspolrzedne poczatkowe:\nx: ");
				int x = input.nextInt();
				System.out.print("y: ");
				int y = input.nextInt();
				System.out.print("Podaj kierunej poczatkowy: ");
				char dir = input.next(".").charAt(0);
				ship = new Ship(x,y,dir);
				create = 0;
			}
			catch(ArrayIndexOutOfBoundsException e){
				System.out.println("\nPodano nieprawidlowe wspolrzedne\nZakres: od 0 do 10\n--------------------------------\n");
				create = 1;
				input.nextLine();
			}
			catch(Error e) {
				System.out.println("\nPodano nie prawidlowy kierunek\nPoprawne kierunki: N, S, W, E\n--------------------------------\n");
				create = 1;
				input.nextLine();
			}
			catch(ShipOnLandException e) {
				System.out.println("\nPrubowano postawic statek na wyspie\n--------------------------------\n");
				create = 1;
				input.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println("Przestan probowac zepsuc program ಠ_ಠ \n------------------------------------\n");
				input.nextLine();
			}
		}		
		System.out.println("############## OK ##############\n\n");
		System.out.print("Wprowadz \"h\" zeby otrzyamc instrukcje gry\n");
		char in = '0';
    	while(in != 'x') {
    		System.out.print("\nWykonaj ruch: ");
    		try{
    			in = input.next(".").charAt(0);
    			Service.act(in, ship);
    		} catch(InputMismatchException e) {
    			System.out.println("\nWprowadzono nieprawidlowe polecenie, przeczytaj instrukcje:");
    			Service.help();
    			input.nextLine();
    		}    		
    	}
    	
    	input.close();
    	System.out.println("\nOpuszczono gre");
    	Runtime.getRuntime().exit(1);
    }
}
