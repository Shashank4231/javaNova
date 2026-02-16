public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Shift result to make room for the bit we are about to add
            result <<= 1;
            
            // Extract the last bit of n and add it to result
            result |= (n & 1);
            
            // Use unsigned right shift (>>>) to move the next bit into place
            // This is crucial for handling negative numbers correctly in Java
            n >>>= 1;
        }
        return result;
    }
}