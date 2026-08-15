class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int origI = i;
            while (i < s.length() && !set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                i++;
            }
            max = Math.max(max, set.size());
            i = origI;
        }
        return max;
    }
}
