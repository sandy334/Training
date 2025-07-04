public class reverseelementarray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5,6,7,8,9,10};
        int n = arr.length;

        // Reverse the array
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        // Print the reversed array
        System.out.print("Reversed array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}