import java.util.Arrays;

public class ArrayOps {
    public static void main(String[] args) {
        // int[] test1 = {0, 1, 2, 3, 5};
        // int result1 = findMissingInt(test1);
        // System.out.println("Missing integer in test1: " + result1);

        // int[] test2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        // int result2 = findMissingInt(test2);
        // System.out.println("Missing integer in test2: " + result2); // Output should be 0
        
        // int[] test3 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        // int result3 = findMissingInt(test3);
        // System.out.println("Missing integer in test3: " + result3); // Output should be 10

        // int[] test1 = {6, 9, 4, 7, 3, 4};
        // int result1 = secondMaxValue(test1);
        // System.out.println(result1);

        // int[] test2 = {1, 2, 3, 4, 5};
        // int result2 = secondMaxValue(test2);
        // System.out.println(result2);

        // int[] test3 = {2, 8, 3, 7, 8};
        // int result3 = secondMaxValue(test3);
        // System.out.println(result3);

        // int[] test4 = {1, -2, 3, -4, 5};
        // int result4 = secondMaxValue(test4);
        // System.out.println(result4);

        // int[] test5 = {-202, 48, 13, 7, 8};
        // int result5 = secondMaxValue(test5);
        // System.out.println(result5);

        // testContainsSameElements(new int[] {1, 2, 1, 1, 2}, new int[] {2, 1}, true); // Expected: true
        // testContainsSameElements(new int[] {2, 2, 3, 7, 8, 3, 2}, new int[] {8, 2, 7, 7, 3}, true); // Expected: true
        // testContainsSameElements(new int[] {1, 2, 3}, new int[] {1, 2, 3}, true); // Expected: true
        // testContainsSameElements(new int[] {3, -4, 1, 2, 5}, new int[] {1, 3, -4, 5}, false); // Expected: false

        // testIsSorted(new int[] {7, 5, 4, 3, -12}, true); // true
        // testIsSorted(new int[] {1, 2, 3}, true); // true
        // testIsSorted(new int[] {1, -2, 3}, false); // false
        // testIsSorted(new int[] {1, 1, 500}, true); // true
        // testIsSorted(new int[] {1, 3, 2}, false); // false
    }

    // private static void testIsSorted(int[] array, boolean expected) {
    //     boolean result = isSorted(array);
    //     System.out.println("Test result for " + Arrays.toString(array) + 
    //                        " is " + result + ". Expected: " + expected + " -> " + 
    //                        (result == expected ? "PASS" : "FAIL"));
    // }

    // private static void testContainsSameElements(int[] array1, int[] array2, boolean expected) {
    //     boolean result = containsTheSameElements(array1, array2);
    //     System.out.println("Test result for " + Arrays.toString(array1) + " and " + Arrays.toString(array2) + 
    //                        " is " + result + ". Expected: " + expected + " -> " + 
    //                        (result == expected ? "PASS" : "FAIL"));
    // }

    public static int findMissingInt (int [] array) {
        int n = array.length;
        for (int i = 0; i < n + 1; i++){
            boolean isInArray = false;
            for (int j = 0; j < n; j++){
                if (i == array[j]){
                    isInArray = true;
                }
            }
            if (!isInArray){
                return i;
            }
        }
        return -1;
    }

    public static int secondMaxValue(int [] array) {
        int n = array.length;
        Arrays.sort(array);
        int secondMaxVal = array[n - 2];
        return secondMaxVal;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        return containsAllElements(array1, array2) && containsAllElements(array2, array1);
    }

    private static boolean containsAllElements(int [] array1, int [] array2){
        int n1 = array1.length;
        int n2 = array2.length;

        for (int i = 0; i < n1; i++){
            boolean isDigitIn = false;
            for (int j = 0; j < n2; j++){
                if (array1[i] == array2[j]){
                    isDigitIn = true;
                }
            }
            if(!isDigitIn){
                return false;
            }
        }
        return true;
    }

    public static boolean isSorted(int [] array) {
        int n = array.length;
        boolean monoUp = true;
        boolean monoDown = true;

        for (int i = 0; i < n  - 1; i++){
            if (array[i + 1] >= array[i]){
                monoDown = false;
            }
            else{
                monoUp = false;
            }
        }

        boolean isMonotonic = monoDown || monoUp;
        return isMonotonic;
    }

}
