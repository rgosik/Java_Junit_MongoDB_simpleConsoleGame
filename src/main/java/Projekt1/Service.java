package Projekt1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class Service implements IShipService {

	static MongoCollection mapdb;

	static File file;
	public static void help() {
		System.out.println("------------HELP-----------");
		System.out.println("| n -> ruch naprzod       |");
		System.out.println("| w -> ruch wstecz        |");
		System.out.println("| l -> obrot w lewo       |");
		System.out.println("| p -> obrot w prawo      |");
		System.out.println("| s -> zapisz mape        |");
		System.out.println("| v -> wczytaj mape       |");
		System.out.println("| m -> wsyswietl mape     |");
		System.out.println("| x -> zakonczenie gry    |");
		System.out.println("| d -> usun zapisana mape |");
		System.out.println("| h -> okno HELP          |");
		System.out.println("---------------------------\n");
	}
	public static void dbInit(){
		DB db = new MongoClient().getDB("mapDB");
		mapdb = new Jongo(db).getCollection("mapdb");
	}
	public static void colecetionDrop(){
		mapdb.remove("{ x: { $in:[#, #, #, #, #, #, #, #, #, #] }}", 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
	}
	public void act(char in, Ship ship) throws IOException {
		switch(in) { 
			case 'x':
				break;
			case 'h': 
				help();
				break;
			case 'm':
				ship.printMap();
				break;
			case 's':
				saveMap(ship);
				break;
			case 'v':
				loadMap(ship);
				break;
			case 'd':
				deleteMapSaveS();
				break;
			default:
				ship.move(in);
                mapdb.insert(ship);
				break;
		}
	}
	/*public static boolean newSesion(){
		System.out.println("\nCzy chcesz zaczac nowa sesje ? [Y|N]: ");
		Scanner input = new Scanner(System.in);
		char s = input.next(".").charAt(0);
		if (s == 'Y'){ return true;}
		else { return false;}
	}*/

	public List<Ship> getAll() {
		List<Ship> all = new ArrayList<Ship>();
		MongoCursor<Ship> cursor = mapdb.find().as(Ship.class);

		if(cursor == null) return Collections.emptyList();
		for(Ship m : cursor) {
			all.add(m);
		}
		return all;
	}
	
	private static void saveMap(Ship ship) throws IOException {
		file = new File("map.txt");
		
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < ship.map.length; i++)
		{
		   for(int j = 0; j < ship.map.length; j++)
		   {
		      builder.append(ship.map[i][j]+"");
		      if(j < (ship.map.length))
		         builder.append(",");
		   } 
		   builder.append("\n");
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
		    writer.write(builder.toString());
		    System.out.println("Utworzono zapis obecnej mapy");
		}		
	}
	
	private static void loadMap(Ship ship) throws IOException {
		String mapFile = "map.txt";
		try(BufferedReader reader = new BufferedReader(new FileReader(mapFile))) {
			String line = "";
			int row = 0;
			while((line = reader.readLine()) != null)
			{
			   String[] cols = line.split(","); 
			   int col = 0;
			   for(String  c : cols)
			   {
			      ship.map[row][col] = c.charAt(0);
			      col++;
			   }
			   row++;
			}
		} 
		catch(FileNotFoundException e) {
			System.out.println("Zapis mapy nie istnieje");
		}		
	}
	private static void deleteMapSaveS() {
		try {
			if (file.exists()) {
				file.delete();
				System.out.println(file.getName() + " zostal usuniety");	
			} else System.out.println("Nie istnieje zapis mapy ktory moznaby usunac");
				
		} catch(NullPointerException e) {
			System.out.println("Nie istnieje zapis mapy ktory moznaby usunac(EXEC)");
		}
	}
	
}
