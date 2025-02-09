class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        string res = "";
        int l1 = word1.length();
        int l2 = word2.length();

        int pt1 = 0;
        int pt2 = 0;

        while(pt1<l1 || pt2<l2){


            if(pt1<l1){
                res.push_back(word1[pt1++]);
            }
            if
            (pt2<l2){
                res.push_back(word2[pt2++]);
            }
        }

        return res;

    }
};
