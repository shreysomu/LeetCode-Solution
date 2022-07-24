class Solution {
public:
bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int s1=matrix.size();
        int s2=matrix[0].size();
        bool flag=false;
        int i=0,j=s2-1;
        while(j>=0 && i<s1){
            if(target==matrix[i][j]){
                flag= true;
                break;
            }
           else if(target>matrix[i][j]){
                i++;
            }
            else{
                j--;
            }
        }
        
        return flag;
    }
};
