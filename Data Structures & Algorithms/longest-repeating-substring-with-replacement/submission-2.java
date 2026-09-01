class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int maxFreq = 1;
        while (l < s.length() && r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            // checking validity of substring
            // need to decrement from window when moving l and then also 
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));
            int currWindowSize = (r - l) + 1;
            int replacements_needed = currWindowSize - maxFreq;
            if (k >= replacements_needed) {
                // valid window
                max = Math.max(max, currWindowSize);
                r++;
            } else {
                // invlaid
                if (map.get(s.charAt(l)) <= 1) {
                    map.remove(s.charAt(l));
                } else {
                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                }
                l++;
                // incrementing r to avoid adding it back to map (alternatively can remove it temporarlily)
                r++;
            }
        }
        return max;
    }
}
