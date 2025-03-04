class Solution {
    public boolean checkPowersOfThree(int n) {
        HashSet<Integer> set =  new HashSet<>();
        while(n>0)
        {
            int x = n,c = 0;
            while(x>0)
            {
                x/=3;
                c++;
            }
            if(!set.add(c-1))
                return false;
            n -= (int)Math.pow(3,c-1);
        }
        return true;
    }
}