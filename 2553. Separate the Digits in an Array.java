class Solution {
    public int[] separateDigits(int[] nums) {
   
        List<Integer> res = new ArrayList<>();

        for(int num : nums){
            List<Integer> temp = new ArrayList<>();

            while(num != 0){
                temp.add(num%10);
                num /= 10;
            }

            for(int i = temp.size() -1 ;i>=0;i--){
                res.add(temp.get(i));
            }
        }

        int [] res1 = new int[res.size()];

        for(int i = 0;i<res.size();i++){
            res1[i] = res.get(i);
        }


         return res1;

    }
}
