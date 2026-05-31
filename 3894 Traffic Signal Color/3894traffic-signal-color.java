class Solution {
    public String trafficSignal(int timer) {
        if(timer == 0) return new String("Green");
        if(timer == 30) return new String("Orange");
        if(timer > 30 && timer <= 90) return new String("Red");
        return new String("Invalid");
    }
}