class Solution {

    static void solve(int[] nums, int index , List<Integer> output ,List<List<Integer>> ans){

        //base case
        if(index >= nums.length){
            ans.add(new ArrayList<>(output));
            return;
        }

        //include exclude pattern
        int currValue = nums[index];

        //include
        output.add(currValue);
        solve(nums,index+1,output,ans);

         //backtracking step
         output.remove(output.size()-1);

        //while excluding ignore the same element and move to nex element
        while(index+1 < nums.length && nums[index] == nums[index+1]){
            index++;
        }
        //exclude
        solve(nums,index+1,output,ans);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        int index = 0 ;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        solve(nums,index,output,ans);
        return ans;
    }
}
