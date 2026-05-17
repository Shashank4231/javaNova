class Solution {
    public String defangIPaddr(String address) {
        String str = address.replace(".", "[.]");
        return str;
    }
}