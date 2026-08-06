class Solution {
     static void solve(int[] candidates, int target , int index , List<List<Integer>> res , List<Integer> output, int count, int k){
        //base case

        if(count > k){
            return;
        }
        if(count == k  && target == 0){
            //target 0 means output vali list me ek res ban chuka hai
            //then store it into res wali ist

            res.add(new ArrayList<>(output));
            return;
        }

        if (index >= candidates.length){
            return;
        }

        if(target<0){
            return;
        }

        //1 case we need to solve other recursion will take care

        //include-exclude pattern

        //include
        output.add(candidates[index] );
        solve(candidates,target-candidates[index],index+1,res,output, count+1, k);

        //backtrack step
        output.remove(output.size()-1);

        while (index+1 < candidates.length && candidates[index] == candidates[index+1]){
            index++;
        }
        //exclude
        solve(candidates, target, index+1, res, output, count, k);
    }

    static List<List<Integer>> combinationSum3(int k, int n) {

       // Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        int target = n;
        int []candidates = {1,2,3,4,5,6,7,8,9};
        int count = 0;

        solve(candidates,target,index,res,output,count,k);
        return res;
    }
}
