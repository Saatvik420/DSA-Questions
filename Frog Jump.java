class Solution {
    Boolean memo[][];
    HashMap<Integer, Integer> map;
    int dest;
    public boolean canCross(int[] stones) {
        int n=stones.length;
        memo=new Boolean[n][n+1];
        map=new HashMap<>(n);
        for(int i=0;i<n;i++) map.put(stones[i], i);
        dest=stones[n-1];
        return f(0,0);
    }
    private boolean f(int curr, int k) {
        if(curr==dest) return true;
        if(map.containsKey(curr)) {
            int ind=map.get(curr);
            if(memo[ind][k]!=null) return memo[ind][k];
            return memo[ind][k]=f(curr+k+1, k+1) || (k>1 && f(curr+k-1,k-1)) || (k>0 && f(curr+k,k));
        }
        return false;
    }
}