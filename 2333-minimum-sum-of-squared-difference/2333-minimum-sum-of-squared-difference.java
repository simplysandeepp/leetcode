class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2,
                                 int k1, int k2) {

        int n = nums1.length;
        int[] diff = new int[n];

        long k = (long) k1 + k2;
        long sum = 0;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);

            sum += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }
        if (sum <= k) {
            return 0L;
        }
        int low = 0;
        int high = maxDiff;

        while (low < high) {
            int mid = low + (high - low) / 2;

            long required = 0;

            for (int d : diff) {
                required += Math.max(0, d - mid);
            }

            if (required <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int threshold = low;

        for (int i = 0; i < n; i++) {
            if (diff[i] > threshold) {
                k -= diff[i] - threshold;
                diff[i] = threshold;
            }
        }

        for (int i = 0; i < n && k > 0; i++) {
            if (diff[i] == threshold) {
                diff[i]--;
                k--;
            }
        }

        long answer = 0;

        for (int d : diff) {
            answer += (long) d * d;
        }

        return answer;
    }
}