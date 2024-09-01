package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import stack.stack;

public class adjListGraph {

    private int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public adjListGraph(int n){
        this.V = n;
        this.E = 0;
        this.adj = new LinkedList[n];

        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    public String toString(){
        StringBuilder sb  =  new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : adj[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    //bfs traversal
    public void bfs(int s){
        boolean[] isVisited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        isVisited[s] = true;
        q.offer(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u +" ");
            for (int v : adj[u]) {
                if (!isVisited[v]) {
                    isVisited[v] = true;
                    q.offer(v);
                }
            }

        }
    }

    //dfs traversal
    public void dfs(int s){
        boolean[] isVisited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        st.push(s);
        while (!st.isEmpty()) {
            int u = st.pop();
            if (!isVisited[u]) {
                isVisited[u] = true;
                System.out.print(u + " ");

                for (int v : adj[u]) {
                    if (!isVisited[v]) {
                        st.push(v);
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        adjListGraph g = new adjListGraph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 4);
        System.out.println(g);
        g.bfs(0);

        System.out.println(g);

        g.dfs(0);



    }
    
}
