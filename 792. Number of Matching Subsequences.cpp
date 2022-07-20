
    class Solution {
public:
    bool isSubsequence(string &s1, string &s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        
        if(l1 > l2) 
            return false;
        
        int i = 0, j = 0;
        
        for(; j < l2; j++){
            if(s1[i] == s2[j]){
                i++;
            }
            if(i == l1) 
                break;
        }
        if(i >= l1) 
            return true;
        return false;
    }
    
    int numMatchingSubseq(string s, vector<string>& words) {
        int count = 0;
        unordered_map<string, bool> u_mp;
        bool isTrue = false;
        for(int i = 0; i < words.size(); i++){
            auto it = u_mp.find(words[i]);
            if(it != u_mp.end()){
                if((*it).second) 
                    count++;
                continue;
            }
            isTrue = isSubsequence(words[i], s);
            u_mp[words[i]] = isTrue;
            if(isTrue) count++;
        }
        
        return count;
    }
};
