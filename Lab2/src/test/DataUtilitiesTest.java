package test;

import junit.framework.TestCase;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.junit.*;

import static org.junit.Assert.assertArrayEquals;

public class DataUtilitiesTest extends TestCase {
	private DefaultKeyedValues2D values2D;

	@Before
	public void setUp() {
		values2D = new DefaultKeyedValues2D();
	}

	@After
	public void tearDown() {
		values2D = null;
	}

	// Tests for DataUtilities.calculateColumnTotal()
	// Test Case 3.1.1.1
	@Test
	public void testCalculateColumnTotalWithPositiveValues() {
		values2D.addValue(2, 1, 0);
		values2D.addValue(3, 0, 0);

		double result = DataUtilities.calculateColumnTotal(values2D, 0);
		assertEquals("Return calculated the sum of positive values in the column, should be 5", 5.0, result, 0.00001);
	}

	// Test Case 3.1.1.2
	@Test
	public void testCalculateColumnTotalWithNegativeValues() {
		values2D.addValue(-2, 1, 0);
		values2D.addValue(-3, 0, 0);
		double result = DataUtilities.calculateColumnTotal(values2D, 0);
		assertEquals("Return calculated the sum of negative values in the column, should be -5", -5.0, result, 0.00001);
	}
	// Test Case 3.1.1.3
	@Test
	public void testCalculateColumnTotalWithMixedValues() {

		values2D.addValue(-2, 1, 0);
		values2D.addValue(3, 0, 0);
		double result = DataUtilities.calculateColumnTotal(values2D, 0);
		assertEquals("Return calculated the sum of mixed values in the column, should be 1", 1.0, result, 0.00001);
	}

	// Test Case 3.1.1.4
	@Test
	public void testCalculateColumnTotalWithZeros() {
		values2D.addValue(0, 1, 0);
		values2D.addValue(0, 0, 0);
		double result = DataUtilities.calculateColumnTotal(values2D, 0);
		assertEquals("Return calculated the sum of a column with only zeros, should be 0", 0.0, result, 0.00001);
	}

	// Test Case 3.1.1.5
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateColumnTotalWithNullData() {
		DataUtilities.calculateColumnTotal(null, 0);
	}

	// Test Case 3.1.1.6
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCalculateColumnTotalWithOutOfBoundsColumn() {
		values2D.addValue(2, 0, 0);
		values2D.addValue(-3, 1, 0);
		DataUtilities.calculateColumnTotal(values2D, 1);
	}

// Tests for DataUtilities.calculateRowTotal()
	// Test Case 3.1.2.1
	@Test
	public void testCalculateRowTotalWithPositive() {
		values2D.addValue(2, 0, 0);
		values2D.addValue(3, 0, 1);
		assertEquals("Column total with positive values, should be 5", 2.0, DataUtilities.calculateColumnTotal(values2D, 0),
				0.00001);
	}

	// Test Case 3.1.2.2
	@Test
	public void testCalculateRowTotalWithNegative() {
		values2D.addValue(-2, 0, 0);
		values2D.addValue(-3, 0, 1);
		assertEquals("Column total with negative values", -2.0, DataUtilities.calculateColumnTotal(values2D, 0),
				0.00001);
	}

	// Test Case 3.1.2.3
	@Test
	public void testCalculateRowTotalWithMixed() {
		values2D.addValue(-2, 0, 0);
		values2D.addValue(3, 0, 1);
		assertEquals("Column total with mixed values, should be -2", -2.0, DataUtilities.calculateColumnTotal(values2D, 0),
				0.00001);
	}

	// Test Case 3.1.2.4
	@Test
	public void testCalculateRowTotalWithZeros() {
		values2D.addValue(0, 0, 0);
		values2D.addValue(0, 0, 1);
		double result = DataUtilities.calculateRowTotal(values2D, 0);
		assertEquals("Row total with zeros, should be 0", 0.0, result, 0.00001);
	}

	// Test Case 3.1.2.5
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateRowTotalWithNull() {
		DataUtilities.calculateRowTotal(null, 0);
	}

