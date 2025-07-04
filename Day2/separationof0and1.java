public class separationof0and1 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 1, 0, 1};
        int n = arr.length;
        int count = 0;

        // Count the number of 0s
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }

        // Fill the array with 0s and 1s
        for (int i = 0; i < n; i++) {
            if (i < count) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }

        // Print the modified array
        System.out.print("Array after separation: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
