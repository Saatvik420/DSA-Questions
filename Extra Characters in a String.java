class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Integer[] dp = new Integer[s.length()];

        HashSet<String> dict = new HashSet<>(Arrays.asList(dictionary));

        return memo(dict,new StringBuilder(s),0,dp);
    }

    private int memo(HashSet<String> dict, StringBuilder s, int index,Integer[] dp){
        if(s.length() == index){
            return 0;
        }

        if(dp[index] != null){
            return dp[index];
        }

        int ans = memo(dict, s, index+1, dp)+1;

        for(int i = index;i < s.length();i++){
            String temp = s.substring(index, i+1);

            if(dict.contains(temp)){
                ans = Math.min(ans,memo(dict, s, i+1, dp));
            }
        }

        return dp[index] = ans;
    }
}