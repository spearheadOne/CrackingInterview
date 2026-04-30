package org.abondar.experimental.problems.arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArraysTest {

    private final Arrays arrayTasks = new Arrays();

    private static Stream<Arguments> rotateParams() {

        int[][] matrixThree = new int[3][3];
        matrixThree[0][0] = 1;
        matrixThree[0][1] = 2;
        matrixThree[0][2] = 3;
        matrixThree[1][0] = 4;
        matrixThree[1][1] = 5;
        matrixThree[1][2] = 6;
        matrixThree[2][0] = 7;
        matrixThree[2][1] = 8;
        matrixThree[2][2] = 9;

        int[][] expectedMatrixThree = new int[3][3];
        expectedMatrixThree[0][0] = 7;
        expectedMatrixThree[0][1] = 4;
        expectedMatrixThree[0][2] = 1;
        expectedMatrixThree[1][0] = 8;
        expectedMatrixThree[1][1] = 5;
        expectedMatrixThree[1][2] = 2;
        expectedMatrixThree[2][0] = 9;
        expectedMatrixThree[2][1] = 6;
        expectedMatrixThree[2][2] = 3;


        int[][] matrixFour = new int[4][4];
        matrixFour[0][0] = 1;
        matrixFour[0][1] = 2;
        matrixFour[0][2] = 3;
        matrixFour[0][3] = 4;
        matrixFour[1][0] = 5;
        matrixFour[1][1] = 6;
        matrixFour[1][2] = 7;
        matrixFour[1][3] = 8;
        matrixFour[2][0] = 9;
        matrixFour[2][1] = 10;
        matrixFour[2][2] = 11;
        matrixFour[2][3] = 12;
        matrixFour[3][0] = 13;
        matrixFour[3][1] = 14;
        matrixFour[3][2] = 15;
        matrixFour[3][3] = 16;

        int[][] expectedMatrixFour = new int[4][4];
        expectedMatrixFour[0][0] = 13;
        expectedMatrixFour[0][1] = 9;
        expectedMatrixFour[0][2] = 5;
        expectedMatrixFour[0][3] = 1;
        expectedMatrixFour[1][0] = 14;
        expectedMatrixFour[1][1] = 10;
        expectedMatrixFour[1][2] = 6;
        expectedMatrixFour[1][3] = 2;
        expectedMatrixFour[2][0] = 15;
        expectedMatrixFour[2][1] = 11;
        expectedMatrixFour[2][2] = 7;
        expectedMatrixFour[2][3] = 3;
        expectedMatrixFour[3][0] = 16;
        expectedMatrixFour[3][1] = 12;
        expectedMatrixFour[3][2] = 8;
        expectedMatrixFour[3][3] = 4;


        return Stream.of(
                Arguments.of(matrixThree, expectedMatrixThree),
                Arguments.of(matrixFour, expectedMatrixFour)
        );
    }

    private static Stream<Arguments> zeroParams() {
        int[][] zeroMatrix = new int[3][3];
        zeroMatrix[0][0] = 1;
        zeroMatrix[0][1] = 2;
        zeroMatrix[0][2] = 3;
        zeroMatrix[1][0] = 0;
        zeroMatrix[1][1] = 5;
        zeroMatrix[1][2] = 6;
        zeroMatrix[2][0] = 7;
        zeroMatrix[2][1] = 8;
        zeroMatrix[2][2] = 9;

        int[][] expectedZeroMatrix = new int[3][3];
        expectedZeroMatrix[0][0] = 0;
        expectedZeroMatrix[0][1] = 2;
        expectedZeroMatrix[0][2] = 3;
        expectedZeroMatrix[1][0] = 0;
        expectedZeroMatrix[1][1] = 0;
        expectedZeroMatrix[1][2] = 0;
        expectedZeroMatrix[2][0] = 0;
        expectedZeroMatrix[2][1] = 8;
        expectedZeroMatrix[2][2] = 9;


        int[][] doubleZeroMatrix = new int[3][3];
        doubleZeroMatrix[0][0] = 1;
        doubleZeroMatrix[0][1] = 2;
        doubleZeroMatrix[0][2] = 3;
        doubleZeroMatrix[1][0] = 0;
        doubleZeroMatrix[1][1] = 5;
        doubleZeroMatrix[1][2] = 6;
        doubleZeroMatrix[2][0] = 7;
        doubleZeroMatrix[2][1] = 0;
        doubleZeroMatrix[2][2] = 9;

        int[][] expectedDoubleZeroMatrix = new int[3][3];
        expectedDoubleZeroMatrix[0][0] = 0;
        expectedDoubleZeroMatrix[0][1] = 0;
        expectedDoubleZeroMatrix[0][2] = 3;
        expectedDoubleZeroMatrix[1][0] = 0;
        expectedDoubleZeroMatrix[1][1] = 0;
        expectedDoubleZeroMatrix[1][2] = 0;
        expectedDoubleZeroMatrix[2][0] = 0;
        expectedDoubleZeroMatrix[2][1] = 0;
        expectedDoubleZeroMatrix[2][2] = 0;

        return Stream.of(
                Arguments.of(zeroMatrix, expectedZeroMatrix),
                Arguments.of(doubleZeroMatrix, expectedDoubleZeroMatrix)
        );
    }

    static Stream<Arguments> calcUniqueParams() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 5, new int[]{0, 1, 2, 3, 4})
        );
    }

    static Stream<Arguments> dupParams() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[]{0, 1, 2, 3, 4}),
                Arguments.of(new int[]{5, 2, 5, 5, 6, 6, 10}, new int[]{5, 2, 6, 10})
        );
    }

    static Stream<Arguments> valParams() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 2, 3}, 3, 2, new int[]{2, 2}),
                Arguments.of(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, 5, new int[]{0, 1, 3, 0, 4})
        );
    }

    private static Stream<Arguments> searchInsertParams() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 6}, 5, 2),
                Arguments.of(new int[]{1, 3, 5, 6}, 2, 1),
                Arguments.of(new int[]{1, 3, 5, 6}, 7, 4),
                Arguments.of(new int[]{1, 3, 5, 6}, 0, 0),
                Arguments.of(new int[]{1, 3}, 3, 1),
                Arguments.of(new int[]{1, 3}, 1, 0),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 10}, 2, 1),
                Arguments.of(new int[]{3, 4, 8, 9, 10}, 8, 2)
        );
    }

    private static Stream<Arguments> fairIndexParams() {
        return Stream.of(
                Arguments.of(new int[]{4, -1, 0, 3}, new int[]{-2, 5, 0, 3}, 2),
                Arguments.of(new int[]{2, -2, -3, 3}, new int[]{0, 0, 4, -4}, 1),
                Arguments.of(new int[]{4, -1, 0, 3}, new int[]{-2, 6, 0, 4}, 0),
                Arguments.of(new int[]{3, 2, 6}, new int[]{4, 1, 6}, 0),
                Arguments.of(new int[]{1, 4, 2, -2, 5}, new int[]{7, -2, -2, 2, 5}, 2)
        );
    }

    static Stream<Arguments> plusOneParams() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
                Arguments.of(new int[]{1, 2, 9}, new int[]{1, 3, 0}),
                Arguments.of(new int[]{1, 9, 9}, new int[]{2, 0, 0}),
                Arguments.of(new int[]{9, 9, 9}, new int[]{1, 0, 0, 0})
        );
    }

    static Stream<Arguments> singleNumberParams() {
        return Stream.of(
                Arguments.of(new int[]{2, 2, 1}, 1),
                Arguments.of(new int[]{4, 1, 2, 1, 2}, 4)

        );
    }

    static Stream<Arguments> tvParams() {
        return Stream.of(
                Arguments.of(
                        new ArrayList<>(List.of(new TimeSlot(1, 4), new TimeSlot(2, 6))),
                        5
                ),
                Arguments.of(
                        new ArrayList<>(List.of(new TimeSlot(4, 6), new TimeSlot(1, 2))),
                        3
                ),
                Arguments.of(
                        new ArrayList<>(List.of(new TimeSlot(4, 6), new TimeSlot(1, 2), new TimeSlot(1, 2))),
                        3
                ),
                Arguments.of(
                        new ArrayList<>(List.of(
                                new TimeSlot(1, 4), new TimeSlot(6, 8),
                                new TimeSlot(2, 4), new TimeSlot(7, 9),
                                new TimeSlot(10, 15)
                        )),
                        11
                ),
                Arguments.of(
                        new ArrayList<>(List.of(
                                new TimeSlot(1, 4), new TimeSlot(6, 8),
                                new TimeSlot(2, 4), new TimeSlot(7, 12),
                                new TimeSlot(10, 15)
                        )),
                        12
                )
        );
    }

    static Stream<Arguments> tripletParams() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(3, 2, 1), List.of(1, 1)),
                Arguments.of(List.of(5, 6, 7), List.of(3, 6, 10), List.of(1, 1)),
                Arguments.of(List.of(17, 28, 30), List.of(99, 16, 8), List.of(2, 1))
        );
    }


    static Stream<Arguments> diagParams() {
        return Stream.of(
                Arguments.of(List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(9, 8, 9)), 2),
                Arguments.of(List.of(List.of(11, 2, 4), List.of(4, 5, 6), List.of(10, 8, -12)), 15)
        );
    }


    static Stream<Arguments> minimaxSumParams() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), 10, 14),
                Arguments.of(List.of(256741038, 623958417, 467905213, 714532089, 938071625), 2063136757L, 2744467344L)
        );
    }

    static Stream<Arguments> candleParams() {
        return Stream.of(
                Arguments.of(List.of(4, 4, 1, 3), 2),
                Arguments.of(List.of(3, 2, 1, 3), 2)
        );
    }

    static Stream<Arguments> distanceParams() {
        return Stream.of(
                Arguments.of(new int[]{0, 5, 15, 23}, new int[]{11, 12, 18, 22, 30, 40, 50}, 1),
                Arguments.of(new int[]{1, 3, 5}, new int[]{2, 3, 4}, 0),
                Arguments.of(new int[]{10}, new int[]{25}, 15),
                Arguments.of(new int[]{-10, -5, 0}, new int[]{3, 8, 20}, 3),
                Arguments.of(new int[]{-20, -10, -3}, new int[]{-8, -2, 4}, 1),
                Arguments.of(new int[]{1, 100, 200}, new int[]{2, 300, 400}, 1),
                Arguments.of(new int[]{1, 50, 99}, new int[]{20, 80, 100}, 1),
                Arguments.of(new int[]{1, 1, 1, 10}, new int[]{5, 6, 10}, 0),
                Arguments.of(new int[]{1, 1000}, new int[]{100, 200, 300, 400, 500}, 99),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}, 0),
                Arguments.of(new int[]{1, 2, 3}, new int[]{100, 200, 300}, 97)
        );
    }

    static Stream<Arguments> treeNodeParams() {
        return Stream.of(
                Arguments.of(new int[]{2, 4, 5, 1, 7, 2, 6}, new int[]{2, 4, 1}),
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{10}, new int[]{10}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 4}),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
                        new int[]{1, 2, 4, 8}
                ),
                Arguments.of(new int[]{-1, -2, -3, -4, -5}, new int[]{-1, -2, -4})
        );
    }

    static Stream<Arguments> treeRowsParams() {

        return Stream.of(
                Arguments.of(null, new int[0][0]),
                Arguments.of(new int[]{}, new int[0][0]),
                Arguments.of(new int[]{10}, new int[][]{{10}}),
                Arguments.of(new int[]{1, 2, 3}, new int[][]{{1}, {2, 3}}),
                Arguments.of(new int[]{2, 4, 5, 1, 7, 2, 6}, new int[][]{
                                {2},
                                {4, 5},
                                {1, 7, 2, 6}
                        }
                ),
                Arguments.of(new int[]{1, 2, 3, 4, 5},
                        new int[][]{{1}, {2, 3}, {4, 5}}
                ),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
                        new int[][]{{1}, {2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14, 15}}),
                Arguments.of(new int[]{-1, -2, -3, -4}, new int[][]{{-1}, {-2, -3}, {-4}})
        );

    }

    @Test
    public void sumTest() {
        int[] arr = {2, 7, 10, 11};
        int res = arrayTasks.sum(arr);
        int expected = 30;
        assertEquals(expected, res);
    }

    @Test
    public void sumListTest() {
        var arr = List.of(1, 2, 3, 4, 10, 11);
        var res = arrayTasks.sumList(arr);
        assertEquals(31, res);
    }

    @Test
    public void twoSumTest() {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        int[] actual = arrayTasks.twoSum(arr, target);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void lenTest() {
        int[] arr = {2, 7, 10, 11};
        int res = arrayTasks.len(arr);
        assertEquals(arr.length, res);
    }

    @ParameterizedTest
    @MethodSource("rotateParams")
    public void rotateMatrixTest(int[][] matrix, int[][] expectedMatrix) {
        int[][] actualMatrix = arrayTasks.rotateMatrix(matrix);
        assertArrayEquals(expectedMatrix, actualMatrix);
    }

    @ParameterizedTest
    @MethodSource("zeroParams")
    public void zeroMatrixTest(int[][] matrix, int[][] expectedMatrix) {

        int[][] actualMatrix = arrayTasks.zeroMatrix(matrix);
        assertArrayEquals(expectedMatrix, actualMatrix);
    }

    @ParameterizedTest
    @MethodSource("calcUniqueParams")
    public void calcUniqueLenTest(int[] nums, int expectedLength, int[] expectedNums) {
        int res = arrayTasks.calcUniqueLen(nums);

        assertEquals(expectedLength, res);
        assertArrayEquals(expectedNums, java.util.Arrays.copyOf(nums, expectedLength));
    }

    @ParameterizedTest
    @MethodSource("dupParams")
    public void cleanDuplicatesTest(int[] nums, int[] expectedNums) {
        int[] res = arrayTasks.cleanDuplicates(nums);

        assertEquals(expectedNums.length, res.length);
        assertArrayEquals(expectedNums, res);
    }

    @ParameterizedTest
    @MethodSource("valParams")
    public void removeValueTest(int[] nums, int val, int expectedLength, int[] expectedNums) {
        int res = arrayTasks.removeElement(nums, val);

        assertEquals(expectedLength, res);

        assertArrayEquals(expectedNums, java.util.Arrays.copyOf(nums, expectedLength));
    }

    @ParameterizedTest
    @MethodSource("searchInsertParams")
    public void searchInsertTest(int[] nums, int target, int expectedRes) {
        int res = arrayTasks.searchInsert(nums, target);
        assertEquals(expectedRes, res);
    }

    @ParameterizedTest
    @MethodSource("fairIndexParams")
    public void fairIndexTest(int[] a, int[] b, int expectedRes) {
        int res = arrayTasks.fairIndex(a, b);
        assertEquals(expectedRes, res);
    }

    @Test
    public void duplicatesStatTest() {
        int[] arr = new int[]{5, 2, 5, 6, 6, 10};
        int[] res = arrayTasks.duplicatesStat(arr);

        assertEquals(7, res.length);
        assertEquals(2, res[0]);
        assertEquals(5, res[1]);
        assertEquals(6, res[2]);
        assertEquals(5, res[3]);
        assertEquals(2, res[4]);
        assertEquals(6, res[5]);
        assertEquals(10, res[6]);
    }

    @ParameterizedTest
    @MethodSource("plusOneParams")
    public void plusOneTest(int[] digits, int[] expectedDigits) {
        int[] res = arrayTasks.plusOne(digits);
        assertArrayEquals(expectedDigits, res);
    }

    @ParameterizedTest
    @MethodSource("singleNumberParams")
    public void singleNumberTest(int[] arr, int expected) {
        int res = arrayTasks.singleNumber(arr);

        assertEquals(expected, res);
    }

    @ParameterizedTest
    @MethodSource("tvParams")
    public void tvTimeTest(List<TimeSlot> timeSlots, int expectedTime) {
        var res = arrayTasks.tvTime(timeSlots);
        assertEquals(expectedTime, res);
    }

    @ParameterizedTest
    @MethodSource("tripletParams")
    public void compareTripletsTest(List<Integer> a, List<Integer> b, List<Integer> expected) {
        var out = arrayTasks.compareTriplets(a, b);
        assertEquals(expected, out);
    }

    @Test
    public void veryBigSumTest() {
        var data = List.of(5L,
                1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L);

        var expected = 5000000015L;
        var res = arrayTasks.veryBigSum(data);
        System.out.println(data);
        System.out.println(res);

        assertEquals(expected, arrayTasks.veryBigSum(data));
    }

    @ParameterizedTest
    @MethodSource("diagParams")
    public void diagonalDifferenceTest(List<List<Integer>> matrix, int expected) {
        var res = arrayTasks.diagonalDifference(matrix);
        assertEquals(expected, res);
    }

    @ParameterizedTest
    @MethodSource("distanceParams")
    public void minArrayDistanceTest(int[] arr1, int[] arr2, int expected) {
        var res = arrayTasks.minArrayDistance(arr1, arr2);
        assertEquals(expected, res);
    }


    @Test
    public void plusMinusTest() {
        var data = List.of(-4, 3, -9, 0, 4, 1);

        var res = arrayTasks.plusMinus(data);
        assertEquals(0.5f, res.get(0));
        assertEquals(0.33333334f, res.get(1));
        assertEquals(0.16666667f, res.get(2));
    }

    @Test
    public void getFibonacciTest() {
        var res = arrayTasks.getFibonacci(4);
        assertEquals(3, res.get(0));
        assertEquals(2, res.get(1));
        assertEquals(1, res.get(2));
        assertEquals(1, res.get(3));
        assertEquals(0, res.get(4));
    }

    @ParameterizedTest
    @MethodSource("minimaxSumParams")
    public void minimaxSumTest(List<Integer> data, long expectedMin, long expectedMax) {
        var res = arrayTasks.minimaxSum(data);

        assertEquals(expectedMin, res.get(0));
        assertEquals(expectedMax, res.get(1));
    }

    @ParameterizedTest
    @MethodSource("candleParams")
    public void birthdayCandlesTest(List<Integer> data, int expected) {
        var res = arrayTasks.birthdayCandles(data);
        assertEquals(expected, res);
    }

    @ParameterizedTest
    @MethodSource("treeNodeParams")
    public void getFirstNodesOfRowFlatTest(int[] tree, int[] nodes) {
        var res = arrayTasks.getFirstNodesOfRowFlat(tree);
        assertArrayEquals(nodes, res);
    }

    @ParameterizedTest
    @MethodSource("treeRowsParams")
    void getTreeRowsTest(int[] tree, int[][] expectedRows) {
        int[][] actual = arrayTasks.getTreeRows(tree);
        assertArrayEquals(expectedRows, actual);
    }
}
