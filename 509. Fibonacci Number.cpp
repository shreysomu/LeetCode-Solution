class Solution {
public:
    int fib(int N) {
          if(N <= 1)
   {
       return N;
   }

   int last = fib(N-1);
   int slast = fib(N-2);
   
   return last + slast;
    }
};
