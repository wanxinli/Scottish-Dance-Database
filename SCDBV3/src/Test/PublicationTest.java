package Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Controller.Publication;

public class PublicationTest {

	Publication test;
	List<Publication> result;
	
	@Before
	public void initObj() {
		test = new Publication(10, "name_here", "Sad Books Publisher", 1990);
		result = Publication.searchByKey("happy");
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
		assertEquals("name_here", test.getname());
	}

	@Test
	public void testSetname() {
		test.setname("Happy Books Publisher");
		assertEquals("Happy Books Publisher", test.getname());
	}

	@Test
	public void testGetYear_idValue() {
		assertEquals(1990, test.getYear_idValue());
	}

	@Test
	public void testSetYear_idValue() {
		test.setYear_idValue(2016);
		assertEquals(2016, test.getYear_idValue());
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
