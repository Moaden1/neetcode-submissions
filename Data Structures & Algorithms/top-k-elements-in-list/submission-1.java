class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>(); //num to count
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            /*if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                // first occurence of this unique number
                map.put(num, 1);
            }*/
        }
        /*
        map.forEach((key, value) -> {
            pq.add(key);
        }); */

        List<Integer>[] buckets = new List[nums.length + 1];
        map.forEach((num, freq) -> {
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        });
        // buckets are now filled

        int idx = 0; //or reverse list and start @ i = 0
        for (int i = nums.length; i >= 0 && idx < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    ans[idx] = num;
                    idx++;
                    if (idx >= k) {
                        return ans;
                    }
                }
            }
        }
        return ans;
    }
}
