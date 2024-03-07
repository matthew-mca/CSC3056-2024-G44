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

    // Tests for Range.intersects()

    @Test
    public void testIntersectsLowerValueAboveLowerBoundaryAndUpperValueBelowUpperBoundary() {
        assertTrue(
            "A range from -75 to 19 should overlap with a range from -76 to 20.",
            rangeObjectUnderTest.intersects(-75.0, 19.0)
        );
    }

    @Test
    public void testIntersectsLowerValueAndUpperValueAboveUpperBoundary() {
        assertFalse(
            "A range from 21 to 21 should not overlap with a range from -76 to 20.",
            rangeObjectUnderTest.intersects(21.0, 21.0)
        );
    }

    @Test
    public void testIntersectsLowerValueBelowLowerBoundaryAndUpperValueIsNominal() {
        assertTrue(
            "A range from -77 to 8 should overlap with a range from -76 to 20.",
            rangeObjectUnderTest.intersects(-77.0, 8.0)
        );
    }

    @Test
    public void testIntersectsLowerValueBelowLowerBoundaryAndUpperValueOnLowerBoundary() {
        assertTrue(
            "A range from -77 to -76 should overlap with a range from -76 to 20.",
            rangeObjectUnderTest.intersects(-77.0, -76.0)
        );
    }

    @Test
    public void testIntersectsLowerValueAndUpperValueOnUpperBoundary() {
        assertTrue(
            "A range from 20 to 20 should overlap with a range from -76 to 20.",
            rangeObjectUnderTest.intersects(20.0, 20.0)
        );
    }

    @Test
    public void testIntersectsLowerValueBelowUpperBoundaryAndUpperValueBelowLowerBoundary() {
        assertFalse(
            "Lower value (19) and upper value (-77) are invalid for a range, so intersects() should return False.",
            rangeObjectUnderTest.intersects(19.0, -77.0)
        );
    }

    @Test
    public void testLowerValueAndUpperValueBelowUpperBoundary() {
        assertTrue(
            "A range from 19 to 19 should overlap with a range from -76 to 20.",
            rangeObjectUnderTest.intersects(19.0, 19.0)
        );
    }

    @Test
    public void testIntersectsLowerValueIsNominalAndUpperValueAboveLowerBoundary() {
        assertFalse(
            "Lower value (8) and upper value (-75) are invalid for a range, so intersects() should return False.",
            rangeObjectUnderTest.intersects(8.0, -75.0)
        );
    }

    @Test
    public void testIntersectsLowerValueBelowLowerBoundaryAndUpperValueBelowUpperBoundary() {
        assertTrue(
            "A range from -77 to 19 should overlap with a range from -76 to 20.",
            rangeObjectUnderTest.intersects(-77.0, 19.0)
        );
    }

    @Test
    public void testIntersectsLowerValueOnLowerBoundaryAndUpperValueOnUpperBoundary() {
        assertTrue(
            "A range from -76 to 20 should overlap with a range from -76 to 20.",
            rangeObjectUnderTest.intersects(-76.0, 20.0)
        );
    }
}
