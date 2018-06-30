class Solution {
    public boolean isMatch(String s, String p) {
        int l = s.length(), m = p.length();
        boolean[][] dp = new boolean[l+1][m+1];
        for(int i=0;i<=l;i++){
            for(int j =0;j<=m;j++){
                if(i==0 && j==0)
                    dp[i][j] = true;
                else if(i==0 && p.charAt(j-1)=='*')
                    dp[i][j] = dp[i][j-1];
                else if(i>0 && j>0){
                    if(p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='?')
                        dp[i][j] = dp[i-1][j-1];
                    else if(p.charAt(j-1)=='*')
                        dp[i][j] = dp[i-1][j-1] | dp[i-1][j] | dp[i][j-1];
                }
                //System.out.print(dp[i][j] + " ");
            }
            //System.out.println();
        }
        return dp[l][m];
    }
}
