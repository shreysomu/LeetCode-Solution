class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
          if(nums1.size() == 0 || nums2.size() == 0){
	
        vector<int> target = (nums1.size() == 0)?nums2: nums1;
        if(target.size() % 2 == 0){
		
            int middle = target.size() / 2;
            return (target[middle] + target[middle -1]) / 2.0;
        }
        else{
		
            int middle = target.size() / 2;
            return target[middle];
        }
    }
	
    for(int i = 0; i < nums2.size(); i++){
        int target = nums2[i];
        int start = 0; 
		
        int mid = 0;
		
        int end = nums1.size() - 1; 
		
        while(start <= end){
		
            mid = start + (end - start ) / 2;
            if(target < nums1[mid]){
                end = mid - 1;
            }
			
            else if(target > nums1[mid]){
                start = mid + 1;
				
            }
            else{
			
                nums1.insert(nums1.begin() + mid + 1, target);
                break;
				
            }
			
        }
		
        if(nums1[mid] == target){
            continue;
			
        }
		
        nums1.insert(nums1.begin() + start , target);
		
    }
    if(nums1.size() % 2 == 0){
        int middle = nums1.size() / 2;
        return (nums1[middle] + nums1[middle - 1]) / 2.0;
    }
    else{
        int middle = nums1.size() / 2;
        return nums1[middle];
    }
        
    }
};
