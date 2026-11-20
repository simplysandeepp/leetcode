class Solution {
       public int maxSelectedElements(int[] A) {
        Arrays.sort(A);
        int pre = -10, res = 1, c1 = 1, c2 = 1;
        for (int a : A) {
            if (a == pre) {
                c2 = c1 + 1;
            } else if (a == pre + 1) {
                c1++;
                c2++;
            } else if (a == pre + 2) {
                c1 = c2 + 1;
                c2 = 1;
            } else {
                c1 = c2 = 1;
            }
            res = Math.max(res, Math.max(c1, c2));
            pre = a;
        }
        return res;
    }
}