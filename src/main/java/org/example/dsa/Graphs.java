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
    }
}
