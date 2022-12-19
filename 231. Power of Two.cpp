class Solution {
public:
    bool isPowerOfTwo(int n) {
        for(int i =0;i<=30;i++){
            int res = pow(2,i);
            if(res == n)
            return true;
           
        }
         return false;
    }

};
