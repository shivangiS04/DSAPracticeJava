class Solution {
    public Boolean checkloop(int[][]graph,int ind,int[]vis){
        if(vis[ind]!=0){
            return vis[ind]==1;
        }
        vis[ind]=1;
        for(int i:graph[ind]){
            if(checkloop(graph,i,vis)){
                return true;
            }
        }
        vis[ind]=2;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> li=new ArrayList<>();
        int m=graph.length;
        int[]vis=new int[m];
        int n=graph[1].length;
        for(int i=0;i<m;i++){
            if(!checkloop(graph,i,vis)){
                li.add(i);
            }
        }
        return li;
    }
}