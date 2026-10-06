class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0, opening = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            } else {
                if (count == 0) {
                    opening++;
                } else {
                    count--;
                }
            }
        }
        return count + opening;
    }
}