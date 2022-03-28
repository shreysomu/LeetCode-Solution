class Solution {
public:
   string convert(string s, int numRows) {
        if(numRows==1)
            return s;
        vector<string> rows(numRows);
        int curr=0,fact=1;
        string res;
        for(int i=0;i<s.length();i++){
            rows[curr].push_back(s[i]);
            curr+=fact;
            if(curr==0 || curr==numRows-1)
                fact=fact*-1;
        }
        for(auto str: rows)
            res+= str;
        return res;
    }
};
