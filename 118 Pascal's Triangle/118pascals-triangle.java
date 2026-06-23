class Solution {
    private static List<Integer> rows(int row) {
        int res = 1;
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        for (int col = 1; col < row; col++) {
            res *= (row - col);
            res /= col;
            temp.add(res);
        }
        return temp;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            ans.add(rows(i));
        }
        return ans;
    }
}