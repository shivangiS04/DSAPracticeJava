class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(nums,0,new ArrayList<>());
        return result;

        
    }
    private void recurse(int[] nums, int index,List<Integer>path){
        if(index == nums.length){
            result.add(path);
            return;
        }





        recurse(nums,index+1,new ArrayList(path));
        path.add(nums[index]);
        recurse(nums,index+1,new ArrayList(path));
    }
}