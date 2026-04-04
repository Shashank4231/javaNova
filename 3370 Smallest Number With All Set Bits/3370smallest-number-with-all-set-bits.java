class Solution {
    public int smallestNumber(int n) {
        int temp = 1;
        for(int i=1;i<=10;i++){
            if(Math.pow(2,i) - 1 >= n){
                temp = (int)Math.pow(2,i)-1;
                break;
            }
        }
        return temp;
    }
}