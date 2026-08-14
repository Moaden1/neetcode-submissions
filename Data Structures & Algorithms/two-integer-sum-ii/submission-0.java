class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int h = numbers.length - 1;
        int[] ans = new int[2];
        while (l < h) {
            if (numbers[l] + numbers[h] > target) {
                h--;
            } else if (numbers[l] + numbers[h] < target) {
                l++;
            } else {
                // order doesn't matter
                ans[0] = l + 1;
                ans[1] = h + 1;
                break;
            }
        }
        return ans;
    }
}