	// Test Case 3.1.2.6
	@Test
	public void testCalculateColumnTotalOutOfBounds() {
		values2D.addValue(2, 0, 0);
		DataUtilities.calculateRowTotal(values2D, 1);
	}

// Tests for DataUtilities.createNumberArray()
	// Test Case 3.1.3.1
	@Test
	public void testCreateNumberArrayWithPositiveNumbers() {
		double[] inputData = { 1.0, 2.0, 3.0 };
		Number[] expected = { 1.0, 2.0, 3.0 };
		Number[] actual = DataUtilities.createNumberArray(inputData);
		assertArrayEquals("Arrays with positive numbers should match", expected, actual);
	}

	// Test Case 3.1.3.2
	@Test
	public void testCreateNumberArrayWithNegativeNumbers() {
		double[] inputData = { -1.0, -2.0, -3.0 };
		Number[] expected = { -1.0, -2.0, -3.0 };
		Number[] actual = DataUtilities.createNumberArray(inputData);
		assertArrayEquals("Arrays with negative numbers should match", expected, actual);
	}

	// Test Case 3.1.3.3
	@Test
	public void testCreateNumberArrayWithMixedPositiveAndNegativeNumbers() {
		double[] inputData = { 1.0, -1.0, 2.0 };
		Number[] expected = { 1.0, -1.0, 2.0 };
		Number[] actual = DataUtilities.createNumberArray(inputData);
		assertArrayEquals("Arrays with mixed positive and negative numbers should match", expected, actual);
	}

	// Test Case 3.1.3.4
	@Test
	public void testCreateNumberArrayWithNumberValuesBeingZerosOnly() {
		double[] inputData = { 0.0, 0.0, 0.0, 0.0 };
		Number[] expected = { 0.0, 0.0, 0.0, 0.0 };
		Number[] actual = DataUtilities.createNumberArray(inputData);
		assertArrayEquals("Arrays with zeros should match", expected, actual);
	}

	// Test Case 3.1.3.5
	@Test
	public void testCreateNumberArrayWithSingleElement() {
		double[] inputData = { 42.0 };
		Number[] expected = { 42.0 };
		Number[] actual = DataUtilities.createNumberArray(inputData);
		assertArrayEquals("Single element arrays should match", expected, actual);
	}

	// Test Case 3.1.3.6
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArrayWithNull() {
		DataUtilities.createNumberArray(null);
	}

