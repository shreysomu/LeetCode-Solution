class Solution {
public:
    bool isAnagram(string s, string t) {

        if(s.length() == t.length() && s.length() == 0)
            return true;
        if(s.length() != t.length())
            return false;
        int word_map[26] = {};
        for(int i = 0; i < s.length(); i++)
        {
            int cur_s = s[i] - 'a';
            int cur_t = t[i] - 'a';
            word_map[cur_s]++;
            word_map[cur_t]--;
        }
        
        int res = 0;
        for(auto i : word_map)
            res += i < 0?-i:i;
        if(res != 0)
            return false;
        return true;
        
    }
};
