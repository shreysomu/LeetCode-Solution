class Solution {
public:
    bool isPowerOfFour(int n) {
        for(int i =0;i<=30;i++){
            long res = pow(4,i);
            if(res == n)
            return true;
           
        }
         return false;
    }

};
