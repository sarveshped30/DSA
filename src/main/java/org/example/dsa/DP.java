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

    public int findMinEnergyForFrogJump(int[] heights) {
        int n = heights.length;

        if(n == 0) return 0;        // No energy consumed
        if(n == 1) return 0;        // No energy consumes as start point

        int prev = 0;       //Single jump energy consumption
        int prev2 = 0;      // Double jump energy consumption

        for(int i = 1; i < n; i++) {        //Starting from 1st index
            int singleJump = prev + Math.abs(heights[i-1] - heights[i]);        //Energy on current index for single jump
            int doubleJump = Integer.MAX_VALUE;
            if(i > 1) {
                doubleJump = prev2 + Math.abs(heights[i-2] - heights[i]);       //Energy on current index for double jump
            }

            int curr = Math.min(singleJump, doubleJump);        //Min energy consumption;
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    public int findMinCostForKJumps(int k, int[] heights) {
        int n = heights.length;

        //Memorization (memorize cost at every index)
        int[] dp = new int[n];

        //Starting from 1 index as 0th index is the starting point
        for(int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;      //To avoid doing min func with zero at first

            int j = 1;
            while(j <= k && i - j >= 0) {
                int x = dp[i-j] + Math.abs(heights[i] - heights[i-j]);          //Existing cost to new cost at i - j
                dp[i] = Math.min(dp[i], x);
                j++;
            }
        }

        return dp[n-1];
    }

    //house robber Problem with no adjacent house robs
    //Memorization and tabulation
    public int maxCashRobbed(int[] arr) {
        int n = arr.length;

        if(n == 0) return 0;

        int[] dp = new int[n];
        dp[0] = arr[0];

        for(int i = 1; i < n; i++) {
            int pick = arr[i];

            if(i > 1) {
                pick += dp[i - 2];        //No adjacent so i - 2 + current element val
            }

            int notPick = dp[i - 1];            // No pick so 0 + prev cumulated value

            dp[i] = Math.max(pick, notPick);    //Max of both subsequence
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        DP dp = new DP();

        //Climb stairs problem
        //System.out.println(dp.climbStairs(45));

        //Frog jump problem
        int[] heights = new int[]{30, 10, 60, 10, 60, 50, 10};
        //System.out.println(dp.findMinEnergyForFrogJump(heights));

        //find cost for k jumps
        int[] heights2 = new int[]{10, 30, 40, 50, 20};
        int[] heights3 = new int[]{10, 20, 10};
        System.out.println(dp.findMinCostForKJumps(3, heights));

        //house robber
        int[] house = new int[]{2, 1, 1, 2};
        System.out.println(dp.maxCashRobbed(house));

    }
}
