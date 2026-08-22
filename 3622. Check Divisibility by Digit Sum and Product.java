class Solution {
    public boolean checkDivisibility(int n) {
        
        int digitSum = 0;
        int digitProduct = 1;
        int temp = n;

        while(n>0){
            int digit = n%10;
            digitSum += digit;
            digitProduct *= digit;
            n/=10;
        }

        if(temp % (digitSum + digitProduct) == 0){
            return true;
        }

        return false;
    }
}
