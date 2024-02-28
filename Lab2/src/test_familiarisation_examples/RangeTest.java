package test_familiarisation_examples;

import junit.framework.TestCase;
import org.jfree.data.Range;
import org.junit.*;


public class RangeTest extends TestCase {
    private Range rangeObjectUnderTest;

    @Before
    public void setUp() {
        rangeObjectUnderTest = new Range (-1, 1);
    }

    @After
    public void tearDown(){}

    @Test
    public void testCentralValueShouldBeZero() {
        assertEquals(
                "The central value of -1 and 1 should be 0.",
                0, rangeObjectUnderTest.getCentralValue(), 0.000000001d
        );
    }
}
