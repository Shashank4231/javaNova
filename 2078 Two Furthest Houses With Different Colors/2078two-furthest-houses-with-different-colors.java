class Solution {
    public int maxDistance(int[] colors) {
        int max = 0;
        for(int i=0;i<colors.length;i++){
            for(int j=0;j<colors.length;j++){
                if(colors[i] != colors[j]){
                    max = Math.max(max,Math.abs(i-j));
                }
            }
        }
        return max;
    }
}