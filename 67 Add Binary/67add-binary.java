class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            if (i >= 0) {
                // Subtract '0' to convert char to int
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            
            // Append the result bit (0 or 1)
            sb.append(sum % 2);
            // Calculate new carry
            carry = sum / 2;
        }

        // The bits were added in reverse order, so we flip it
        return sb.reverse().toString();
    }
}