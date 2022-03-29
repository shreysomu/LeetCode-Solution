class Solution {
public:

  string rev(string s){
        reverse(s.begin(),s.end());
        return s;
    }
    
    pair<int,string> expand(int i, int j,string s){
        int ans = 0;
        string res="";
        while(i>=0 && j<s.size() && s[i]==s[j]){
            ans+=2;
            res += s[j];
            i--;
            j++;
        }
        return {ans,res};
    }
    
    string longestPalindrome(string s) {
        int ans = 0;
        string res="";
        int n = s.size();
        for(int k=0;k<n;k++){
            // odd length palindrome
            auto p = expand(k-1,k+1,s);
            int ans1 = p.first+1;
            ans = max(ans,ans1);
            string temp = rev(p.second)+s[k]+p.second;
            
            if(res.size() < temp.size())
                res = temp;
            
            // even length palindrome
            if(k<n && s[k]==s[k+1]){
                auto q = expand(k-1,k+2,s);
                int ans1 = q.first+1;
                ans = max(ans,ans1);
                temp = rev(q.second) + s[k] + s[k+1] + q.second;
                
                if(res.size() < temp.size())
                    res = temp;
            }
        }
        return res;
    }
};
