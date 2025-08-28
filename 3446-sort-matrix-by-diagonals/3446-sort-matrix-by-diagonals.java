class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, PriorityQueue<Integer>> diagMap = new HashMap<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j< n; j++){
                int key = i - j;

                if(!diagMap.containsKey(key)){
                    if(key >= 0){
                        diagMap.put(key, new PriorityQueue<>(Collections.reverseOrder()));
                    }else{
                        diagMap.put(key, new PriorityQueue<>());
                    }
                }
                diagMap.get(key).add(grid[i][j]);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int key = i - j;
                grid[i][j] = diagMap.get(key).poll();
            }
        }
        return grid;
        
    }
}