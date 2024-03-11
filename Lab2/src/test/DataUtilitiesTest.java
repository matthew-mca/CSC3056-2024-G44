package test;

//
//import junit.framework.TestCase;
//
//import static org.junit.Assert.assertTrue;
//import org.junit.*;
//import org.jfree.data.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
//import org.jfree.data.Values2D;
//import org.junit.*;

import org.jfree.data.Values2D;
//import org.jfree.data.DataUtilities;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertArrayEquals

public class DataUtilitiesTest {
	private Values2D values2D;

	@Before
	public void setUp() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		Object outOfBoundsData = createValues2D(new double[][] { { 2 }, { 3 } });
		// nullData is not initialized as it's meant to be null
	}

	@After
	public void tearDown() {
		values2D = null;
	}

	// Tests for DataUtilities.calculateColumnTotal()
	// Test Case 3.1.1.1
	@Test
	public void testCalculateColumnTotalWithPositiveValues() {
		double result = DataUtilities.calculateColumnTotal(validData, 0);
		assertEquals("Should calculate the sum of positive values in the column", 5.0, result, 0.00001);
	}

	// Test Case 3.1.1.2
	@Test
	public void testCalculateColumnTotalWithNegativeValues() {
		double result = DataUtilities.calculateColumnTotal(validData, 0);
		assertEquals("Should calculate the sum of negative values in the column", -5.0, result, 0.00001);
	}

	// Test Case 3.1.1.3
	@Test
	public void testCalculateColumnTotalWithMixedValues() {
		double result = DataUtilities.calculateColumnTotal(validData, 0);
		assertEquals("Should calculate the sum of mixed values in the column", 1.0, result, 0.00001);
	}

	// Test Case 3.1.1.4
	@Test
	public void testCalculateColumnTotalWithZeros() {
		Values2D dataWithZeros = createValues2D(new double[][] { { 0 }, { 0 } });
		double result = DataUtilities.calculateColumnTotal(dataWithZeros, 0);
		assertEquals("Should calculate the sum of a column with zeros", 0.0, result, 0.00001);
	}

	// Test Case 3.1.1.5
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateColumnTotalWithNullData() {
		DataUtilities.calculateColumnTotal(null, 0);
	}

	// Test Case 3.1.1.6
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCalculateColumnTotalWithOutOfBoundsColumn() {
		thrown.expect(IndexOutOfBoundsException.class);
		DataUtilities.calculateColumnTotal(outOfBoundsData, 1);
	}

	}

// Tests for DataUtilities.calculateRowTotal()
	// Test Case 3.1.2.1
	@Test
	public void testCalculateColumnTotalWithPositive() {
		assertEquals("Column total with positive values", 5.0, DataUtilities.calculateColumnTotal(dataWithPositive, 0),
				0.00001);
	}

	// Test Case 3.1.2.2
	@Test
	public void testCalculateColumnTotalWithNegative() {
		assertEquals("Column total with negative values", -5.0, DataUtilities.calculateColumnTotal(dataWithNegative, 0),
				0.00001);
	}

	// Test Case 3.1.2.3
	@Test
	public void testCalculateColumnTotalWithMixed() {
		assertEquals("Column total with mixed values", 1.0, DataUtilities.calculateColumnTotal(dataWithMixed, 0),
				0.00001);
	}

	// Test Case 3.1.2.4
	@Test
	public void testCalculateRowTotalWithZeros() {
		assertEquals("Column total with zeros", 0.0, DataUtilities.calculateColumnTotal(dataWithZeros, 0), 0.00001);
	}

	// Test Case 3.1.2.5
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateColumnTotalWithNull() {
		DataUtilities.calculateColumnTotal(null, 0);
	}

	// Test Case 3.1.2.6
	@Test
	public void testCalculateColumnTotalOutOfBounds() {
		thrown.expect(IndexOutOfBoundsException.class);
		DataUtilities.calculateColumnTotal(dataSingleColumn, 1);
	}

