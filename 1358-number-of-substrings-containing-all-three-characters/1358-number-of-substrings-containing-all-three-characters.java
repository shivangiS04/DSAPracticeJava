class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int res = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(check(s.substring(i, j + 1))) res++;
            }
        }

        return res;
    }

    boolean check(String s){
        int a = 0, b = 0, c = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'a') a++;
            else if (ch == 'b') b++;
            else if (ch == 'c') c++;

            if(a > 0 && b > 0 && c > 0) return true;
        }

        return false;
    }
}