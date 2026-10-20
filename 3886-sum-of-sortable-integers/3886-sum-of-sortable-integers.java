class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        long[] packed = new long[n];
        for(int i=0; i<n; i++) {
            packed[i] = ((long) nums[i] << 17) | i;
        }
        Arrays.sort(packed);
        int[] p = new int[n];
        for(int i=0;i<n;i++) {
            p[i] = (int)(packed[i] & 0x1FFFF);
        }
        int ans =0;
        for(int k=1; k<=n; k++) {
            if(n%k != 0) continue;
            boolean ok = true;
            for(int s=0; s<n && ok; s+=k) {
                int block = s/k;
                for(int i =s; i<s+k && ok; i++){
                    if(p[i] / k != block) ok =false;
                }
                    if(ok) {
                        int d=0; 
                        for(int j=s; j<s+k && ok; j++) {
                            int next = s+(j-s+1)%k;
                            if(nums[j] > nums[next]) {
                                if(++d > 1) ok = false;
                            }
                        }
                    }
                }
                if(ok) ans += k;
            }
        return ans;
    }
}