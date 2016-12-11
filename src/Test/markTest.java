package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Controller.mark;

public class markTest {

	mark test;
	
	@Before
	public void initObj() {
		test = new mark(12345,"TEST");
	}
	
	@Test
	public void testMark() {
		assertNotNull(test);
	}

	@Test
	public void testGetId() {
		assertEquals(test.getId(), 12345);
	}

	@Test
	public void testSetId() {
		assertEquals(1,1);
		// setting var
	}

	@Test
	public void testGetTableName() {
		assertEquals(test.getTableName(), "TEST");
	}

	@Test
	public void testSetTableName() {
		assertEquals(1,1);
		// setting var
	}

}
