package org.jfree.data;

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
        assertEquals("The value in the range closest to -77 should be -76.", -76.0,
            rangeObjectUnderTest.constrain(-77.0));
    }

    @Test
    public void testConstrainWithValueOnLowerBoundary() {
        assertEquals("The value in the range closest to -76 should be -76.", -76.0,
            rangeObjectUnderTest.constrain(-76.0));
    }

    @Test
    public void testConstrainWithValueAboveLowerBoundary() {
        assertEquals("The value in the range closest to -75 should be -75.", -75.0,
            rangeObjectUnderTest.constrain(-75.0));
    }

    @Test
    public void testConstrainWithNominalValue() {
        assertEquals("The value in the range closest to 8 should be 8.", 8.0, rangeObjectUnderTest.constrain(8.0));
    }

    @Test
    public void testConstrainWithValueBelowUpperBoundary() {
        assertEquals("The value in the range closest to 19 should be 19.", 19.0, rangeObjectUnderTest.constrain(19.0));
    }

    @Test
    public void testConstrainWithValueOnUpperBoundary() {
        assertEquals("The value in the range closest to 20 should be 20.", 20.0, rangeObjectUnderTest.constrain(20.0));
    }

    @Test
    public void testConstrainWithValueAboveUpperBoundary() {
        assertEquals("The value in the range closest to 21 should be 20.", 20.0, rangeObjectUnderTest.constrain(21.0));
    }

    // Tests for Range.intersects()

    @Test
    public void testIntersectsLowerValueAboveLowerBoundaryAndUpperValueBelowUpperBoundary() {
        assertTrue("A range from -75 to 19 should overlap with a range from -76 to 20.",
            rangeObjectUnderTest.intersects(-75.0, 19.0));
    }

    @Test
    public void testIntersectsLowerValueAndUpperValueAboveUpperBoundary() {
        assertFalse("A range from 21 to 21 should not overlap with a range from -76 to 20.",
            rangeObjectUnderTest.intersects(21.0, 21.0));
    }

    @Test
    public void testIntersectsLowerValueBelowLowerBoundaryAndUpperValueIsNominal() {
        assertTrue("A range from -77 to 8 should overlap with a range from -76 to 20.",
            rangeObjectUnderTest.intersects(-77.0, 8.0));
    }

    @Test
    public void testIntersectsLowerValueBelowLowerBoundaryAndUpperValueOnLowerBoundary() {
        assertTrue("A range from -77 to -76 should overlap with a range from -76 to 20.",
            rangeObjectUnderTest.intersects(-77.0, -76.0));
    }

    @Test
    public void testIntersectsLowerValueAndUpperValueOnUpperBoundary() {
        assertTrue("A range from 20 to 20 should overlap with a range from -76 to 20.",
            rangeObjectUnderTest.intersects(20.0, 20.0));
    }

    @Test
    public void testIntersectsLowerValueBelowUpperBoundaryAndUpperValueBelowLowerBoundary() {
        assertFalse(
            "Lower value (19) and upper value (-77) are invalid for a range, so intersects() should return False.",
            rangeObjectUnderTest.intersects(19.0, -77.0));
    }

    @Test
    public void testLowerValueAndUpperValueBelowUpperBoundary() {
        assertTrue("A range from 19 to 19 should overlap with a range from -76 to 20.",
            rangeObjectUnderTest.intersects(19.0, 19.0));
    }

    @Test
    public void testIntersectsLowerValueIsNominalAndUpperValueAboveLowerBoundary() {
        assertFalse(
            "Lower value (8) and upper value (-75) are invalid for a range, so intersects() should return False.",
            rangeObjectUnderTest.intersects(8.0, -75.0));
    }

    @Test
    public void testIntersectsLowerValueBelowLowerBoundaryAndUpperValueBelowUpperBoundary() {
        assertTrue("A range from -77 to 19 should overlap with a range from -76 to 20.",
            rangeObjectUnderTest.intersects(-77.0, 19.0));
    }

    @Test
    public void testIntersectsLowerValueOnLowerBoundaryAndUpperValueOnUpperBoundary() {
        assertTrue("A range from -76 to 20 should overlap with a range from -76 to 20.",
            rangeObjectUnderTest.intersects(-76.0, 20.0));
    }

    // Tests for Range.equals()

    @Test
    public void testEqualsLowerValueBelowUpperBoundaryAndUpperValueOnLowerBoundary() {
        try {
            Range comparisonRangeObject = new Range(19.0, -76.0);
            fail("Invalid Range object did not throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            return;
        } catch (Exception e) {
            fail("Invalid Range object raised an exception that was not an IllegalArgumentException.");
        }
    }

    @Test
    public void testEqualsLowerValueOnLowerBoundaryAndUpperValueOnUpperBoundary() {
        Range comparisonRangeObject = new Range(-76.0, 20.0);
        assertTrue("Both Range objects have the same lower and upper bounds; the objects should be equal.",
            rangeObjectUnderTest.equals(comparisonRangeObject));
    }

    @Test
    public void testEqualsLowerValueOnUpperBoundaryAndUpperValueAboveLowerBoundary() {
        try {
            Range comparisonRangeObject = new Range(20.0, -75.0);
            fail("Invalid Range object did not throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            return;
        } catch (Exception e) {
            fail("Invalid Range object raised an exception that was not an IllegalArgumentException.");
        }
    }

    @Test
    public void testEqualsLowerValueOnUpperBoundaryAndUpperValueAboveUpperBoundary() {
        Range comparisonRangeObject = new Range(20.0, 21.0);
        assertFalse("Both Range objects have different lower and upper bounds; the objects should not be equal.",
            rangeObjectUnderTest.equals(comparisonRangeObject));
    }

    @Test
    public void testEqualsLowerValueAndUpperValueBelowLowerBoundary() {
        Range comparisonRangeObject = new Range(-77.0, -77.0);
        assertFalse("Both Range objects have different lower and upper bounds; the objects should not be equal.",
            rangeObjectUnderTest.equals(comparisonRangeObject));
    }

    @Test
    public void testEqualsLowerValueBelowLowerBoundaryAndUpperValueOnUpperBoundary() {
        Range comparisonRangeObject = new Range(-77.0, 20.0);
        assertFalse("Both Range objects have different lower bounds; the objects should not be equal.",
            rangeObjectUnderTest.equals(comparisonRangeObject));
    }

    @Test
    public void testEqualsLowerValueAboveUpperBoundaryAndUpperValueBelowLowerBoundary() {
        try {
            Range comparisonRangeObject = new Range(21.0, -77.0);
            fail("Invalid Range object did not throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            return;
        } catch (Exception e) {
            fail("Invalid Range object raised an exception that was not an IllegalArgumentException.");
        }
    }

    @Test
    public void testEqualsLowerValueOnUpperBoundaryAndUpperValueOnLowerBoundary() {
        try {
            Range comparisonRangeObject = new Range(20.0, -76.0);
            fail("Invalid Range object did not throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            return;
        } catch (Exception e) {
            fail("Invalid Range object raised an exception that was not an IllegalArgumentException.");
        }
    }

    @Test
    public void testEqualsLowerValueIsNominalAndUpperValueOnUpperBoundary() {
        Range comparisonRangeObject = new Range(8.0, 20.0);
        assertFalse("Both Range objects have different lower bounds; the objects should not be equal.",
            rangeObjectUnderTest.equals(comparisonRangeObject));
    }

    @Test
    public void testEqualsLowerValueOnUpperBoundaryAndUpperValueBelowLowerBoundary() {
        try {
            Range comparisonRangeObject = new Range(20.0, -77.0);
            fail("Invalid Range object did not throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            return;
        } catch (Exception e) {
            fail("Invalid Range object raised an exception that was not an IllegalArgumentException.");
        }
    }

    // Tests for Range.expand()

    @Test
    public void testExpandLowerMarginValueOnUpperBoundaryAndUpperMarginValueAboveLowerBoundary() {
        rangeObjectUnderTest = Range.expand(rangeObjectUnderTest, 1.0, 0.01);
        Range expectedRange = new Range(-172.0, 20.96);
        assertTrue("New expanded range should have boundaries of -172 and 20.96.",
            rangeObjectUnderTest.equals(expectedRange));
    }

    @Test
    public void testExpandLowerMarginValueBelowLowerBoundaryAndUpperMarginValueAboveUpperBoundary() {
        rangeObjectUnderTest = Range.expand(rangeObjectUnderTest, -0.01, 1.01);
        Range expectedRange = new Range(-75.04, 116.96);
        assertTrue("New expanded range should have boundaries of -75.04 and 116.96.",
            rangeObjectUnderTest.equals(expectedRange));
    }

    @Test
    public void testExpandLowerMarginValueOnLowerBoundaryAndUpperMarginValueIsNominal() {
        rangeObjectUnderTest = Range.expand(rangeObjectUnderTest, 0.0, 0.5);
        Range expectedRange = new Range(-76.0, 68.0);
        assertTrue("New expanded range should have boundaries of -76 and 68.",
            rangeObjectUnderTest.equals(expectedRange));
    }

    @Test
    public void testExpandLowerMarginValueOnUpperBoundaryAndUpperMarginValueOnLowerBoundary() {
        rangeObjectUnderTest = Range.expand(rangeObjectUnderTest, 1.0, 0.0);
        Range expectedRange = new Range(-172.0, 20.0);
        assertTrue("New expanded range should have boundaries of -172 and 20.",
            rangeObjectUnderTest.equals(expectedRange));
    }

    @Test
    public void testExpandLowerMarginValueAboveUpperBoundaryAndUpperMarginValueIsNominal() {
        rangeObjectUnderTest = Range.expand(rangeObjectUnderTest, 1.01, 0.5);
        Range expectedRange = new Range(-172.96, 68.0);
        assertTrue("New expanded range should have boundaries of -172.96 and 68.",
            rangeObjectUnderTest.equals(expectedRange));
    }

    @Test
    public void testExpandLowerMarginValueAndUpperMarginValueBelowUpperBoundary() {
        rangeObjectUnderTest = Range.expand(rangeObjectUnderTest, 0.99, 0.99);
        Range expectedRange = new Range(-171.04, 115.04);
        assertTrue("New expanded range should have boundaries of -171.04 and 115.04.",
            rangeObjectUnderTest.equals(expectedRange));
    }

    @Test
    public void testExpandLowerMarginValueAboveLowerBoundaryAndUpperMarginValueOnLowerBoundary() {
        rangeObjectUnderTest = Range.expand(rangeObjectUnderTest, 0.01, 0.0);
        Range expectedRange = new Range(-76.96, 20.0);
        assertTrue("New expanded range should have boundaries of -76.96 and 20.",
            rangeObjectUnderTest.equals(expectedRange));
    }

    @Test
    public void testExpandLowerMarginValueOnLowerBoundaryAndUpperMarginValueBelowUpperBoundary() {
        rangeObjectUnderTest = Range.expand(rangeObjectUnderTest, 0.0, 0.99);
        Range expectedRange = new Range(-76.0, 115.04);
        assertTrue("New expanded range should have boundaries of -76 and 115.04.",
            rangeObjectUnderTest.equals(expectedRange));
    }

    @Test
    public void testExpandLowerMarginValueBelowLowerBoundaryAndUpperMarginValueIsNominal() {
        rangeObjectUnderTest = Range.expand(rangeObjectUnderTest, -0.01, 0.5);
        Range expectedRange = new Range(-75.04, 68.0);
        assertTrue("New expanded range should have boundaries of -75.04 and 68.",
            rangeObjectUnderTest.equals(expectedRange));
    }

    @Test
    public void testExpandLowerMarginValueOnUpperBoundaryAndUpperMarginValueAboveUpperBoundary() {
        rangeObjectUnderTest = Range.expand(rangeObjectUnderTest, 1.0, 1.01);
        Range expectedRange = new Range(-172.0, 116.96);
        assertTrue("New expanded range should have boundaries of -172 and 116.96.",
            rangeObjectUnderTest.equals(expectedRange));
    }

    // Tests for Range.expandToInclude()

    @Test
    public void testExpandToIncludeWithValueBelowLowerBoundary() {
        rangeObjectUnderTest = Range.expandToInclude(rangeObjectUnderTest, -77.0);
        Range expectedRange = new Range(-77.0, 20.0);
        assertTrue("New expanded range should have boundaries of -77 and 20.",
            rangeObjectUnderTest.equals(expectedRange));
    }

    @Test
    public void testExpandToIncludeWithValueOnLowerBoundary() {
        try {
            rangeObjectUnderTest = Range.expandToInclude(rangeObjectUnderTest, -76.0);
        } catch (IllegalArgumentException e) {
            fail("expandToInclude() threw an unexpected IllegalArgumentException.");
        }
        Range expectedRange = new Range(-76.0, 20.0);
        assertTrue("Range boundaries should remain unchanged from -76 and 20.",
            rangeObjectUnderTest.equals(expectedRange));
    }

    @Test
    public void testExpandToIncludeWithValueAboveLowerBoundary() {
        rangeObjectUnderTest = Range.expandToInclude(rangeObjectUnderTest, -75.0);
        Range expectedRange = new Range(-76.0, 20.0);
        assertTrue("Range boundaries should remain unchanged from -76 and 20.",
            rangeObjectUnderTest.equals(expectedRange));
    }

    @Test
    public void testExpandToIncludeWithNominalValue() {
        rangeObjectUnderTest = Range.expandToInclude(rangeObjectUnderTest, 8.0);
        Range expectedRange = new Range(-76.0, 20.0);
        assertTrue("Range boundaries should remain unchanged from -76 and 20.",
            rangeObjectUnderTest.equals(expectedRange));
    }

    @Test
    public void testExpandToIncludeWithValueBelowUpperBoundary() {
        rangeObjectUnderTest = Range.expandToInclude(rangeObjectUnderTest, 19.0);
        Range expectedRange = new Range(-76.0, 20.0);
        assertTrue("Range boundaries should remain unchanged from -76 and 20.",
            rangeObjectUnderTest.equals(expectedRange));
    }

    @Test
    public void testExpandToIncludeWithValueOnUpperBoundary() {
        rangeObjectUnderTest = Range.expandToInclude(rangeObjectUnderTest, 20.0);
        Range expectedRange = new Range(-76.0, 20.0);
        assertTrue("Range boundaries should remain unchanged from -76 and 20.",
            rangeObjectUnderTest.equals(expectedRange));
    }

    @Test
    public void testExpandToIncludeWithValueAboveUpperBoundary() {
        rangeObjectUnderTest = Range.expandToInclude(rangeObjectUnderTest, 21.0);
        Range expectedRange = new Range(-76.0, 21.0);
        assertTrue("New expanded range should have boundaries of -76 and 21.",
            rangeObjectUnderTest.equals(expectedRange));
    }
}
