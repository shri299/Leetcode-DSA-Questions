class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        helper(0,nums,ans,new ArrayList<>());
        return new ArrayList<>(ans);
    }

    private void helper(int index,int[] nums,Set<List<Integer>> ans,List<Integer> ds){
        if(index>=nums.length){
            List<Integer> sortedList = new ArrayList<>(ds);
            Collections.sort(sortedList);
            ans.add(sortedList);
            return;
        }

        ds.add(nums[index]);
        helper(index+1,nums,ans,ds);
        ds.remove(ds.size()-1);
        helper(index+1,nums,ans,ds);
    }
}