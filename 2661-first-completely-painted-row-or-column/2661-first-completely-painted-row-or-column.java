class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rcnt = new int[m];
        int[] ccnt = new int[n];
        Map<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map.put(mat[i][j],new int[]{i,j});
            }
        }
        int tcells = m*n;
        for(int i=0;i<tcells;i++){
            int cells[] = map.get(arr[i]);
            rcnt[cells[0]]++;
            ccnt[cells[1]]++;
            if(rcnt[cells[0]] == n || ccnt[cells[1]] == m){
                return i;
            }
        }
        return -1;
    }
}