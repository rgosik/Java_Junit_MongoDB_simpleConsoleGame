package Projekt1;


import org.junit.Before;
import org.junit.Test;

import java.util.List;


import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static org.assertj.core.api.Assertions.*;

public class FakeTest {

    Ship shipS;
    Ship shipE;
    Ship shipW;
    Ship shipN;
    FakeService fakeService;

    @Before
    public void setUp() throws Exception {
        shipS = new Ship(0, 0, 'S');
        shipE = new Ship(7, 1, 'E');
        shipW = new Ship(2, 1, 'W');
        shipN = new Ship(4, 3, 'N');
        fakeService = new FakeService();
    }

    @Test
    public void FtestMoveSn() throws IOException {
        fakeService.act('n', shipS);
        fakeService.shipsFDB.add(shipS);
        assertEquals(fakeService.getAll().size(), 2);

    }

    @Test
    public void FtestMoveSw() throws IOException {
        fakeService.act('w', shipS);
        assertEquals(shipS.map[0][0], 'S');
        fakeService.shipsFDB.add(shipS);
        assertEquals(fakeService.getAll().size(), 2);

    }

    @Test
    public void FtestMoveSl() throws IOException {
        fakeService.act('l', shipS);
        assertEquals(shipS.direction, 'E');
        fakeService.shipsFDB.add(shipS);
        assertEquals(fakeService.getAll().size(), 2);

    }

    @Test
    public void FtestMoveSp() throws IOException {
        fakeService.act('p', shipS);
        assertEquals(shipS.direction, 'W');
        fakeService.shipsFDB.add(shipS);
        assertEquals(fakeService.getAll().size(), 2);

    }

    @Test
    public void FtestMoveEn() throws IOException {
        fakeService.act('n', shipE);
        assertEquals(shipE.map[7][2], 'S');
        fakeService.shipsFDB.add(shipE);
        assertEquals(fakeService.getAll().size(), 2);

    }

    @Test
    public void FtestMoveEw() throws IOException {
        fakeService.act('w', shipE);
        assertEquals(shipE.map[7][0], 'S');
        fakeService.shipsFDB.add(shipE);
        assertEquals(fakeService.getAll().size(), 2);

    }

    @Test
    public void FtestMoveEl() throws IOException {
        fakeService.act('l', shipE);
        assertEquals(shipE.direction, 'N');
        fakeService.shipsFDB.add(shipE);
        assertEquals(fakeService.getAll().size(), 2);

    }

    @Test
    public void FtestMoveEp() throws IOException {
        fakeService.act('p', shipE);
        assertEquals(shipE.direction, 'S');
        fakeService.shipsFDB.add(shipE);
        assertEquals(fakeService.getAll().size(), 2);

    }

    @Test
    public void FtestMoveWn() throws IOException {
        fakeService.act('n', shipW);
        assertEquals(shipW.map[2][0], 'S');
        fakeService.shipsFDB.add(shipW);
        assertEquals(fakeService.getAll().size(), 2);

    }

    @Test
    public void FtestMoveWw() throws IOException {
        fakeService.act('w', shipW);
        assertEquals(shipW.map[2][2], 'S');
        fakeService.shipsFDB.add(shipW);
        assertEquals(fakeService.getAll().size(), 2);
        ;
    }

    @Test
    public void FtestMoveWl() throws IOException {
        fakeService.act('l', shipW);
        assertEquals(shipW.direction, 'S');
        fakeService.shipsFDB.add(shipW);
        assertEquals(fakeService.getAll().size(), 2);

    }

    @Test
    public void FtestMoveWp() throws IOException {
        fakeService.act('p', shipW);
        assertEquals(shipW.direction, 'N');
        fakeService.shipsFDB.add(shipW);
        assertEquals(fakeService.getAll().size(), 2);

    }

    @Test
    public void FtestMoveNn() throws IOException {
        fakeService.act('n', shipN);
        assertEquals(shipN.map[3][3], 'S');
        fakeService.shipsFDB.add(shipN);
        assertEquals(fakeService.getAll().size(), 2);

    }

    @Test
    public void FtestMoveNw() throws IOException {
        fakeService.act('w', shipN);
        assertEquals(shipN.map[5][3], 'S');
        fakeService.shipsFDB.add(shipN);
        assertEquals(fakeService.getAll().size(), 2);

    }

    @Test
    public void FtestMoveNl() throws IOException {
        fakeService.act('l', shipN);
        assertEquals(shipN.direction, 'W');
        fakeService.shipsFDB.add(shipN);
        assertEquals(fakeService.getAll().size(), 2);

    }

    @Test
    public void FtestMoveNp() throws IOException {
        fakeService.act('p', shipN);
        assertEquals(shipN.direction, 'E');
        fakeService.shipsFDB.add(shipN);
        assertEquals(fakeService.getAll().size(), 2);

    }

}
