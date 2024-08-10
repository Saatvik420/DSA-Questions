class Solution {
public:
    int find(vector<int>& parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
    
    void unionSet(vector<int>& parent, int x, int y) {
        parent[find(parent, x)] = find(parent, y);
    }
    
    int regionsBySlashes(vector<string>& grid) {
        int n = grid.size();
        vector<int> parent(4 * n * n);
        for (int i = 0; i < 4 * n * n; ++i) parent[i] = i;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int root = 4 * (i * n + j);
                char val = grid[i][j];
                
                if (val == '/' || val == ' ') {
                    unionSet(parent, root + 0, root + 3);
                    unionSet(parent, root + 1, root + 2);
                }
                if (val == '\\' || val == ' ') {
                    unionSet(parent, root + 0, root + 1);
                    unionSet(parent, root + 2, root + 3);
                }
                
                if (j + 1 < n) {
                    unionSet(parent, root + 1, root + 7);
                }
                if (i + 1 < n) {
                    unionSet(parent, root + 2, root + 4 * n);
                }
            }
        }
        
        int regions = 0;
        for (int i = 0; i < 4 * n * n; ++i) {
            if (find(parent, i) == i) ++regions;
        }
        
        return regions;
    }
};