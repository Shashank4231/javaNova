import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> times = new ArrayList<>();
        
        // Iterate through all possible hours (0-11)
        for (int h = 0; h < 12; h++) {
            // Iterate through all possible minutes (0-59)
            for (int m = 0; m < 60; m++) {
                // If the sum of set bits in hour and minute equals turnedOn
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    // String.format handles the leading zero for minutes
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }
}