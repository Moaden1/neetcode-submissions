class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replace(" ", "");
        s = s.replaceAll("[^a-zA-Z0-9]", ""); //only aplhanumneric
        int l = 0;
        int h = s.length() - 1;
        while (l < h) {
            if (s.charAt(l) != s.charAt(h)) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}
