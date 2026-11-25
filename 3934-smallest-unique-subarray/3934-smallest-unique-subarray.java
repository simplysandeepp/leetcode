class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int[] temp = nums;
        int low=1;
        int high = temp.length;
        while(low < high) {
            int mid = low +(high-low)/2;
            if(solve(temp, mid)) {
                high = mid;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }
    public boolean solve(int[] a, int len) {
        int n = a.length;
        long mod = 1_000_000_007L, base = 131L, pow =1, h=0;
        long[] hash = new long[n-len+1];
        for(int i=0; i<len-1; i++) {
            pow = pow * base%mod;
        }
        for(int i=0; i<len; i++){
            h =(h*base+a[i]) % mod;
        }
        hash[0] = h;
        for(int i=len; i<n; i++){
            h = (h- a[i-len] * pow % mod + mod) % mod;
            h = (h * base + a[i]) % mod;
            hash[i-len+1] = h;
        }
        Arrays.sort(hash);
        for(int i=0; i<hash.length;i++){
            if ((i==0 || hash[i] != hash[i-1]) && (i==hash.length-1 || hash[i] != hash[i+1])) {
                return true;
            }
        }
        return false;
    }
}