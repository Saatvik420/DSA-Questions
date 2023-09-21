class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(targetCapacity > jug1Capacity + jug2Capacity){
            return false;
        }
        int lastMod = jug1Capacity;
        int mod = jug2Capacity % jug1Capacity;
        while(mod != 0){
            int temp = lastMod;
            lastMod = mod;
            mod = temp % mod;
        }
        if(targetCapacity % lastMod == 0){
            return true;
        }
        return false;
    }
}