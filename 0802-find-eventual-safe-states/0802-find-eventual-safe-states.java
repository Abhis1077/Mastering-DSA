class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> result = new ArrayList<>();
        int[] state = new int[n];

        for(int i = 0; i<n;i++){
            if(isSafe(graph, i, state)){
            result.add(i);
            }
        }
        return result;
    }

    public boolean isSafe(int[][] graph, int curr, int[] state){

        if (state[curr] == 1) return false;
        if (state[curr] == 2) return true;
        state[curr] = 1;

        for(int i = 0; i<graph[curr].length;i++){
            if((state[graph[curr][i]] == 1) || !isSafe(graph, graph[curr][i], state)){
                return false;
            }
            
        }
        state[curr] = 2;
        return true;
    }
}