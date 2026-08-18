class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> windowCount = new HashMap<>();

        // Generate every subarray of size k
        for (int i = 0; i <= n - k; i++) {

            Set<Integer> set = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            // Count each distinct number once per window
            for (int num : set) {
                windowCount.put(num,
                        windowCount.getOrDefault(num, 0) + 1);
            }
        }

        int ans = -1;

        for (Map.Entry<Integer, Integer> entry : windowCount.entrySet()) {

            if (entry.getValue() == 1) {
                ans = Math.max(ans, entry.getKey());
            }
        }

        return ans;
    }
}
