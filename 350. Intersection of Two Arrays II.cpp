class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        sort(nums1.begin(),nums1.end());
        sort(nums2.begin(),nums2.end());
        vector<int> result;
        int m=nums1.size();
        int n=nums2.size();
        
//here solution is divided in two part.
// 1.when first array size is less than second
// 2. when second array size is greater than first		
		
        if(nums1.size()<nums2.size()){          // condition 1
            int start=0,end=0;                 // start is index of 1st array and end is the index of 2nd array
        while(m>0&&end<=n){               // execute the loop till we reach last element of either array
            if(nums1[start]==nums2[end]){   // if number match in both array add it in "answer" vector and increase index of both loop
                result.push_back(nums1[start]);
                start++;
                end++;
                m--;
                
            }
            else if(nums1[start]<nums2[end]){    // if no. in first array is small than 2nd , increase index of 1st array
                start++;
                m--;
            }
            else if(nums1[start]>nums2[end]){     //if no. in second array is small than 1st , increase index of 2nd array
                end++;
                
            }
        }
        }
       else {                                    // condition 2
            int start=0,end=0;
        while(n>0&&start<=m){
            if(nums1[start]==nums2[end]){
                result.push_back(nums1[start]);
                start++;
                end++;
                n--;
            }
            else if(nums1[start]<nums2[end]){
                start++;
            }
            else if(nums1[start]>nums2[end]){
                end++;
                n--;
            }
        }
        }
        
        return result;
        
    }
};
