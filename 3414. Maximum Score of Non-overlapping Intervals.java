import java.util.*;

class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // Store: [start, end, weight, originalIndex]
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by ending time
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        // dp[i][k] = best result using first i intervals
        // and selecting at most k intervals
        List<Integer>[][] dp = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= n; i++) {

            int start = arr[i - 1][0];
            int weight = arr[i - 1][2];
            int index = arr[i - 1][3];

            // Previous interval whose end < current start
            int prev = findPrevious(arr, i - 1, start);

            for (int k = 1; k <= 4; k++) {

                // Option 1: don't take current interval
                dp[i][k] = new ArrayList<>(dp[i - 1][k]);

                // Option 2: take current interval
                List<Integer> candidate =
                        new ArrayList<>(dp[prev + 1][k - 1]);

                candidate.add(index);

                if (isBetter(candidate, dp[i][k], intervals)) {
                    dp[i][k] = candidate;
                }
            }
        }

        return dp[n][4].stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }

    // Find last interval whose end < start
    private int findPrevious(int[][] arr, int right, int start) {

        int low = 0;
        int high = right - 1;
        int answer = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid][1] < start) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    // Compare two solutions
    private boolean isBetter(
            List<Integer> a,
            List<Integer> b,
            List<List<Integer>> intervals) {

        if (a.size() > 4)
            return false;

        long weightA = 0;
        long weightB = 0;

        for (int idx : a)
            weightA += intervals.get(idx).get(2);

        for (int idx : b)
            weightB += intervals.get(idx).get(2);

        if (weightA != weightB)
            return weightA > weightB;

        // Lexicographically smaller indices
        List<Integer> x = new ArrayList<>(a);
        List<Integer> y = new ArrayList<>(b);

        Collections.sort(x);
        Collections.sort(y);

        for (int i = 0; i < Math.min(x.size(), y.size()); i++) {
            if (!x.get(i).equals(y.get(i)))
                return x.get(i) < y.get(i);
        }

        return x.size() < y.size();
    }
}
