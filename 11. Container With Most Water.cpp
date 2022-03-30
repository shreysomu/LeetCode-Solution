class Solution {
public:
    int maxArea(vector<int>& height) {
        
         int begin = 0, end = height.size() - 1;
        int m = height[begin], n = height[end];
        int res = min(height[begin], height[end]) * (end - begin);
        while(begin < end){
            if(m < n){
                while(height[begin] <= m && begin < end)
                    begin++;
                m = height[begin];
            }
            else{
                while(height[end] <= n && begin < end)
                    end--;
                n = height[end];
            }
           res = max(res, min(m, n)*(end - begin));
        }
        return res;
    }
};
