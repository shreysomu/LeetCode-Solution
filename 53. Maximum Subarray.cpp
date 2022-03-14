class Solution {
public:
   int maxSubArray(vector<int>& nums) 
    {
        int localmax=nums[0];          
        int sum=nums[0];
        for(int i=1;i<nums.size();i++)
        {
            localmax=max(nums[i],localmax+nums[i]);
            sum=max(localmax,sum);
        }
        return sum;
    }
};
