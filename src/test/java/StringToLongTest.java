import org.junit.Test;

import static org.junit.Assert.*;

public class StringToLongTest {

    @Test
    public void testGoodPositive() throws Exception {

        Long expected = 123L;
        Long result = StringToLong.convert("123");
        assertEquals(expected,result);

    }

    @Test
    public void testGoodNegative() throws Exception {
        Long expected = -123L;
        Long result = StringToLong.convert("-123");
        assertEquals(expected,result);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testOverflow() throws Exception {
        // appending a digit will cause overflow
        StringToLong.convert(Long.MAX_VALUE+"1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnderflow() throws Exception {
        // appending a digit will cause underflow
        StringToLong.convert(Long.MIN_VALUE+"1");
    }

    @Test(expected = NumberFormatException.class)
    public void testGarbageIn() throws Exception {
        StringToLong.convert("foo");
    }

    @Test(expected = NumberFormatException.class)
    public void testGarbageInTheMiddle() throws Exception {
        StringToLong.convert("123!765");
    }

    @Test
    public void testTrimSpaces() throws Exception {
        long result = StringToLong.convert("  123  ");
        assertEquals(123L,result);

    }
}