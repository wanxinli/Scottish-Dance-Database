package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Controller.Tune;

public class TuneTest {

	Tune test;
	
	@Before
	public void initObj() {
		test = new Tune(12345,"test", "test2");
	}
	
	@Test
	public void testGetcomposer() {
		assertEquals(test.getcomposer(), "test2");
	}

	@Test
	public void testSetcomposer() {
		test.setcomposer("Pat");
		assertEquals(test.getcomposer(), "Pat");
	}

	@Test
	public void testTune() {
		assertNotNull("Isn't Null", test);
	}

}
