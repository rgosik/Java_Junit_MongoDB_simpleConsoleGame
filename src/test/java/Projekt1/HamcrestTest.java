package Projekt1;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class HamcrestTest {
	
	Ship shipT1;
	Ship shipT2;
	Service acter;
	
	@Before
	public void setUp() throws Exception {
		shipT1 = new Ship(2,2,'S');
		shipT2 = new Ship(1,6,'S');
		acter = new Service();
		acter.dbInit();
	}
	
	@Test
	public void hTestMoveSw() throws IOException {
		acter.act('w', shipT1);
		assertThat(shipT1.map[1][2], equalTo('S'));
	}
	@Test
	public void hTestInvalidCommand() throws IOException {
		acter.act('u', shipT2);
		assertThat(shipT2.map[1][6], equalTo('S'));
	}
	
}
