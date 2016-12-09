package Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Controller.Album;
import Controller.Controller;

public class AlbumTest {

	Album test;
	List<Controller> result;
	
	@Before
	public void initObj() {
		test = new Album(1, "Bill", 1990, "ACDC");
		result = Controller.searchByKey("happy","album");
	}

	@Test
	public void testGetId() {
		assertEquals(1, test.getId());
	}

	@Test
	public void testSetId() {
		test.setId(37);
		assertEquals(37, test.getId());
	}

	@Test
	public void testGetproductionyear() {
		assertEquals(1990, test.getproductionyear());
	}

	@Test
	public void testSetproductionyear() {
		test.setproductionyear(2000);
		assertEquals(2000, test.getproductionyear());
		
	}

//	@Test
//	public void testGetartist_id() {
//		assertEquals("ACDC", test.getartist_id());
//	}
//
//	@Test
//	public void testSetartist_id() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetname() {
		assertEquals("Bill", test.getName());
	}

	@Test
	public void testSetname() {
		test.setName("Patrick");
		assertEquals("Patrick", test.getName());
	}

	@Test
	public void testGetArtist() {
		assertEquals("ACDC", test.getArtist());
	}

	@Test
	public void testSetArtist() {
		test.setArtist("Led Zeppelin");
		assertEquals("Led Zeppelin", test.getArtist());
	}

	@Test
	public void testSearchByKey() {
		assertEquals(4, result.size());
	}

}
