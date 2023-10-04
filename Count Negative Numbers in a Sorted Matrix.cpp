class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
//j points the index where 1st negative integer came(for each row).
        int i,n=grid.size(),j=grid[0].size()-1,m=grid[0].size(),ans=0;
        for(i = 0; i < n; i++){
            while(j>= 0 && grid[i][j]<0)j--;
            if(j<0)ans += m;
            else if(j<m-1)ans += m-j-1;
        }
        return ans;
    }
};