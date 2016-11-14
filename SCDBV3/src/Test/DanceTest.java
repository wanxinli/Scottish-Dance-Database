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
	
	@Before
	public void initObj() {
		test1 = new Dance();
		test2 = new Dance();
		test3 = new Dance();
		result = Dance.searchByKey("happy"); // 55 results
	}
	
	@Test
	public void testGetId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetType_id() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetType_id() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetShape_id() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetShape_id() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDevisor_id() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDevisor_id() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchByKey() {
		assertEquals(55,result.size());
	}

	@Test
	public void testGetAuthorName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAuthorName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchDances() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetType() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetType() {
		fail("Not yet implemented");
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
