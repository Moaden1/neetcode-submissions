class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int h = nums.length - 1;
            while (l < h) {
                if (nums[i] + nums[l] + nums[h] < 0) {
                    l++;
                } else if (nums[i] + nums[l] + nums[h] > 0) {
                    h--;
                } else {
                    List<Integer> newTriplet = new ArrayList<>();
                    newTriplet.add(nums[i]);
                    newTriplet.add(nums[l]);
                    newTriplet.add(nums[h]);
                    set.add(newTriplet);                
                    l++;
                    h--;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> list : set) {
            ans.add(list);
        }
        return ans;
    }
}
