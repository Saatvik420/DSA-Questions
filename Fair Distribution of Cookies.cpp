class Solution {
private:
    void solve(int index,vector<int>& cookies,vector<int>& ds,int k,int &ans){
        int n = cookies.size();
        if(index == n){
            int tp = INT_MIN;
            for(auto it : ds){
                tp = max(tp,it);
            }
            ans = min(ans,tp);
            return;
        }
        for(int i=0;i<k;i++){
            ds[i]+=cookies[index];
            solve(index+1,cookies,ds,k,ans);
            ds[i]-=cookies[index];
        }

    }    
public:
    int distributeCookies(vector<int>& cookies, int k) {
        vector<int> ds(k,0);
        int ans=INT_MAX;
        solve(0,cookies,ds,k,ans);
        return ans;
    }
};