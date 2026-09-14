import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        // factorial[i] = i!
        int[] factorial = new int[n + 1];
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // Convert k to 0-based index
        k--;

        StringBuilder ans = new StringBuilder();

        for (int i = n; i >= 1; i--) {
            // Number of permutations starting with each number
            int blockSize = factorial[i - 1];

            int index = k / blockSize;

            ans.append(nums.get(index));
            nums.remove(index);

            k %= blockSize;
        }

        return ans.toString();
    }
}
