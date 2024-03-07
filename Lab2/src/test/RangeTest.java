package test;

import junit.framework.TestCase;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest extends TestCase {
    private Range rangeObjectUnderTest;

    @Before
    public void setUp() {
        rangeObjectUnderTest = new Range(-76, 20);
    }

    @After
    public void tearDown() {
        rangeObjectUnderTest = null;
    }

    // Tests for Range.constrain()

    @Test
    public void testConstrainWithValueBelowLowerBoundary() {
        assertEquals(
            "The value in the range closest to -77 should be -76.",
            -76.0, rangeObjectUnderTest.constrain(-77.0)
        );
    }

    @Test
    public void testConstrainWithValueOnLowerBoundary() {
        assertEquals(
            "The value in the range closest to -76 should be -76.",
            -76.0, rangeObjectUnderTest.constrain(-76.0)
        );
    }

    @Test
    public void testConstrainWithValueAboveLowerBoundary() {
        assertEquals(
            "The value in the range closest to -75 should be -75.",
            -75.0, rangeObjectUnderTest.constrain(-75.0)
        );
    }

    @Test
    public void testConstrainWithValueBetweenLowerAndUpperBoundaries() {
        assertEquals(
            "The value in the range closest to 8 should be 8.",
            8.0, rangeObjectUnderTest.constrain(8.0)
        );
    }

    @Test
    public void testConstrainWithValueBelowUpperBoundary() {
        assertEquals(
            "The value in the range closest to 19 should be 19.",
            19.0, rangeObjectUnderTest.constrain(19.0)
        );
    }

    @Test
    public void testConstrainWithValueOnUpperBoundary() {
        assertEquals(
            "The value in the range closest to 20 should be 20.",
            20.0, rangeObjectUnderTest.constrain(20.0)
        );
    }

    @Test
    public void testConstrainWithValueAboveUpperBoundary() {
        assertEquals(
            "The value in the range closest to 21 should be 20.",
            20.0, rangeObjectUnderTest.constrain(21.0)
        );
    }
}
