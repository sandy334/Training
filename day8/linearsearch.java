public class linearsearch {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Element found at index i
            }
        }
        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 30;

        int result = linearSearch(arr, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }
}
// This code implements a linear search algorithm in Java.
// It searches for a target element in an array and returns its index if found, or -1 if not found.
// The main method demonstrates the usage of the linearSearch method with a sample array and target value.
// The linear search algorithm has a time complexity of O(n), where n is the number of elements in the array.
