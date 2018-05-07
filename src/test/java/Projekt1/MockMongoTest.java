package Projekt1;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class MockMongoTest {

    List<Ship> ships = mock(List.class);

    FakeService fakeService;

    Ship shipT1, shipT2, shipT3, shipT4, shipT5, shipT6, shipT7, shipT8 = mock(Ship.class);
    @Before
    public void setup() throws Exception{
        shipT1 = new Ship(0,0,'S');
        shipT2 = new Ship(7,1,'E');
        shipT3 = new Ship(2,1,'W');
        shipT4 = new Ship(4,3,'N');
        shipT5 = new Ship(1,6,'N');
        shipT6 = new Ship(1,0,'S');
    }
    @Mock
    MongoDB service = new MongoDB(fakeService);

   @Test
    public void forwardFromSTest() throws IOException {
        List<Ship>expList = new ArrayList<Ship>();
       service.act('n',shipT1);
       service.act('n',shipT2);
        expList.add(shipT1);
        expList.add(shipT2);
        doReturn(expList).when(service).getAll();

        assertThat(service.getAll()).isEqualTo(expList);
    }
    @Test
    public void returnEmptyTest() {
        List<Ship>expList = new ArrayList<Ship>();
        doReturn(expList).when(service).getAll();

        assertThat(service.getAll()).isEqualTo(expList);
    }
    @Test
    public void rotateLTest() throws Exception{
       service.act('l', shipT3);
       doReturn(shipT3).when(service);
       assertEquals(shipT3.direction,'W');
    }
    @Test
    public void rotatePTest() throws Exception{
        service.act('p', shipT4);
        doReturn(shipT4).when(service);
        assertEquals(shipT4.direction,'N');
    }
    @Test
    public void leaveWaterBehindTest() throws Exception{
        service.act('n', shipT5);
        doReturn(shipT5).when(service);
        assertEquals(shipT5.map[1][6],'S');
    }
    @Test
    public void repostisitonTest() throws Exception{
        List<Ship>expList = new ArrayList<Ship>();
        service.act('n',shipT1);
        service.act('n',shipT2);
        service.act('n',shipT3);
        service.act('n',shipT4);
        service.act('n',shipT5);
        expList.add(shipT1);
        expList.add(shipT2);
        expList.add(shipT3);
        expList.add(shipT4);
        expList.add(shipT5);
        doReturn(expList).when(service).getAll();

        assertThat(service.getAll()).isEqualTo(expList);
    }
    @Test
    public void hasExpectedSizeTest() throws Exception{
        List<Ship>expList = new ArrayList<Ship>();
        service.act('n',shipT1);
        service.act('n',shipT2);
        service.act('n',shipT3);
        doReturn(expList).when(service).getAll();
        expList.add(shipT1);
        expList.add(shipT2);
        expList.add(shipT3);
        assertEquals(service.getAll().size(), expList.size());
    }
}
