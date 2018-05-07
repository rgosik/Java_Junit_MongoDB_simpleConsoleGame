package Projekt1;


import org.junit.Before;
import org.junit.Test;


import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static org.assertj.core.api.Assertions.*;

public class AppTest{
	
    Ship shipS;
    Ship shipE;
    Ship shipW;
    Ship shipN;
    Ship shipT;
    Ship shipTe;
    Ship shipLoad;
    Ship shipTa;
	Service acter;
	@Before
	public void setUp() throws Exception{
		shipS = new Ship(0,0,'S');
		shipE = new Ship(7,1,'E');
		shipW = new Ship(2,1,'W');
		shipN = new Ship(4,3,'N');
		shipT = new Ship(1,6,'N');
		shipLoad = new Ship(1,6,'S');
		shipTa = new Ship(2,2,'S');
		acter = new Service();
		Service.dbInit();
	}

    @Test
    public void testMoveSn() throws IOException {
    	acter.act('n', shipS);
    	assertEquals(shipS.map[1][0],'S');
    }
    @Test
    public void testMoveSw() throws IOException {
    	acter.act('w', shipS);
    	assertEquals(shipS.map[0][0],'S');
    }
    @Test
    public void testMoveSl() throws IOException {
    	acter.act('l', shipS);
    	assertEquals(shipS.direction, 'E');
    }
    @Test
    public void testMoveSp() throws IOException {
    	acter.act('p', shipS);
    	assertEquals(shipS.direction, 'W');
    }
    @Test
    public void testMoveEn() throws IOException {
    	acter.act('n', shipE);
    	assertEquals(shipE.map[7][2],'S');
    }
    @Test
    public void testMoveEw() throws IOException {
    	acter.act('w', shipE);
    	assertEquals(shipE.map[7][0],'S');
    }
    @Test
    public void testMoveEl() throws IOException {
    	acter.act('l', shipE);
    	assertEquals(shipE.direction, 'N');
    }
    @Test
    public void testMoveEp() throws IOException { 
    	acter.act('p', shipE);
    	assertEquals(shipE.direction, 'S');
    }
    @Test
    public void testMoveWn() throws IOException {
    	acter.act('n', shipW);
    	assertEquals(shipW.map[2][0],'S');
    }
    @Test
    public void testMoveWw() throws IOException {
    	acter.act('w', shipW);
    	assertEquals(shipW.map[2][2],'S');
    }
    @Test
    public void testMoveWl() throws IOException {
    	acter.act('l', shipW);
    	assertEquals(shipW.direction, 'S');
    }
    @Test
    public void testMoveWp() throws IOException {
    	acter.act('p', shipW);
    	assertEquals(shipW.direction, 'N');
    }
    @Test
    public void testMoveNn() throws IOException {
    	acter.act('n', shipN);
    	assertEquals(shipN.map[3][3],'S');
    }
    @Test
    public void testMoveNw() throws IOException {
    	acter.act('w', shipN);
    	assertEquals(shipN.map[5][3],'S');
    }
    @Test
    public void testMoveNl() throws IOException {
    	acter.act('l', shipN);
    	assertEquals(shipN.direction, 'W');
    }
    @Test
    public void testMoveNp() throws IOException {
    	acter.act('p', shipN);
    	assertEquals(shipN.direction, 'E');
    }
    @Test
    public void testValidateMoveLand() {
    	assertFalse(shipT.validateMove(1, 1));
    }
    @Test
    public void testValidateMoveNoLand() {
    	assertTrue(shipT.validateMove(0, 0));
    }
    @Test
    public void testActX() throws IOException {
    	acter.act( 'x', shipT);
    }
    @Test
    public void testActH() throws IOException {
    	acter.act( 'h', shipT);
    }
    @Test
	public void TestDeleteSave() throws IOException {
    	acter.act('s', shipT);
    	acter.act('d', shipT);
    	assertFalse(Service.file.exists());
    }
	@Test
	public void TestSaveMap() throws IOException {
		acter.act('s', shipT);
		assertTrue(Service.file.exists());
	}
	@Test
	public void TestLoadMap() throws IOException { 
		acter.act('s', shipLoad);
		acter.act('n', shipLoad);
		acter.act('n', shipLoad);
		acter.act('n', shipLoad);
		acter.act('v', shipLoad);
		assertEquals(shipLoad.map[1][6], ('S'));
	}
    @Test
    public void testClasses() {                                          //JAVA 8
    	
    	NoThrow.assertDoesNotThrow(() ->{
    		Service sv = new Service();
    		NoThrow nt = new NoThrow();
    		Ship sh = new Ship(0,0,'S');
    	});
    }
    @Test
    public void testMapPrintNoThrow() {                                          
    	
    	NoThrow.assertDoesNotThrow(() ->{
    		acter.act('m', shipTa);
    	});
    }
    
    @Test
	public void testValidateXYMinus() {
		assertFalse(shipTa.validateXY(-11, -957));
	}
	@Test
	public void testValidateXYgt9() {
		assertFalse(shipTa.validateXY(164, 43));
	}
	@Test
	public void testTestValidateMoveFail() {
		assertFalse(shipTa.validateMove(-1,-1));
	}
	
	@Test
	public void testDeletionNoFile() throws IOException{
		acter.act('s', shipTa);
		acter.act('d', shipTa);
		acter.act('d', shipTa);
		assertFalse(Service.file.exists());
	}
}
