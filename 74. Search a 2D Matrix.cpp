class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
             int m = matrix.size();
        int n = matrix[0].size();
        
        if(m == 0 || n == 0)
            return false;
        

        int start = 0, end = n*m - 1;
        
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
	
            int index = matrix[mid/n][mid%n];
            if (target == index)
                return true;
			
            else if(target < index)
                end = mid - 1;
            else
                start = mid + 1;       
        }
        return false;

    }
};
