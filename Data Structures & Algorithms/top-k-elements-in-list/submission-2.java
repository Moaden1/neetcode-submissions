class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // redo 
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        } //map filled
        List<Integer>[] buckets = new List[nums.length + 1];

        map.forEach((num, freq) -> {
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }); //buckets filled - need to get top k from buckets

        int idx = 0;
        for (int i = nums.length; i >= 0 && idx < k; i--) {
            if (buckets[i] != null) {
                for (int topNum : buckets[i]) {
                    ans[idx] = topNum;
                    idx++;
                    if (idx >= k) {
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
