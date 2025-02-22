class Solution {

    //TC : O(2^n x nlogn){recursion + sorting} + O(2^n x n){adding in the set in worst case}
    //SC : O(2^n)

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        helper(0,nums,ans,new ArrayList<>());
        return new ArrayList<>(ans);
    }

    private void helper(int index,int[] nums,Set<List<Integer>> ans,List<Integer> ds){
        if(index>=nums.length){
            // List<Integer> sortedList = new ArrayList<>(ds);
            // Collections.sort(sortedList);
            // ans.add(sortedList);
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[index]);
        helper(index+1,nums,ans,ds);
        ds.remove(ds.size()-1);
        helper(index+1,nums,ans,ds);
    }
}