class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb=new StringBuilder("");
        while(columnNumber!=0)
        {
            columnNumber-=1;
            int rem=columnNumber%26;
            sb.append((char)(rem+65));
            columnNumber/=26;
        }
        sb=sb.reverse();
        return sb.toString();
        
    }
}