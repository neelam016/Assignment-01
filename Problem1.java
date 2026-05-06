import java.util.*;

public class Problem1 {

    // Function to get alphabet value
    public static int getValue(char ch) {
        return ch - 'a' + 1;
    }

    // Function to find maximum cyclic substring sum
    public static int maxCyclicSubstringSum(String s) {

        int n = s.length();

        // Make string cyclic
        String doubled = s + s;

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int sum = 0;
        int maxSum = 0;

        for (int right = 0; right < doubled.length(); right++) {

            char ch = doubled.charAt(right);

            // Remove characters until substring becomes valid
            while (set.contains(ch) || (right - left + 1) > n) {

                char leftChar = doubled.charAt(left);

                set.remove(leftChar);

                sum -= getValue(leftChar);

                left++;
            }

            // Add current character
            set.add(ch);

            sum += getValue(ch);

            // Update maximum sum
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int ans = maxCyclicSubstringSum(s);

        System.out.println(ans);
    }
}