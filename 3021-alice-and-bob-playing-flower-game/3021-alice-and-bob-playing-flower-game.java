class Solution {
    public long flowerGame(int n, int m) {
        long OddN = (n+1)/2;
        long evenN = n / 2;
        long oddM = (m + 1)/2;
        long evenM = (m)/2;

        return (OddN * evenM) + (evenN * oddM);
        
    }
}