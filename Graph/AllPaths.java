import java.util.ArrayList;

public class AllPaths {
    static class Edge {

        int src;
        int dest;
        int wt;

        public Edge(int s, int d,int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(6, 5, 1));

    }

    public static String shortPath  = null;
    public static void allPossiblePaths(ArrayList<Edge> graph[], int curr, boolean[] vis,String path, int tar){
        if(curr == tar){
        System.out.println(path);
        if(shortPath == null || path.length() < shortPath.length()){
                shortPath = path;
            }
        return;
        }

        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                
            allPossiblePaths(graph, e.dest,vis,path+e.dest,tar);
            
            }
        }

        vis[curr] = false;
    }

    public static void main(String[] args) {
        int V = 7;
        int curr = 0;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean[] vis = new boolean[V];

        allPossiblePaths(graph, curr, vis, "0", 5);
        System.out.print(shortPath);
    }
}
