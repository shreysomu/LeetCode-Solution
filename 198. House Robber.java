//WITH TLE
//Using recursion only
//We can avoid TLE by using DP

class Solution {

    public int solve(int[] nums,int ind){
        //base Case
        if(ind>=nums.length)
        return 0;

        //include
        int includeRes = nums[ind] + solve(nums,ind + 2);
        int excludeRes = solve(nums,ind + 1);
        return Math.max(includeRes,excludeRes);
    }
    public int rob(int[] nums) {
        int ind = 0;
        return solve(nums,ind);
    }
}
