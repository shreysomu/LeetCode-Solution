class Solution {
public:
    bool isPowerOfThree(int n) {
        for(int i =0;i<=30;i++){
            long res = pow(3,i);
            if(res == n)
            return true;
           
        }
         return false;
    }

};
