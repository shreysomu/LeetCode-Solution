//TLE --- >> solve using recursion can be optimized using DP

class Solution {
      static boolean solve(int[] nums, int index){
        //base cases
        //reached destination
        if (index == nums.length-1){
            return true;
        }

        //destination se bahr nikal gaya
        if(index >= nums.length){
            return false;
        }

        //stuck wali situation
        if(nums[index] == 0){
            return false;
        }

        int jumpValue = nums[index];
        boolean overAllAns = false;
        for (int jump = 1;jump<=jumpValue;jump++){
           boolean ans = solve(nums,index+jump);
           overAllAns = overAllAns || ans;
        }
        return overAllAns;
    }
    static boolean canJump(int[] nums){
        int index = 0;
        boolean ans  = solve(nums,index);
        return ans;
    }
}
