class Solution {
    public int minOperations(int[] arr) {
        int count = 0;
        for(int i = 0 ; i < arr.length -2 ; i++){
            if(arr[i] == 0){
                arr[i] = 1 - arr[i];
                arr[i+1] = 1 - arr[i+1];
                arr[i+2] = 1 - arr[i+2];
                count++;
            }
        }

        for(int num : arr){
            if(num == 0){
                return -1;
            }
        }

        return count;
    }
}