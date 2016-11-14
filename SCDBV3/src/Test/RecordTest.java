package Test;

import Controller.Record;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class RecordTest {

	@Test
	public void testGetters() {
		Record testObj = new Record(1, "bob", "Funky Junks", 2, 3, 4, 5);
		
		assertEquals(1, testObj.getId());
		assertEquals("bob", testObj.getName());
		assertEquals("Funky Junks", testObj.getArtist());
		assertEquals(2, testObj.getTypeId());
		assertEquals(3, testObj.getReps());
		assertEquals(4, testObj.getBarsPerRepeat());
		assertEquals(5, testObj.getPlayTime());
	}
	
	@Test
	public void testSearchByKey() {
		List<Record> result = Record.searchByKey("leap"); // also tested with different cases, still works
		assertEquals(2, result.size());
		
		List<Record> result2 = Record.searchByKey("hum");
		assertEquals(8, result2.size());
	}

}
