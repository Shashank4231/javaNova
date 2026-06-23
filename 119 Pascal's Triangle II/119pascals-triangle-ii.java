class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        long res = 1;
        list.add(1);
        for (int col = 1; col <= rowIndex; col++) {
            res *= (rowIndex - col + 1);
            res /= col;
            list.add((int)res);
        }
        return list;
    }
}