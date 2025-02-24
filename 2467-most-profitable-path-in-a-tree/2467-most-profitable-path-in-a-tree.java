class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        ArrayList<Integer>[] grap=new ArrayList[amount.length];
        for(int i=0;i<grap.length;i++) grap[i]=new ArrayList<>();
        for(int[] edge:edges){
            grap[edge[0]].add(edge[1]);
            grap[edge[1]].add(edge[0]);
        }
        int[] bobpat=new int[amount.length];
        Arrays.fill(bobpat,-1);
        ArrayList<Integer> path=new ArrayList<>();
        fillbobpat(bob,-1,path,grap);
        for(int i=0;i<path.size();i++){
            bobpat[path.get(i)]=i;
        }
        return getAliceMaxScor(0,-1,0,bobpat,grap,0,amount);
    }

    private boolean fillbobpat(int nod,int parent,ArrayList<Integer> path,ArrayList<Integer>[] grap){
        if(nod==0) return true;
        for(int nn:grap[nod]){
            if(nn!=parent){
                path.add(nod);
                if(fillbobpat(nn,nod,path,grap)) return true;
                path.remove(path.size()-1);
            }
        }
        return false;
    }

    private int getAliceMaxScor(int nod,int parent,int curr,int[] bobpat,ArrayList<Integer>[] grap,int time,int[] amount){
        if(bobpat[nod]==-1 || bobpat[nod]>time){
            curr+=amount[nod];
        }
        else if(bobpat[nod]==time){
            curr+=amount[nod]/2;
        }
        if(grap[nod].size()==1 && nod!=0) return curr;
        int max=Integer.MIN_VALUE;
        for(int nn:grap[nod]){
            if(nn!=parent){
                max=Math.max(max,getAliceMaxScor(nn,nod,curr,bobpat,grap,time+1,amount));
            }
        }
        return max;
    }
}