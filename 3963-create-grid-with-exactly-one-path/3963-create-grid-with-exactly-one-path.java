class Solution {
    public String[] createGrid(int m, int n) {
        char[][] g = new char[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                g[i][j] = '#';
            }
        }
        for(int j=0; j<n; j++){
            g[0][j]='.';
        }
        for(int i=0; i<m; i++){
            g[i][n-1] ='.';
        }
        String[] ans = new String[m];
        for(int i=0; i<m; i++){
            ans[i] = new String(g[i]);
        }
        return ans;
    }
}