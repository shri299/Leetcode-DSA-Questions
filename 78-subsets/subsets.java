class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0,nums,ans, new ArrayList<>());
        return ans;
    }

    private void helper(int index, int[] nums, List<List<Integer>> ans, List<Integer> ds){
        if(index>=nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[index]);
        helper(index+1,nums,ans,ds);
        ds.remove(ds.size()-1);
        helper(index+1,nums,ans,ds);
    }
}