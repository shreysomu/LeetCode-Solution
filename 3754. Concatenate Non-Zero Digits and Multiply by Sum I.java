class Solution {
    public long sumAndMultiply(int n) {
        int sum = 0;
        int rev = 0;
        while(n>0){
            int digit = n % 10;

            if(digit>0){
                rev = digit + 10*rev;
                sum += digit;
            }
            n /= 10;
        }

        int temp = rev ;
        int newRev = 0;
        while(temp > 0){
            int digit = temp % 10;
            newRev = newRev * 10 + digit;
            temp /= 10; 
        }

        return (long)sum * newRev;
    }
}