// Tests for DataUtilities.createNumberArray()
	// Test Case 3.1.3.1
	@Test
	public void testCreateNumberArrayWithPositiveNumbers() {
		double[] inputData = { 1.0, 2.0, 3.0 };
		Number[] expected = { 1.0, 2.0, 3.0 };
		Number[] actual = NumberArrayCreator.createNumberArray(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.3.2
	@Test
	public void testCreateNumberArrayWithNegativeNumbers() {
		double[] inputData = { -1.0, -2.0, -3.0 };
		Number[] expected = { -1.0, -2.0, -3.0 };
		Number[] actual = NumberArrayCreator.createNumberArray(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.3.3
	@Test
	public void testCreateNumberArrayWithMixedPositiveAndNegativeNumbers() {
		double[] inputData = { 1.0, -1.0, 0.0 };
		Number[] expected = { 1.0, -1.0, 0.0 };
		Number[] actual = NumberArrayCreator.createNumberArray(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.3.4
	@Test
	public void testCreateNumberArrayWithNumberValuesBeingZerosOnly() {
		double[] inputData = { 1.0, -1.0, 0.0 };
		Number[] expected = { 1.0, -1.0, 0.0 };
		Number[] actual = NumberArrayCreator.createNumberArray(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.3.5
	@Test
	public void testCreateNumberArrayWithSingleElement() {
		double[] inputData = { 42.0 };
		Number[] expected = { 42.0 };
		Number[] actual = NumberArrayCreator.createNumberArray(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.3.6
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArrayWithNull() {
		NumberArrayCreator.createNumberArray(null);
	}

	// Test Case 3.1.3.7
	@Test
	public void testCreateNumberArrayWithEmpty() {
		double[] inputData = {};
		Number[] expected = {};
		Number[] actual = NumberArrayCreator.createNumberArray(inputData);
		assertArrayEquals(expected, actual);
	}

}

// Tests for DataUtilities.createNumberArray2D()
// Test Case 3.1.4.1
	@Test
	public void testCreateNumberArray2DWithTwoArraysOfPositiveNumbers() {
		double[][] inputData = { { 1.0, 2.0 }, { 3.0, 4.0 } };
		Number[][] expected = { { 1.0, 2.0 }, { 3.0, 4.0 } };
		Number[][] actual = NumberArrayCreator.createNumberArray2D(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.4.2
	@Test
	public void testCreateNumberArray2DWithTwoArraysOfNegativeNumbers() {
		double[][] inputData = { { -1.0, -2.0 }, { -3.0, -4.0 } };
		Number[][] expected = { { -1.0, -2.0 }, { -3.0, -4.0 } };
		Number[][] actual = NumberArrayCreator.createNumberArray2D(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.4.3
	@Test
	public void testCreateNumberArray2DWithTwoArraysOfMixedPositiveAndNegativeNumbers() {
		double[][] inputData = { { 1.0, -1.0 }, { -2.0, 2.0 } };
		Number[][] expected = { { 1.0, -1.0 }, { -2.0, 2.0 } };
		Number[][] actual = NumberArrayCreator.createNumberArray2D(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.4.4
	@Test
	public void testCreateNumberArray2DWithTwoArraysOfOnlyZeros() {
		double[][] inputData = { { 0.0, 0.0 }, { 0.0, 0.0 } };
		Number[][] expected = { { 0.0, 0.0 }, { 0.0, 0.0 } };
		Number[][] actual = NumberArrayCreator.createNumberArray2D(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.4.5
	@Test
	public void testCreateNumberArray2DWithOnlySingleElementInEach() {
		double[][] inputData = { { 42.0 }, { 27.0 } };
		Number[][] expected = { { 42.0 }, { 27.0 } };
		Number[][] actual = NumberArrayCreator.createNumberArray2D(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.4.6
	@Test
	public void testCreateNumberArray2DWithTwoArraysOfVaryingLengths() {
		double[][] inputData = { { 1.0, 2.0 }, {}, { 3.0 } };
		Number[][] expected = { { 1.0, 2.0 }, {}, { 3.0 } };
		Number[][] actual = NumberArrayCreator.createNumberArray2D(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.4.7
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArray2DWithNull() {
		NumberArrayCreator.createNumberArray2D(null);
	}

	// Test Case 3.1.4.8
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNumberArray2DWithTwoArraysAndOneContainsNullSubArray() {
		double[][] inputData = { { 1.0, 2.0 }, null, { 3.0 } };
		NumberArrayCreator.createNumberArray2D(inputData);
	}

	// Test Case 3.1.4.9
	@Test
	public void testCreateNumberArray2DTwoArraysAreBothEmpty() {
		double[][] inputData = {};
		Number[][] expected = {};
		Number[][] actual = NumberArrayCreator.createNumberArray2D(inputData);
		assertArrayEquals(expected, actual);
	}

	// Test Case 3.1.4.10
	@Test
	public void testCreateNumberArray2DWithEmptySubArray() {
		double[][] inputData = { {}, { 1.0, 2.0 } };
		Number[][] expected = { {}, { 1.0, 2.0 } };
		Number[][] actual = NumberArrayCreator.createNumberArray2D(inputData);
		assertArrayEquals(expected, actual);
	}

}

// Tests for DataUtilities.getCumulativePercentages()
// Test Case 3.1.5.1
	@Test
	public void testGetCumulativePercentagesNormalCase() {
		KeyedValues input = new KeyedValues();
		input.addValue(0, 5);
		input.addValue(1, 9);
		input.addValue(2, 2);

		KeyedValues expected = new KeyedValues();
		expected.addValue(0, 0.3125);
		expected.addValue(1, 0.875);
		expected.addValue(2, 1.0);

		KeyedValues actual = KeyedValuesUtils.getCumulativePercentages(input);
		assertEquals(expected, actual);
	}

	// Test Case 3.1.5.2
	@Test
	public void testGetCumulativePercentagesWithZero() {
		KeyedValues input = new KeyedValues();
		input.addValue(0, 0);
		input.addValue(1, 9);
		input.addValue(2, 2);

		KeyedValues expected = new KeyedValues();
		expected.addValue(0, 0.0);
		expected.addValue(1, 0.8182);
		expected.addValue(2, 1.0);

		KeyedValues actual = KeyedValuesUtils.getCumulativePercentages(input);
		assertEquals(expected, actual);
	}

	// Test Case 3.1.5.3
	@Test
	public void testGetCumulativePercentagesNonSequentialKeys() {
		KeyedValues input = new KeyedValues();
		input.addValue(2, 2);
		input.addValue(1, 9);
		input.addValue(0, 5);

		KeyedValues expected = new KeyedValues();
		expected.addValue(2, 0.125);
		expected.addValue(1, 0.9375);
		expected.addValue(0, 1.0);

		KeyedValues actual = KeyedValuesUtils.getCumulativePercentages(input);
		assertEquals(expected, actual);
	}

	// Test Case 3.1.5.4
	@Test
	public void testGetCumulativePercentagesSingleValue() {
		KeyedValues input = new KeyedValues();
		input.addValue(0, 42);

		KeyedValues expected = new KeyedValues();
		expected.addValue(0, 1.0);

		KeyedValues actual = KeyedValuesUtils.getCumulativePercentages(input);
		assertEquals(expected, actual);
	}

	// Test Case 3.1.5.5
	@Test(expected = IllegalArgumentException.class)
	public void testGetCumulativePercentagesNullInput() {
		KeyedValuesUtils.getCumulativePercentages(null);
	}

}}

