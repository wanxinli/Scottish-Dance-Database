package Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Controller.Controller;
import Controller.Publication;

public class PublicationTest {

	Publication test;
	List<Controller> result;
	
	@Before
	public void initObj() {
		test = new Publication(10, "name_here", "Sad Books Publisher", 1990);
		result = Controller.searchByKey("happy","publication");
	}
	
	@Test
	public void testGetId() {
		assertEquals(10,test.getId());
	}

	@Test
	public void testSetId() {
		test.setId(90);
		assertEquals(90,test.getId());
	}

	@Test
	public void testGetname() {
		assertEquals("name_here", test.getName());
	}

	@Test
	public void testSetname() {
		test.setName("Happy Books Publisher");
		assertEquals("Happy Books Publisher", test.getName());
	}

	@Test
	public void testGetYear() {
		assertEquals(1990, test.getYear());
	}

	@Test
	public void testSetYear() {
		test.setYear(2016);
		assertEquals(2016, test.getYear());
	}

	@Test
	public void testSearchByKey() {
		assertEquals(4, result.size());
	}

	@Test
	public void testGetPublishedBy() {
		assertEquals("Sad Books Publisher", test.getPublishedBy());
	}

	@Test
	public void testSetPublishedBy() {
		test.setPublishedBy("The Dragonborn");
		assertEquals("The Dragonborn", test.getPublishedBy());
	}

}
