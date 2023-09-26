class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int difference = arr[1]-arr[0];
        for (int i=1; i< arr.length; i++){
            int val = arr[i]-difference;
            if(val != arr[i-1]) return false;
        }
        return true;
    }
}