class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
       List<String> ans=new ArrayList<>();
        
        int[] freq2=maxfreq(words2);
        for(String str:words1){
            //getfrequency is intialized inside the for loop so each string's freq 
            //we get and compare with the words2 freq
            int[] freq1=getfrequency(str);
            if(compare(freq1,freq2)){
                ans.add(str);
            }
        }
        return ans;

    }
    //for words2 we can have tt eo,oo for 1st freq e=1,o=1
    //for 2nd freq o=2 then change o freq to 2 instead of freq++ which equals 3
    //takes input as string[] 
    public int[] maxfreq(String[] a){
         int[] max = new int[26];
        for(String str:a){
            int[] curfreq=getfrequency(str);
            for(int i=0;i<26;i++){
            max[i]=Math.max(max[i],curfreq[i]);
        }
        }
        return max;
    }



    //create a freq array for a-z for storing freq of each alphabet in string 
    public int[] getfrequency(String s){
        int[] freq=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        return freq;
    }


    //this is to compare the freq of words1 to words2 if freq of any letter in words1 is greater means false 
    public boolean compare(int[] s,int[] t){
        for(int i=0;i<26;i++){
            if(s[i]<t[i]){
                return false;
            }
        }
        return true;
    }
}