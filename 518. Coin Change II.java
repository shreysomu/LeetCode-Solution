//Solution with TLE -->>using recursion
//we can optimize by using dp

class Solution {

    public static int solve(int amount,int[] coins,int index){
        //base case 

        if(amount == 0)
        return 1;

        if(amount < 0 || index >= coins.length)
        return 0;



        //include
        int includeAns = solve(amount - coins[index],coins,index);
        //exclude
        int excludeAns = solve(amount,coins,index+1);

        return includeAns + excludeAns;
    } 
    public int change(int amount, int[] coins) {
        int index = 0;
        return solve(amount,coins,index);
    }
}
