class Solution {
    public int minBitFlips(int start, int goal) {
        int flipCount = 0;
        int mask = 1;
        
        for (int i = 0; i < 32; i++) {  
            boolean startBit = (start & mask) != 0;
            boolean goalBit = (goal & mask) != 0;
            
            if (startBit != goalBit) {
                flipCount++;
            }
            
            mask <<= 1;
        }
        
        return flipCount;
    }
}