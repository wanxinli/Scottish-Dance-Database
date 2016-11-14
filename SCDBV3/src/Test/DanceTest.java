package Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Controller.Dance;

public class DanceTest {

	Dance test1;
	Dance test2;
	Dance test3;
	List<Dance> result;
	List<Dance> result2;
	
	@Before
	public void initObj() {
		test1 = new Dance(10, "abc", 1, 50, 99);
		test2 = new Dance(20, "def", 2, 51, "Barry");
		test3 = new Dance(30, "ghi", "type1", "square", "zoom");
		result = Dance.searchByKey("happy"); // 55 results
		result2 = Dance.searchDances("step"); // 41 results
	}
	
	@Test
	public void testGetId() {
		assertEquals(10, test1.getId());
		assertEquals(20, test2.getId());
		assertEquals(30, test3.getId());
	}

	@Test
	public void testSetId() {
		test1.setId(40);
		test2.setId(50);
		test3.setId(60);
		assertEquals(40, test1.getId());
		assertEquals(50, test2.getId());
		assertEquals(60, test3.getId());
	}

	@Test
	public void testGetName() {
		assertEquals("abc", test1.getName());
		assertEquals("def", test2.getName());
		assertEquals("ghi", test3.getName());
	}

	@Test
	public void testSetName() {
		test1.setName("zyx");
		test2.setName("wvu");
		test3.setName("ass");
		assertEquals("zyx", test1.getName());
		assertEquals("wvu", test2.getName());
		assertEquals("ass", test3.getName());
	}

	@Test
	public void testGetType_id() {
		assertEquals(1, test1.getType_id());
		assertEquals(2, test2.getType_id());
	}

	@Test
	public void testSetType_id() {
		test1.setType_id(4);
		test2.setType_id(5);
		assertEquals(4, test1.getType_id());
		assertEquals(5, test2.getType_id());
	}

	@Test
	public void testGetShape_id() {
		assertEquals(50,test1.getShape_id());
		assertEquals(51,test2.getShape_id());
	}

	@Test
	public void testSetShape_id() {
		test1.setShape_id(75);
		test2.setShape_id(76);
		assertEquals(75,test1.getShape_id());
		assertEquals(76,test2.getShape_id());
	}

	@Test
	public void testGetDevisor_id() {
		assertEquals(99, test1.getDevisor_id());
	}

	@Test
	public void testSetDevisor_id() {
		test1.setDevisor_id(100);
		assertEquals(100, test1.getDevisor_id());
	}

	@Test
	public void testSearchByKey() {
		assertEquals(55,result.size());
	}

	@Test
	public void testGetAuthorName() {
		assertEquals("Barry", test2.getAuthorName());
		assertEquals("zoom", test3.getAuthorName());
		
	}

	@Test
	public void testSetAuthorName() {
		test2.setAuthorName("Reagan");
		test3.setAuthorName("Dumbo");
		assertEquals("Reagan", test2.getAuthorName());
		assertEquals("Dumbo", test3.getAuthorName());
	}

//	@Test
//	public void testSearchDances() {
//		assertEquals(41, result2);
//	}

	@Test
	public void testGetType() {
		assertEquals("type1", test3.getType());
	}

	@Test
	public void testSetType() {
		test3.setType("Oval");
		assertEquals("Oval", test3.getType());
	}

//	@Test
//	public void testGetShape() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetShape() {
//		fail("Not yet implemented");
//	}

}
