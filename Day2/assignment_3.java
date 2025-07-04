//scenario 3 : ms.anitha is interested in working with arrays that contain values such as 85374 .write a prgm to elemenate duplicate values in the array
public class assignment_3 {
    public static void main(String[] args) {
        int[] arr = {8, 5, 3, 7, 4, 8, 5, 3}; // Example array with duplicates
        int[] uniqueArr = eliminateDuplicates(arr);

        System.out.print("Array after eliminating duplicates: ");
        for (int num : uniqueArr) {
            System.out.print(num + " ");
        }
    }

    public static int[] eliminateDuplicates(int[] arr) {
        int n = arr.length;
        boolean[] seen = new boolean[100]; // Assuming values are in the range 0-99
        int count = 0;

        // Count unique elements
        for (int i = 0; i < n; i++) {
            if (!seen[arr[i]]) {
                seen[arr[i]] = true;
                count++;
            }
        }

        // Create an array to hold unique elements
        int[] uniqueArr = new int[count];
        int index = 0;

        // Fill the unique array
        for (int i = 0; i < n; i++) {
            if (seen[arr[i]]) {
                uniqueArr[index++] = arr[i];
                seen[arr[i]] = false; // Mark as added to avoid duplicates in the result
            }
        }

        return uniqueArr;
    }
    
}
