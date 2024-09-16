package opgave01;

public class Opgave01 {
    public static void main(String[] args) {
        int[] integerArray = getIntegerArray();
//        int[] zeroLenghtArray = {};
//        double result = average(integerArray);
//        System.out.println("result = " + result);
//        int sumOfdigits = crossSum(745);
//        System.out.println("sumOfdigits = " + sumOfdigits);
        int[] result = crossSumOfCrossSumStats(integerArray);
        printIntegerArray(result);
    }

    public static int[] crossSumOfCrossSumStats(int[] integerArray) {
        int[] result = new int[9];
        for (int intToCrossSum : integerArray) {
            int crossSumResult = crossSum(intToCrossSum);
            while (crossSumResult > 9) {
                crossSumResult = crossSum(crossSumResult);
            }
            result[crossSumResult - 1]++;
        }
        return result;
    }

    public static int[] crossSumAll(int[] integersToCrossSum) {
        int[] results = new int[integersToCrossSum.length];
        for (int index = 0; index < integersToCrossSum.length; index++) {
            results[index] = crossSum(integersToCrossSum[index]);
        }
        return results;
    }

    public static int crossSum(int intToSum) {
        int sum = 0;
        while (intToSum > 0) {
            sum += intToSum % 10;
            intToSum = intToSum / 10;
        }
        return sum;
    }

    public static double average(int[] integerArray) {
        if (integerArray.length == 0) {
            return 0;
        }
        return (double) sumAll(integerArray) / integerArray.length;
    }

    public static int sumAll(int[] integerArray) {
        int sum = 0;
        for (int intToSum : integerArray) {
            sum += intToSum;
        }
        return sum;
    }

    public static void printIntegerArray(int[] integerArray) {
        System.out.print("[");
        for (int index = 0; index <= integerArray.length - 2; index++) {
            System.out.print(integerArray[index] + ", ");
        }
        System.out.print(integerArray[integerArray.length - 1]);
        System.out.print("]");
    }

    private static int[] getIntegerArray() {
        int[] integerArray = {1095, 12, 9065, 387, 700, 20, 5, 2065, 97654, 103, 789, 50, 1972, 200, 35, 98, 1002};
        return integerArray;
    }
}
