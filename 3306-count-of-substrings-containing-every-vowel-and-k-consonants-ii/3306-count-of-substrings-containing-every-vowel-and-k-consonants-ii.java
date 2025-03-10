class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public long countOfSubstrings(String word, int k) {
        int n = word.length(), j = -1, A = -1, E = -1, I = -1, O = -1, U = -1;
        long sol = 0;
        
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(isVowel(ch)){
                if(ch == 'a'){
                    A = i;
                }else if(ch == 'e'){
                    E = i;
                }else if(ch == 'i'){
                    I = i;
                }else if(ch == 'o'){
                    O = i;
                }else{
                    U = i;
                }
            }else{
                q.offer(i);
                if(q.size() > k){
                    j = q.poll();
                }
            }

            if(q.size() == k && A > j && E > j && I > j && O > j && U > j){
                int count = Math.min(A, E);
                count = Math.min(count, I);
                count = Math.min(count, O);
                count = Math.min(count, U);

                if(k > 0){
                    count = Math.min(count, q.peek());
                }

                sol += count - j;
            }
        }

        return sol;
    }
}