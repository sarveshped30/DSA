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

    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        Graphs gp = new Graphs();
        ArrayList < Integer > ans = gp.bfsOfGraph(5, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }
    }
}
