class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        int bitA, bitB, bitC;

        while (a > 0 || b > 0 || c > 0) 
        {
            bitA = a & 1;  // Get the rightmost bit of a
            bitB = b & 1;  // Get the rightmost bit of b
            bitC = c & 1;  // Get the rightmost bit of c

            if ((bitA | bitB) != bitC) 
            {
                if (bitC == 0) 
                {
                    flips += (bitA + bitB);  // Flip both bits of a and b
                } 
                else 
                {
                    flips += 1;  // Flip any one bit of a or b
                }
            }

            a >>= 1;  // Shift right to get the next bit of a
            b >>= 1;  // Shift right to get the next bit of b
            c >>= 1;  // Shift right to get the next bit of c
        }
        return flips;
    }
}