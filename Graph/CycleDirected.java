import java.util.*;

public class CycleDirected {
    
    static class Edge {
    
        int src;
        int dest;

        public Edge(int s , int d){
            this.src = s;
            this.dest = d;
        }  
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,2));
    }

    public static boolean CyclicDetection(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack){
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            else if(!vis[e.dest] && CyclicDetection(graph, e.dest, vis, stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph){
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] stack = new boolean[n];

        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == false && CyclicDetection(graph, i, vis, stack)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.print(isCyclic(graph));


    } 
}
