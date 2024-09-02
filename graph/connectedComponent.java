package graph;

import java.util.LinkedList;

public class connectedComponent {


    class adjListGraph {
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

        //dfs recursive approach for connected components
        public void dfs(){
            boolean[] isVisited = new boolean[V];
            int[] compId = new int[V];
            int count = 0;
            for (int v = 0; v < V; v++) {
                if (!isVisited[v]) {
                    dfs(v, isVisited, compId, count);
                    count++;
                }
            }
            System.out.println(count+1);
        }

        public void dfs(int v, boolean[] isVisited, int[] compId, int count) {
            isVisited[v] = true;
            compId[v] = count;

            //System.out.print(v + " ");
            for (int w : adj[v]) {
                if (!isVisited[w]) {
                    dfs(w, isVisited, compId, count);
                }
            }
        }
    }

    public static void main(String[] args) {

        connectedComponent cg = new connectedComponent();
        connectedComponent.adjListGraph g = cg.new adjListGraph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(2, 4);
        System.out.println(g);
        g.dfs();
    }
}
