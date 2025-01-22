class Pair {
    int row;
    int col;

    public Pair(int row, int col){
        this.row= row;
        this.col =col;
    }
};
class Solution {
    public int[][] highestPeak(int[][] isWater) {

        int m = isWater.length;
        int n = isWater[0].length;

        Queue<Pair>q = new LinkedList<>();


        int [][] height = new int [m][n];
        for(int []row : height){

            Arrays.fill(row, -1);
        }

        
        
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(isWater[i][j] == 1){
                    q.offer(new Pair(i, j));
                    height[i][j] = 0;
                    
                }
            }
        }

        
        //how to track 1 ?
        //used queue to get all 1, queue of {x, y} or pair


        //how to move direction
       int[][] direction = {
    {0, 1},
    {1, 0},
    {0, -1},
    {-1, 0}
};

int heightOfNextLayer = 1;



while(!q.isEmpty()) {

    int size = q.size();

    for(int i=0; i<size; i++){
        Pair layer = q.poll();

        

        for(int d=0; d <4;d++){
            
            int x = layer.row + direction[d][0];
            int y = layer.col + direction[d][1];

            


             


            if(x >= 0 && y >= 0 && x < m && y < n && height[x][y] == -1) {
               System.out.println( d + " " + x + " " + y);
                height[x][y] = heightOfNextLayer;
                q.offer(new Pair(x, y));
            }
        }
        



    }
    heightOfNextLayer ++ ;
    
    


}


        //how to do multiple bfs

    return height;




        



        
    
}
}