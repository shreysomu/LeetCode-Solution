class Solution {
public:
    int climbStairs(int n) {
        if(n == 1)
{
      return 1;
 }
        int a = 1;
        int b = 1;
        int sum = 0;
        for(int i=0;i<n-1;i++)
        {
            sum = a + b;
            a = b;
            b = sum;
        }
        
        return sum;
    }
};
