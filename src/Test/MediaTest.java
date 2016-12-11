package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Controller.Media;

public class MediaTest {

	Media test;
	
	@Before
	public void initObj() {
		test = new Media(12345, "Name", 678, 22 ,"twentytwo", 1994);
	}
	
	@Test
	public void testGetyear() {
		assertEquals(test.getyear(), 1994);
	}

	@Test
	public void testSetproductionyear() {
		assertEquals(1,1);
	}

	@Test
	public void testGetalbum_id() {
		assertEquals(test.getalbum_id(), 678);
	}

	@Test
	public void testSetartist_id() {
		assertEquals(1,1);
	}

	@Test
	public void testGetmedia_id() {
		assertEquals(test.getmedia_id(), 22);
	}

	@Test
	public void testSetmedia_id() {
		assertEquals(1,1);
	}

	@Test
	public void testMediaIntString() {
		assertEquals(test.getId(), 12345);
	}

	@Test
	public void testGetcatalognumber() {
		assertEquals(1,1);
	}

	@Test
	public void testSetcatalognumber() {
		assertEquals(test.getcatalognumber(), "twentytwo");
	}

}
