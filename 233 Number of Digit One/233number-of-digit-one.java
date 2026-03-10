// class Solution {
//     public int countDigitOne(int n) {
//         int num;
//         int count = 0;
//         while (n >= 0) {
//             int temp = n;
//             while (temp > 0) {
//                 num = temp % 10;
//                 if (num == 1) {
//                     count++;
//                 }
//                 temp /= 10;
//             }
//             n --;
//         }
//         return count;
//     }
// }
class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        long factor = 1;
        while (factor <= n) {
            long lower = n % factor;
            long current = (n / factor) % 10;
            long higher = n / (factor * 10);

            if (current == 0) {
                count += higher * factor;
            } else if (current == 1) {
                count += higher * factor + lower + 1;
            } else {
                count += (higher + 1) * factor;
            }
            factor *= 10;
        }
        return count;
    }
}