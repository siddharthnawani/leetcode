package com.sid.leetcode;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {

        int r=grid.length;
        int c=grid[0].length;
        int[][] dp=new int[r][c];
        dp[0][0]=grid[0][0];
        for(int i=0;i<r;i++ ){
            for(int j=0;j<c;j++){
                if(i==0 && j==0)
                    continue;
                else if(i==0 || j==0)
                    dp[i][j]= i==0 ? grid[i][j] + dp[i][j-1] : grid[i][j] + dp[i-1][j];
                else
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[r-1][c-1];



    }

    public static void main(String[] args) {
        int[][] path = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new MinimumPathSum().minPathSum(path));
    }
}
