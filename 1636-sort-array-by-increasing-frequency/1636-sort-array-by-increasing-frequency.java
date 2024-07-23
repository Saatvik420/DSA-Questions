class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> m = new HashMap<>();

        for(int i:nums) m.put(i,m.getOrDefault(i,0)+1);

        List<Integer> l = new ArrayList<>(m.keySet());
        l.sort((ob1,ob2)-> m.get(ob1)-m.get(ob2));
        int k=0,v=l.get(0);
        for(int i=0;i<l.size();)
        {
            int t = m.get(l.get(i));
            ArrayList<Integer> tt = new ArrayList<>();

            while(i<l.size() && m.get(l.get(i))==t)
            {
                tt.add(l.get(i));i++;
            }
            Collections.sort(tt);
            for(int j=tt.size()-1;j>=0;j--)
            {
                for(int x=0;x<t;x++)
                {
                    nums[k++] = tt.get(j);
                }
            }
            // System.out.println(tt);
        }
        return nums;
    }
}