class Solution {
    public int findGCD(int[] nums) {

        int smallestNumber = Integer.MAX_VALUE;
        int largestNumber = Integer.MIN_VALUE;

        for (int num : nums) {
            smallestNumber = Math.min(smallestNumber, num);
            largestNumber = Math.max(largestNumber, num);
        }

        int res = 1;

        for (int i = 1; i <= smallestNumber; i++) {
            if (smallestNumber % i == 0 && largestNumber % i == 0) {
                res = i;
            }
        }

        return res;
    }
}
