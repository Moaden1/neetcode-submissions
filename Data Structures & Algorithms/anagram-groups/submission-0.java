class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        // 'cat' -> 'act' turn string into char array and
        // then sort char array before turnign back itno stirng.
        for (String word : strs) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if (map.containsKey(sorted)) {
                // grab existing lsit from hasdhmap
                List<String> existingList = map.get(sorted);
                existingList.add(word);
                map.put(sorted, existingList); //cannot use .add here since arraylsit will return true/null
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(word);
                map.put(sorted, newList);
            }
        }

        map.forEach((key, value) -> {
            ans.add(value);
        });
        return ans;
    }
}
