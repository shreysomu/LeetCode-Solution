class Solution {

    static void solve(int[] candidates , int target , int index  , List<Integer> output , List<List<Integer>> res){
        //base case
        if(target == 0){
            res.add(new ArrayList<>(output));
            return;
        }

        if(index >= candidates.length)
        return;

        if(target < 0)
        return;

        //include-excude pattern

        //include
        output.add(candidates[index]);
        solve(candidates , target - candidates[index],index ,output, res);

        //backtrack step
        output.remove(output.size()-1);

        //exclude
        solve(candidates , target ,index+1 , output , res);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;

        solve(candidates , target , index , output, res);
        return res;
    }
}