	// Test Case 3.1.3.7
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArrayWithEmpty() {
		double[] inputData = {};
		DataUtilities.createNumberArray(inputData);
	}

// Tests for DataUtilities.createNumberArray2D()
// Test Case 3.1.4.1
	@Test
	public void testCreateNumberArray2DWithTwoArraysOfPositiveNumbers() {
		double[][] inputData = { { 1.0, 2.0 }, { 3.0, 4.0 } };
		Number[][] expected = { { 1.0, 2.0 }, { 3.0, 4.0 } };
		Number[][] actual = DataUtilities.createNumberArray2D(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.4.2
	@Test
	public void testCreateNumberArray2DWithTwoArraysOfNegativeNumbers() {
		double[][] inputData = { { -1.0, -2.0 }, { -3.0, -4.0 } };
		Number[][] expected = { { -1.0, -2.0 }, { -3.0, -4.0 } };
		Number[][] actual = DataUtilities.createNumberArray2D(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.4.3
	@Test
	public void testCreateNumberArray2DWithTwoArraysOfMixedPositiveAndNegativeNumbers() {
		double[][] inputData = { { 1.0, -1.0 }, { -2.0, 2.0 } };
		Number[][] expected = { { 1.0, -1.0 }, { -2.0, 2.0 } };
		Number[][] actual = DataUtilities.createNumberArray2D(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.4.4
	@Test
	public void testCreateNumberArray2DWithTwoArraysOfOnlyZeros() {
		double[][] inputData = { { 0.0, 0.0 }, { 0.0, 0.0 } };
		Number[][] expected = { { 0.0, 0.0 }, { 0.0, 0.0 } };
		Number[][] actual = DataUtilities.createNumberArray2D(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.4.5
	@Test
	public void testCreateNumberArray2DWithOnlySingleElementInEach() {
		double[][] inputData = { { 42.0 }, { 27.0 } };
		Number[][] expected = { { 42.0 }, { 27.0 } };
		Number[][] actual = DataUtilities.createNumberArray2D(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.4.6
	@Test
	public void testCreateNumberArray2DWithTwoArraysOfVaryingLengths() {
		double[][] inputData = { { 1.0, 2.0 }, {}, { 3.0 } };
		Number[][] expected = { { 1.0, 2.0 }, {}, { 3.0 } };
		Number[][] actual = DataUtilities.createNumberArray2D(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.4.7
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArray2DWithNull() {
		DataUtilities.createNumberArray2D(null);
	}

	// Test Case 3.1.4.8
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArray2DWithTwoArraysAndOneContainsNullSubArray() {
		double[][] inputData = { { 1.0, 2.0 }, null, { 3.0 } };
		DataUtilities.createNumberArray2D(inputData);
	}

	// Test Case 3.1.4.9
	@Test
	public void testCreateNumberArray2DTwoArraysAreBothEmpty() {
		double[][] inputData = {};
		Number[][] expected = {};
		Number[][] actual = DataUtilities.createNumberArray2D(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.4.10
	@Test
	public void testCreateNumberArray2DWithEmptySubArray() {
		double[][] inputData = { {}, { 1.0, 2.0 } };
		Number[][] expected = { {}, { 1.0, 2.0 } };
		Number[][] actual = DataUtilities.createNumberArray2D(inputData);
		assertArrayEquals(expected, actual);
	}
}
//
//// Tests for DataUtilities.getCumulativePercentages()
//// Test Case 3.1.5.1
//@Test
//public void testGetCumulativePercentagesNormalCase() {
//	KeyedValues input = DataUtilities(new double[]{5, 9, 2});
//	KeyedValues expected = createKeyedValues(new double[]{0.3125, 0.875, 1.0});
//
//	KeyedValues actual = DataUtilities.getCumulativePercentages(input);
//	for (int i = 0; i < actual.getItemCount(); i++) {
//		assertEquals("Cumulative percentage doesn't match", expected.getValue(i).doubleValue(), actual.getValue(i).doubleValue(), 0.0001);
//	}
//}
//	// Test Case 3.1.5.2
//	@Test
//	public void testGetCumulativePercentagesWithZero() {
//		KeyedValues input = DataUtilities(new double[]{0, 9, 2});
//		KeyedValues expected = DataUtilities(new double[]{0.0, 0.8182, 1.0});
//
//		KeyedValues actual = DataUtilities.getCumulativePercentages(input);
//		for (int i = 0; i < actual.getItemCount(); i++) {
//			assertEquals("Cumulative percentage doesn't match", expected.getValue(i).doubleValue(), actual.getValue(i).doubleValue(), 0.0001);
//		}
//	}
//
//	// Test Case 3.1.5.3
//	@Test
//	public void testGetCumulativePercentagesNonSequentialKeys() {
//		DefaultKeyedValues input = new DefaultKeyedValues();
//		input.addValue(2, 2);
//		input.addValue(1, 9);
//		input.addValue(0, 5);
//
//		DefaultKeyedValues expected = new DefaultKeyedValues();
//		expected.addValue(2, 0.125);
//		expected.addValue(1, 0.9375);
//		expected.addValue(0, 1.0);
//
//		KeyedValues actual = DataUtilities.getCumulativePercentages(input);
//		for (int i = 0; i < actual.getItemCount(); i++) {
//			assertEquals("Cumulative percentage doesn't match for non-sequential keys",
//					expected.getValue(i).doubleValue(), actual.getValue(i).doubleValue(), 0.0001);
//		}
//	}
//
//	// Test Case 3.1.5.4
//	@Test
//	public void testGetCumulativePercentagesSingleValue() {
//		KeyedValues input = createKeyedValues(new double[]{42});
//		KeyedValues expected = createKeyedValues(new double[]{1.0});
//
//		KeyedValues actual = DataUtilities.getCumulativePercentages(input);
//		for (int i = 0; i < actual.getItemCount(); i++) {
//			assertEquals("Cumulative percentage for single value doesn't match", expected.getValue(i).doubleValue(), actual.getValue(i).doubleValue(), 0.0001);
//		}
//	}
//
//	// Test Case 3.1.5.5
//	@Test(expected = IllegalArgumentException.class)
//	public void testGetCumulativePercentagesNullInput() {
//		DataUtilities.getCumulativePercentages(null);
//	}
//}
