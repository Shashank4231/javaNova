class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L' || moves.charAt(i) == '_')
                x--;
            if (moves.charAt(i) == 'R')
                x++;
        }
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'R' || moves.charAt(i) == '_')
                y++;
            if (moves.charAt(i) == 'L')
                y--;
        }
        return Math.max(Math.abs(x), Math.abs(y));
    }
}