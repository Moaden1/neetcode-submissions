class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = (nums.length >= 1 ? 1 : 0);
        for (int num : set) {
            int curr = 1;
            if (!set.contains(num - 1) && set.contains(num + 1)) {
                while (set.contains(num + 1)) {
                    curr++;
                    num = num + 1;
                }
                max = Math.max(curr, max);
            }
        }
        return max;
    }
}
