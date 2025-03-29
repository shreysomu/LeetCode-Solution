class Solution {
public:
    char findTheDifference(string s, string t) {
       char result = 0;
        for(char c : s) {
            result ^= c;  // XOR all characters in s
        }
        for(char c : t) {
            result ^= c;  // XOR all characters in t
        }
        return result;  // The remaining character is the added one
    }
    
};
