class Solution {
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        boolean isNegative = num < 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }

        if (isNegative) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}