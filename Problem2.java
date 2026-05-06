import java.util.*;

public class Problem2 {

    public static int minOperations(int[] arr, int k) {

        int n = arr.length;

        // Check if transformation is possible
        for (int i = 1; i < n; i++) {

            if ((arr[i] - arr[0]) % k != 0) {
                return -1;
            }
        }

        // Sort array
        Arrays.sort(arr);

        // Median element
        int median = arr[n / 2];

        int operations = 0;

        // Count operations
        for (int num : arr) {

            operations += Math.abs(num - median) / k;
        }

        return operations;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int ans = minOperations(arr, k);

        System.out.println(ans);
    }
}
