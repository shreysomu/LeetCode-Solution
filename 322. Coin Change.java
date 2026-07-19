//TLE --->> using recursion
//Can be optimize using DP

class Solution {
        static int solve(int[] coins,int amount){

        //base case
        if(amount == 0)
            return 0;

        if(amount < 0){
            return Integer.MAX_VALUE;
        }

        int mini = Integer.MAX_VALUE;

        for (int coin : coins){
            int ans = solve(coins,amount - coin);

            if (ans != Integer.MAX_VALUE){
                int totalCoinsUSed = ans + 1;
                mini = Math.min(mini,totalCoinsUSed);
            }
        }
        return mini;
    }

    public int coinChange(int[] coins,int amount){
        int ans = solve(coins,amount);

        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        else {
            return ans;
        }
    }
}
