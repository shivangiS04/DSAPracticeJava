class Solution {
    public int nthUglyNumber(int n) {
        if (n==1) return 1;
        ArrayList<Integer> UglyNumList = new ArrayList<>();
        UglyNumList.add(1);
        int i = 0;
        int j = 0;
        int k = 0;
        while(UglyNumList.size() < n){
            int val1 = UglyNumList.get(i)*2;
            int val2 = UglyNumList.get(j)*3;
            int val3 = UglyNumList.get(k)*5;

            int min = Math.min(val1, Math.min (val2, val3));
            UglyNumList.add(min);

            if(min == val1) i++;
            if(min == val2) j++;
            if(min == val3) k++;

        }
        return UglyNumList.get(UglyNumList.size()-1);
        
    }
}