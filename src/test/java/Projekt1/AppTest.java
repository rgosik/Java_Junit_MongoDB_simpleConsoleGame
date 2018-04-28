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
	@Before
	public void setUp() throws Exception{
		shipS = new Ship(0,0,'S');
		shipE = new Ship(7,1,'E');
		shipW = new Ship(2,1,'W');
		shipN = new Ship(4,3,'N');
		shipT = new Ship(1,6,'N');
		shipLoad = new Ship(1,6,'S');
		shipTa = new Ship(2,2,'S');
	}

    @Test
    public void testMoveSn() throws IOException {
    	Service.act('n', shipS);
    	assertEquals(shipS.map[1][0],'S');
    }
    @Test
    public void testMoveSw() throws IOException {
    	Service.act('w', shipS);
    	assertEquals(shipS.map[0][0],'S');
    }
    @Test
    public void testMoveSl() throws IOException {
    	Service.act('l', shipS);
    	assertEquals(shipS.direction, 'E');
    }
    @Test
    public void testMoveSp() throws IOException {
    	Service.act('p', shipS);
    	assertEquals(shipS.direction, 'W');
    }
    @Test
    public void testMoveEn() throws IOException {
    	Service.act('n', shipE);
    	assertEquals(shipE.map[7][2],'S');
    }
    @Test
    public void testMoveEw() throws IOException {
    	Service.act('w', shipE);
    	assertEquals(shipE.map[7][0],'S');
    }
    @Test
    public void testMoveEl() throws IOException {
    	Service.act('l', shipE);
    	assertEquals(shipE.direction, 'N');
    }
    @Test
    public void testMoveEp() throws IOException { 
    	Service.act('p', shipE);
    	assertEquals(shipE.direction, 'S');
    }
    @Test
    public void testMoveWn() throws IOException {
    	Service.act('n', shipW);
    	assertEquals(shipW.map[2][0],'S');
    }
    @Test
    public void testMoveWw() throws IOException {
    	Service.act('w', shipW);
    	assertEquals(shipW.map[2][2],'S');
    }
    @Test
    public void testMoveWl() throws IOException {
    	Service.act('l', shipW);
    	assertEquals(shipW.direction, 'S');
    }
    @Test
    public void testMoveWp() throws IOException {
    	Service.act('p', shipW);
    	assertEquals(shipW.direction, 'N');
    }
    @Test
    public void testMoveNn() throws IOException {
    	Service.act('n', shipN);
    	assertEquals(shipN.map[3][3],'S');
    }
    @Test
    public void testMoveNw() throws IOException {
    	Service.act('w', shipN);
    	assertEquals(shipN.map[5][3],'S');
    }
    @Test
    public void testMoveNl() throws IOException {
    	Service.act('l', shipN);
    	assertEquals(shipN.direction, 'W');
    }
    @Test
    public void testMoveNp() throws IOException {
    	Service.act('p', shipN);
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
    	Service.act( 'x', shipT);
    }
    @Test
    public void testActH() throws IOException {
    	Service.act( 'h', shipT);
    }
    @Test
	public void TestDeleteSave() throws IOException {
    	Service.act('s', shipT);
    	Service.act('d', shipT);
    	assertFalse(Service.file.exists());
    }
	@Test
	public void TestSaveMap() throws IOException {
		Service.act('s', shipT);
		assertTrue(Service.file.exists());
	}
	@Test
	public void TestLoadMap() throws IOException { 
		Service.act('s', shipLoad);
		Service.act('n', shipLoad);
		Service.act('n', shipLoad);
		Service.act('n', shipLoad);
		Service.act('v', shipLoad);
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
    		Service.act('m', shipTa);
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
			Service.act('s', shipTa);
			Service.act('d', shipTa);	
			Service.act('d', shipTa);
			assertFalse(Service.file.exists());
		}
}
