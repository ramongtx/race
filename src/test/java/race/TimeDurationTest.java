package race;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cmaciel.BadBadValueException;
import com.cmaciel.TimeDuration;

public class TimeDurationTest {

	@Test
	public void stringifies() throws BadBadValueException {
		assertEquals(new TimeDuration(732).toString(), "12m 12s");
		assertEquals(new TimeDuration(7242).toString(), "2h 0m 42s");
		assertEquals(new TimeDuration(0).toString(), "0s");
	}

	@Test
	public void testInitializeException() {
		try {
			new TimeDuration(-1);
			fail("Expected a BadBadValueException to be thrown");
		} catch (BadBadValueException aBadBadValueException) {
		}
	}

	@Test
	public void testSetSecondsException() {
		try {
			TimeDuration timeDuration = new TimeDuration(0);
			assertEquals(timeDuration.getSeconds(), 0);
			timeDuration.setSeconds(-1);
			fail("Expected a BadBadValueException to be thrown");
		} catch (BadBadValueException aBadBadValueException) {
		}
	}

	@Test
	public void comparation() throws BadBadValueException {
		assertTrue(new TimeDuration(10).compareTo(new TimeDuration(20)) < 0);
		assertTrue(new TimeDuration(32).compareTo(new TimeDuration(31)) > 0);
		assertTrue(new TimeDuration(58).compareTo(new TimeDuration(58)) == 0);
	}
}
