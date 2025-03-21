class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        int rSum = 0;
        map.put(0,1);
        for(int i =0; i< nums.length;i++){
            rSum = rSum + nums[i];
            if(map.containsKey(rSum-k)){
                cnt = cnt + map.get(rSum-k);
            }
            map.put(rSum,map.getOrDefault(rSum,0)+1);
        }
         return cnt;
    }   
}