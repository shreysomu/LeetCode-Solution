class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int> um;
        for(int num : nums){
            um[num]++;
        }
        
        vector<int> ans;
        // pair<first, second>: first is frequency,  second is number
        priority_queue<pair<int,int>> pq; 
        for(auto it = um.begin(); it != um.end(); it++){
            pq.push(make_pair(it->second, it->first));
            if(pq.size() > (int)um.size() - k){
                ans.push_back(pq.top().second);
                pq.pop();
            }
        }
        return ans;
    }
};
