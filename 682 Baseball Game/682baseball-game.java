class Solution {
    public int calPoints(String[] operations) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];

            if (op.equals("C")) {
                arr.remove(arr.size() - 1);
            } else if (op.equals("D")) {
                arr.add(2 * arr.get(arr.size() - 1));
            } else if (op.equals("+")) {
                arr.add(arr.get(arr.size() - 1) + arr.get(arr.size() - 2));
            } else {
                arr.add(Integer.valueOf(op));
            }
        }

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}