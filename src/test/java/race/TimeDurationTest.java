package race;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cmaciel.BadBadValueException;
import com.cmaciel.TimeDuration;

public class TimeDurationTest {

	@Test
	public void stringifies() throws BadBadValueException {
		System.out.println(new TimeDuration(732).toString());
		System.out.println(new TimeDuration(7242).toString());
		System.out.println(new TimeDuration(0).toString());
		assertEquals(new TimeDuration(732).toString(), "12m 12s");
		assertEquals(new TimeDuration(7242).toString(), " 2h  0m 42s");
		assertEquals(new TimeDuration(0).toString(), " 0s");
	}
	
	@Test
	public void testException() {
	    try {
	        new TimeDuration(-1);
	        fail("Expected a BadBadValueException to be thrown");
	    } catch (BadBadValueException aBadBadValueException) {
	    }
	}
}
