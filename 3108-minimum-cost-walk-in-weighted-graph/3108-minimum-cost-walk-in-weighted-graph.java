class Solution {
    int[] parent;
    int[] depth;
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n];
        for(int i=0;i<n;i++) parent[i] = -1;
        depth = new int[n];

        int[] componentCost = new int[n];
        for(int i=0;i<n;i++){
            componentCost[i] = Integer.MAX_VALUE;
        }
        for(int[] edge : edges){
            union(edge[0], edge[1]);
        }
        for(int[] edge : edges){
            int root = find(edge[0]);
            componentCost[root] &= edge[2];
        }
        int[] ans = new int[query.length];
        for(int i=0;i<query.length;i++){
            int start = query[i][0];
            int end = query[i][1];
            if(find(start) != find(end)){
                ans[i] = -1;
            }else{
                int root = find(start);
                ans[i] = componentCost[root];
            }
        }
        return ans;
    }
    public int find(int node){
        if(parent[node] == -1) return node;
        return parent[node] = find(parent[node]);
    }
    public void union(int node1, int node2){
        int root1 = find(node1);
        int root2 = find(node2);

        if(root1 == root2) return;

        if(depth[root1] < depth[root2]){
            int tmp = root1;
            root1 = root2;
            root2 = tmp;
        }
        parent[root2] = root1;

        if(depth[root1] == depth[root2]){
            depth[root1]++;
        }
    }
}