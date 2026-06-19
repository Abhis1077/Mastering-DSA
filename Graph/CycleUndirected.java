import java.util.ArrayList;

public class CycleUndirected {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        //graph[0].add(new Edge(0, 2));
        //graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
       // graph[1].add(new Edge(1, 2));
        //graph[2].add(new Edge(2, 0));
        //graph[2].add(new Edge(2, 1));
        //graph[3].add(new Edge(3, 0));
        //graph[3].add(new Edge(3, 4));
        //graph[4].add(new Edge(4, 3));
    }

    static boolean isCyclicutil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par){
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);                
            if(vis[e.dest] && par!= e.dest){
                return true;
            }
            else if(!vis[e.dest]){
                if(isCyclicutil(graph, vis, e.dest, curr))
                    return true;
            }
        }
        return false;

    }

    static boolean isCyclic(ArrayList<Edge>[] graph){
        int n = graph.length;
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!vis[i]){
            if (isCyclicutil(graph, vis, i, -1) ) {
                return true;
            }
        }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        System.out.print(isCyclic(graph));
    }
    
}