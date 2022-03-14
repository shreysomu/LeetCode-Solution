class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> umap; //Hash Table
        int diff;

        for(int i = 0; i < nums.size(); i++ ){
            diff = target - nums.at(i);
            if(umap.find(diff) != umap.end()) {
                vector<int> v{umap[diff], i};
                return v;
            } else {
                umap[nums.at(i)] = i;
            }
        }

        return vector<int> {};
    }
};
