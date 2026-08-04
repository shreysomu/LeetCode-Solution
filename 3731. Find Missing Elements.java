class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Set<Integer> set = new HashSet<>();
       
        for(int x : nums){
            min = Math.min(min,x);
            max = Math.max(max,x);
            set.add(x);
        }

        List<Integer> res = new ArrayList<>();

        for(int i = min+1 ;i<max;i++){
            if(!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}
