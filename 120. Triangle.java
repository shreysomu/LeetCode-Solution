//TLE --->> using recursion, can be optimized using DP

class Solution {
 static int solve(List<List<Integer>> triangle , int rowIndex , int colIndex){
        //base case
        if(rowIndex == triangle.size()-1){
            //jis value par khade ho usko include kar lo aur wapas jaao
            return triangle.get(rowIndex).get(colIndex);
        }

        int downAns = solve(triangle,rowIndex+1,colIndex);
        int diagonalAns = solve(triangle,rowIndex+1,colIndex+1);
        int finalAns = triangle.get(rowIndex).get(colIndex) + Math.min(downAns,diagonalAns);
        return finalAns;
    }
    static int minimumTotal(List<List<Integer>> triangle){
        int rowIndex = 0;
        int colIndex = 0;
        int ans = solve(triangle, rowIndex ,colIndex);
        return ans;
    }
}
