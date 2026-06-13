class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        boolean[] vis = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        for(int i =0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] pair : prerequisites){
            int course = pair[0];
            int prerequisite = pair[1];

            graph[prerequisite].add(course);
        }

        for(int i = 0 ; i < numCourses ; i++){
                if(!vis[i]){
                    if(isCycle(graph,i,vis,stack)){
                        return false;
                    }
                }
            }
        return true;
    }

    public boolean isCycle(ArrayList<Integer>[] graph, int curr, boolean[] vis, boolean[] stack){
            vis[curr] = true;
            stack[curr] = true;

            for(int i = 0 ; i < graph[curr].size() ; i++){
                if(stack[graph[curr].get(i)]){
                    return true;
                }
                else if (!vis[graph[curr].get(i)] && isCycle(graph, graph[curr].get(i), vis, stack)){
                    return true;
                }
            }

            stack[curr]= false;
            return false;
    }
}