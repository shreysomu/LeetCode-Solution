class Solution {
    public int missingMultiple(int[] nums, int k) {

        // //Brute Force Approach ------>>>> TLE
        //         boolean found = false;
        //         int multi = 1;
        //         for (int i = 1;; i++) {
        //             multi = i * k;

        //             for (int x : nums) {

        //                 if (multi == x) {
        //                     found = true;
        //                     break;
        //                 }
        //             }

        //             if (!found) {
        //                 return multi;
        //             }

        //         }

        //Optimized approach using hashSet

        HashSet<Integer> hs = new HashSet<>();

        for (int x : nums) {
            hs.add(x);
        }

        for (int i = 1;; i++) {
            int multi = i * k;

            if (!hs.contains(multi)) {
                return multi;
            }
        }
    }
}
