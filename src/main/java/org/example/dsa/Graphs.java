package org.example.dsa;

import java.util.*;

public class Graphs {

    // Function to return Breadth First Traversal of given graph.
    //Breadth First Means Adjacent node first
    public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[v];

        /** Zero based Indexing hence starting from zero if 1 based indexing then should start from 1
          and increase visited array size by 1 **/
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int el = queue.poll();
            bfs.add(el);

            for(int i : adj.get(el)) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        return bfs;
    }

    // Function to return Depth First Traversal of given graph.
    //Depth First Means first going downWords in tree structure
    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        ArrayList<Integer> dfs = new ArrayList<>();
        dfs(0, visited, adj, dfs);
        return dfs;
    }

    private void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs) {

        visited[node] = true;
        dfs.add(node);

        for(int i : adj.get(node)) {
            if(!visited[i]) {
                dfs(i, visited, adj, dfs);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
       boolean[] visited = new boolean[n];
       int count = 0;

        /** Using dfs visiting every connected city and mark visited
         * so once in-countered after wards in below loop don't increment count, as it already belongs to
         * a province
         */
       for(int i = 0; i < n; i++) {
           //Do dfs for un-visited city and increment count
           if(!visited[i]) {
               dfsForProvince(visited, isConnected, i);
               count++;
           }
       }

       return count;
    }

    public void dfsForProvince(boolean[] visited, int[][] isConnected, int city) {
        visited[city] = true;
        for(int j = 0; j < isConnected.length; j++) {
            if(isConnected[city][j] == 1 && !visited[j]) {
                dfsForProvince(visited, isConnected, j);
            }
        }
    }

    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        /** Graphical Representation
         *         0
         *      1     4
         *    2   3
         */

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        Graphs gp = new Graphs();

        //BFS
        ArrayList < Integer > ans = gp.bfsOfGraph(5, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }

        System.out.print("\n");

        //DFS
        ArrayList < Integer > ans1 = gp.dfsOfGraph(5, adj);
        int n1 = ans1.size();
        for(int i = 0;i<n1;i++) {
            System.out.print(ans1.get(i)+" ");
        }

        System.out.print("\n");
        //Count Number of provinces
        int[][] isConnected = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] isConnected2 = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println("number of provinces are :: " + gp.findCircleNum(isConnected2));
    }
}
