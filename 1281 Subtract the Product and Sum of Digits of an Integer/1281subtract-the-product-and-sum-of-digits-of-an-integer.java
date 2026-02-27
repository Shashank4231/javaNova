class Solution {
    public int subtractProductAndSum(int n) {
        int add = 0;
        int mult = 1;
        while(n>0){
            add = add + (n%10);
            mult = mult * (n%10);
            n = n/10;
        }
        return (mult-add);
    }
}