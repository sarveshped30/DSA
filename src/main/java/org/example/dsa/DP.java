package org.example.dsa;

import java.util.Arrays;

/** Dp is solution for problems which ask for patterns
 Steps to Solve
 1. Memorize
 2. tabulate (instead of recursion use forLoop's)
 3. optimize space by using previous values
 **/

public class DP {

    public int climbStairs(int n) {

        int prev0 = 1;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {
             int temp = prev1;
             prev1 = prev0 + prev1;
             prev0 = temp;
        }

        return prev1;
    }

    /*public int recurseClimb(int n, int[] dp) {
        if(dp[n] == -1) {
            dp[n] = recurseClimb(n - 1, dp) + recurseClimb(n - 2, dp);
        }

        return dp[n];
    }*/


    public static void main(String[] args) {
        DP dp = new DP();

        System.out.println(dp.climbStairs(45));
    }
}
