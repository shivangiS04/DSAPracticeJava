class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        int maxDiagSq = 0;

        for(int[] rect : dimensions){
            int l = rect[0];
            int w = rect[1];
            int diagSq = l*l + w*w ;
            int area = l*w;

            if(diagSq > maxDiagSq){
                maxDiagSq = diagSq;
                maxArea = area;
            }
            else if (diagSq == maxDiagSq && area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
        
    }
}