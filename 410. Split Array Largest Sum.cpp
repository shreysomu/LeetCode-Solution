class Solution {
public:
    int splitArray(vector<int>& nums, int m) {
        
        int l = 0 , h = 0 ;
        
        for(auto&j:nums)
        {
            l=max(j,l) ;
            h+=j ;
        }
        
        int ans = INT_MAX ;
        
        while( l <= h )
        {
            int mid = l + ( h - l)/2 ;
            
            int sum = 0 ; 
            int count = 0 ;
            
            for(auto&j:nums)
            {
                if(sum+j<=mid)
                {
                    sum+=j ;   
                }
                else
                {
                    sum = j ;
                    count++ ;
                }
            }
            
            if( count+1 > m  )
                l=mid+1 ;
            else
            {
                h=mid-1 ;
                ans = mid ;
            }
 
        }
        
        return ans ;
        
    }
    
};
