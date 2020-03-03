package utilities;

import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;

/**
 * The Utils test.
 */
public class UtilsTest {

    /**
     * Tests {@link Utils#parseInt(String)}.
     */
    @Test
    public void parseInt() {

        assertEquals(275, Utils.parseInt("275"));
        assertEquals(-1, Utils.parseInt("FDGfdgd"));
    }

    /**
     * Tests {@link Utils#convert(String, String)}.
     */
    @Test
    public void convert() {

        Date actual = Utils.convert("yyyy-MM-dd", "2010-12-25");
        Date expected = new Date(2010 - 1900, 11, 25);
        assertEquals(expected, actual);
    }

    /**
     * Tests {@link Utils#calculateInterval(String, String)}.
     */
    @Test
    public void calculateInterval() {

        assertEquals(111, Utils.calculateInterval("2010-07-25", "2010-11-13"));
    }
}