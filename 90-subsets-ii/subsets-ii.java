class Solution {

    //TC : O(2^n x n){recursion + adding to array} + O(nlogn){sorting the array}
    //SC : O(2^n) + O(n) {stack space}

    // public List<List<Integer>> subsetsWithDup(int[] nums) {
    //     Set<List<Integer>> ans = new HashSet<>();
    //     Arrays.sort(nums);
    //     helper(0,nums,ans,new ArrayList<>());
    //     return new ArrayList<>(ans);
    // }

    // private void helper(int index,int[] nums,Set<List<Integer>> ans,List<Integer> ds){
    //     if(index>=nums.length){
    //         ans.add(new ArrayList<>(ds));
    //         return;
    //     }

    //     ds.add(nums[index]);
    //     helper(index+1,nums,ans,ds);
    //     ds.remove(ds.size()-1);
    //     helper(index+1,nums,ans,ds);
    // }


    //Approach 2 : 

    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(0,nums,ans,new ArrayList<>());
        return ans;
    }

    private void helper(int index,int[] nums,List<List<Integer>> ans,List<Integer> ds){
         ans.add(new ArrayList<>(ds));

         for(int i=index;i<nums.length;i++){
            if(i!=index && nums[i]==nums[i-1]){
                continue;
            }
            ds.add(nums[i]);
            helper(i+1,nums,ans,ds);
            ds.remove(ds.size()-1);
         }
    }
}