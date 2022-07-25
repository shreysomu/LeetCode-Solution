class Solution {
public:
 vector<int> res;
    void binarySearch(vector<int> & nums,int start,int end,int target){
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid] == target){
                res.push_back(mid);
                binarySearch(nums,start,mid-1,target);
                binarySearch(nums,mid+1,end,target);
                break;
            }
            else if(nums[mid] > target){
                end=mid-1;
            }
            else start=mid+1;
        }
    }
    vector<int> searchRange(vector<int>& nums, int target) {
        binarySearch(nums,0,nums.size()-1,target);
        sort(res.begin(),res.end());
        if(res.size()==0)
            return {-1,-1};
        return {res[0],res.back()};
    }
};
