class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int num : arr){
            freqMap.put(num, freqMap.getOrDefault(num,0) + 1);
        }

        int result = -1;
        for(int num : freqMap.keySet()){
            if(num == freqMap.get(num)){
                result = Math.max(result, num);
            }
        }
        
        return result;
    }
}