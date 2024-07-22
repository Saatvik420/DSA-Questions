class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) {

        map<int,string> mp;

        int n = heights.size();

        for(int i=0;i<n;i++){

            mp[heights[i]]  = names[i];
            
        }

        vector<string> ans;

        auto it = mp.end();
        it--;

        while(it != mp.begin()){

            ans.push_back(it->second);
            it--;
            
        }

        ans.push_back(it->second);

        return ans;
        
    }
};