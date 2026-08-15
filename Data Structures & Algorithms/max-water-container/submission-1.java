class Solution {
    public int maxArea(int[] heights) {
        // idea: by startying at both ends our width is as great as it gets so to avoid TLE we move pointers based on shorter bar
        int l = 0;
        int h = heights.length - 1;
        int max = l;
        while (l < h) {
            max = Math.max(max, ((h - l) * Math.min(heights[h], heights[l])));
            if (heights[l] < heights[h]) {
                l++;
            } else {
                h--;
            }
        }
        return max;
    }
}