class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int[] arr =nums.clone();
        int ans = Integer.MAX_VALUE;
        int pos = 0;
        while(pos < n && nums[pos]!=0) {
            pos++;
        }
        if(isRotate(nums, pos, n)) {
            ans = Math.min(ans, Math.min(pos,n-pos+2));
        }
        int [] rev = new int[n];
        for(int i=0; i<n; i++){
            rev[i] = arr[n-1-i];
        }
        int q =0;
        while(q < n && rev[q] != 0) {
            q++;
        }
        if(isRotate(rev,q, n)) {
            ans = Math.min(ans, 1+Math.min(q,n-q));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private boolean isRotate(int[] arr, int s, int n) {
        for(int i=0; i<n; i++) {
            if(arr[(s+i) % n] != i) return false;
        }
        return true;
    }
}