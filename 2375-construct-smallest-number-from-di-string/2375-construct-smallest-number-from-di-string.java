class Solution {
    public String smallestNumber(String pattern) {
        int number=pattern.length()+1;
        boolean[] used=new boolean[number+1];
        int[] array=new int[number];
        smallest(pattern,0,used,array,'I');
        StringBuilder s=new StringBuilder();
        for(int i=0;i<array.length;i++){
            s.append(array[i]);

        }
        return s.toString();

    }
    public boolean smallest(String pattern, int index,boolean[] used,int[] array,Character ch){
        if(index==array.length) return true;
        if(array[index]!=0) return smallest(pattern,index+1,used,array,index < pattern.length() ? pattern.charAt(index) : 'I');
        if(index==0){
            for(int i=1;i<=array.length;i++){
                if(used[i]) continue;
                array[index]=i;
                used[i]=true;
                if(smallest(pattern,index+1,used,array,index < pattern.length() ? pattern.charAt(index) : 'I')) return true;
                array[index]=0;     
                used[i]=false;
            }
        }
        else{
            if(ch=='I'){
                for(int i=array[index-1]+1;i<=array.length;i++){
                    if(used[i]) continue;
                    array[index]=i;
                    used[i]=true;
                    if(smallest(pattern,index+1,used,array,index < pattern.length() ? pattern.charAt(index) : 'I')) return true;
                    array[index]=0;
                    used[i]=false;
                }
            }
            else{
                for(int i=array[index-1]-1;i>=1;i--){
                    if(used[i]) continue;
                    array[index]=i;
                    used[i]=true;
                    if(smallest(pattern,index+1,used,array,index < pattern.length() ? pattern.charAt(index) : 'I')) return true;
                    array[index]=0;
                    used[i]=false;
                }
            }
        }
        return false;
        
    }
}