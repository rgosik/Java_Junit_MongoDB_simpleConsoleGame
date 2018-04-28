package Projekt1;

public class Ship {
	
	int x; 
	int y;
	char direction;
	char[][] map = { {'w', 'w', 'w', 'w', 'w', 'x', 'w', 'w', 'x', 'w'},
					 {'w', 'x', 'w', 'w', 'x', 'w', 'w', 'w', 'w', 'w'},
					 {'w', 'w', 'w', 'x', 'w', 'w', 'w', 'x', 'w', 'w'},
					 {'x', 'w', 'w', 'w', 'w', 'x', 'w', 'w', 'w', 'w'},
					 {'w', 'w', 'x', 'w', 'w', 'w', 'w', 'x', 'w', 'w'},
					 {'w', 'w', 'w', 'w', 'x', 'w', 'w', 'w', 'w', 'x'},
					 {'w', 'x', 'w', 'w', 'w', 'w', 'x', 'w', 'w', 'w'},
					 {'w', 'w', 'w', 'x', 'w', 'w', 'w', 'w', 'x', 'w'},
					 {'x', 'w', 'x', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
					 {'w', 'w', 'w', 'w', 'x', 'w', 'w', 'w', 'x', 'w'}, };
	public Ship(int x, int y, char dir) throws ShipOnLandException {
		if(!(checkIfLand(x, y) || !validateXY(x,y))) {
			this.x = x; 
			this.y = y;	
			map[x][y] = 'S';
		} else {
			throw new ShipOnLandException("Nie mozna postawic statku na wyspie");
		}
		
		if(!(dir != 'N' && dir != 'E' && dir != 'S' && dir != 'W')) {
			direction = dir;					
		} else throw new Error();				
	}
	
	public void move(char c) {
		System.out.println("\n---------------------------------------");
		int tx = x;
		int ty = y;
		if(c != 'n' && c!= 'w' && c!= 'l' && c!='p') {
			System.out.println("\nWprowadzono nieprawidlowe polecenie, przeczytaj instrukcje:");
			Service.help();
			return;
		}
		if (c == 'n') {
			switch (direction) {
				case 'N':
					if(validateMove(x-1, y)) x -= 1;
					break;
				case 'S':
					if(validateMove(x+1, y)) x += 1;
					break;
				case 'W':
					if(validateMove(x, y-1)) y -= 1;
					break;
				case 'E':
					if(validateMove(x, y+1)) y += 1;
			}
		}
		if (c == 'w') {
			switch (direction) {
				case 'N':
					if(validateMove(x+1, y)) x += 1;
					break;
				case 'S':
					if(validateMove(x-1, y)) x -= 1;
					break;
				case 'W':
					if(validateMove(x, y+1)) y += 1;
					break;
				case 'E':
					if(validateMove(x, y-1)) y -= 1;
			}
		}
		if (c == 'l') {
			switch(direction) {
				case 'N': direction = 'W';
					break;
				case 'E': direction = 'N';
					break;
				case 'S': direction = 'E';
					break;
				case 'W': direction = 'S';
			}
		}
		if (c == 'p') {
			switch(direction) {
				case 'N': direction = 'E';
					break;
				case 'E': direction = 'S';
					break;
				case 'S': direction = 'W';
					break;
				case 'W': direction = 'N';
			}
		}
		map[x][y] = 'S';
		if(tx!=x || ty!=y) map[tx][ty] = 'w';
		System.out.format("x: %d\ny: %d\nKierunek: %c\n---------------------------------------\n\n", x, y, direction);
	}
	public boolean checkIfLand(int x, int y) {
		if(map[x][y] == 'x') {
			return true;
		}
		else return false;				
	}
	
	public boolean validateXY(int x, int y) {
		if(x<0 || x>9 || y<0 || y>9) return false;
		else return true;
	}
	
	public boolean validateMove(int x, int y) {
		if(!validateXY(x,y)) {
			System.out.println("Wyplynieto poza mape\nRuch anulowany");
			return false;
		} else {
			if(checkIfLand(x,y)) {
				System.out.println("Wplynieto na lad\nRuch anulowany\n");
				return false;
			} else return true;
		}
	}
	public void printMap() {
		System.out.println("\n");
		for(char[] row : map) {
			for(char el : row) {
				System.out.printf(" %c ", el);
			}
			System.out.println();
		}
		System.out.println();
	}
}

