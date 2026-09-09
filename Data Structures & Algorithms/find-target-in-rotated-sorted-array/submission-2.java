class Solution {
    public int search(int[] nums, int target) {
        // when approachiojh problems figure out what you need todo in order to get to the solution (sounds simple enough)
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[h] == target) {
                return h;
            }
            if (nums[l] == target) {
                return l;
            }
            // find which half the subarray our target is on (only can be two sides)
            if (nums[l] <= nums[mid]) { // must in in left half? possibly
                if (nums[l] <= target && target < nums[mid]) {
                    // search left of this sorted half
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // right half
                if (nums[mid] <= target && target < nums[h]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }
        return -1;
    }
}
