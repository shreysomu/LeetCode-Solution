class Solution {
public:
    bool isPalindrome(int x) {
        
        if(x==0) 
            return true;
        if (x<0 || x%10==0)
            return false;
        int digit = x;
      long  int rev = 0;
        while (digit!= 0) {
            int rem = digit%10;
            digit = digit/10;
            rev = rev*10+rem;
            
  } 
            
     if(x==rev)
         return true;
        else
            return false;
  }  
};
