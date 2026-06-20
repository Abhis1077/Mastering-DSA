class Solution {
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] flight : flights){
            adj.computeIfAbsent(flight[0], z-> new ArrayList<>()).add(new int[]{flight[1],flight[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src,0});

        int stops = 0;

        while(!q.isEmpty() && stops <= k){
            int size = q.size();

            for(int i = 0; i < size;i++){
                int[] curr = q.poll();

                int u = curr[0];
                int cost  = curr[1];

                if(!adj.containsKey(u)){
                    continue;
                }
                for(int[] neigh : adj.get(u)){
                    int v = neigh[0];
                    int wt = neigh[1];
                    if(cost + wt < dist[v]){
                        dist[v] = cost + wt;
                        q.offer(new int[]{v, dist[v]});
                    }
                }

            }
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }
}