class Solution {
    class DisjointSet{
        int[] parent;
        int[] rank;
        int components;

        public DisjointSet(int n){
            parent = new int[n+1];
            rank = new int[n+1];
            components = n;
            for(int i = 1; i<=n;i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int i){
            if(parent[i] == i){
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        public boolean unionSet(int i ,int j){
            int rootI = find(i);
            int rootJ = find(j);

            if(rootI == rootJ){
                return false;
            }

            if(rank[rootI]>rank[rootJ]){
                parent[rootJ]= rootI;
            }
            else if(rank[rootI]<rank[rootJ]){
                parent[rootI] = rootJ;
            }
            else{
                parent[rootI] = rootJ;
                rank[rootJ]++;
            }
            components--;
            return true;
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {

        int removeEdge = 0;

        DisjointSet AliceU = new DisjointSet(n);
        
        DisjointSet BobU = new DisjointSet(n);

        
        for(int[] edge : edges){
            if(edge[0] == 3){
                boolean AliceBool = AliceU.unionSet(edge[1],edge[2]);
                boolean BobBool = BobU.unionSet(edge[1],edge[2]);
                 if (BobBool || AliceBool){
                    removeEdge++;
                }
            }
            
        }

        for(int[] edge : edges){
            if(edge[0] == 1){
                if(AliceU.unionSet(edge[1],edge[2]))
                {
                    removeEdge++;
                }
            }
            else if (edge[0] == 2){
                if(BobU.unionSet(edge[1],edge[2]))
                {
                    removeEdge++;
                }
            }
            
        }

        if( AliceU.components > 1 || BobU.components >1){
            return -1;
        }

        return edges.length - removeEdge;
    }
}