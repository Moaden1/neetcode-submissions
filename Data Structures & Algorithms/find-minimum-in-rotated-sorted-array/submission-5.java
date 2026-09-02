class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        int low = nums[0]; //assumes no rotation to styart
        while (l <= h) {
            if (nums[l] < nums[h]) {
                low = Math.min(low, nums[l]);
                break;
            }
            int mid = l + (h - l) / 2;
            low = Math.min(low, nums[mid]);
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                // lower half search
                h = mid - 1; 
            }
        }
        return low;
    }
}    