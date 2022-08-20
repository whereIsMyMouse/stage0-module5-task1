package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        String[] seasons = new String[]{"winter", "spring", "summer", "autumn"};
        return seasons;
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = 1 + i;
        }
        return numbers;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        return totalSum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        int indexOf = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                indexOf = i;
                break;
            }
        }
        return indexOf;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] arrReverse = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrReverse[i] = arr[arr.length - i - 1];
        }
        return arrReverse;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int countPositive = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                countPositive++;
            }
        }
        int[] arrPositive = new int[countPositive];
        int k = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > 0) {
                arrPositive[k] = arr[j];
                k++;
            }
        }

        return arrPositive;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {

        int[][] arrLengthCounter = new int [2] [arr.length];
        for (int k = 0; k < arr.length; k++) {
            arrLengthCounter[0][k] = k;
            arrLengthCounter[1][k] = arr[k].length;
        }

        for (int i = 0; i < arr.length; i++) {
            int tempLength;
            int tempposition;
            for (int j = i; j < arr.length; j++) {
                if (arrLengthCounter[1][j] < arrLengthCounter[1][i]) {
                    tempLength = arrLengthCounter[1][i];
                    arrLengthCounter[1][i] = arrLengthCounter[1][j];
                    arrLengthCounter[1][j] = tempLength;
                    tempposition = arrLengthCounter[0][i];
                    arrLengthCounter[0][i] = arrLengthCounter[0][j];
                    arrLengthCounter[0][j] = tempposition;
                }
            }
        }

        int[][] resultArray = new int [arr.length] [];
        for (int i = 0; i < arr.length; i++) {
            int index = arrLengthCounter[0][i];
            resultArray[i] = arr[index];
            resultArray[i] = sortInputArray(resultArray[i]);
        }
        return resultArray;
    }

    public int[] sortInputArray(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            int tempPiece;
            for (int j = i; j < inputArray.length; j++) {
                if (inputArray[j] < inputArray[i]) {
                    tempPiece = inputArray[i];
                    inputArray[i] = inputArray[j];
                    inputArray[j] = tempPiece;
                }
            }
        }
        return inputArray;
    }


}

