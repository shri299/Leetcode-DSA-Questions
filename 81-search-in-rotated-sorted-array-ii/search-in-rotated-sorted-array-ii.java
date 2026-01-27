class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        while(low<=high){
            int mid = (high+low)/2;
            if(nums[mid]==target) return true;


            if(nums[mid]==nums[low] && nums[low]==nums[high]){
                low = low + 1;
                high = high - 1;
                continue;
            }

            
            if(nums[low]<=nums[mid]){ //first half sorted(this is basically done to check on which side pivot lies)
                if(nums[low]<=target && nums[mid]>=target){ //check if target lies between sorted section
                    high = mid-1;
                }else{ //if not move to the unsorted part
                    low = mid + 1;
                }
            }else{ //if 1st half unsorted(pivot lies in 1st half, so 2nd hald is sorted)
                if(nums[mid]<=target && nums[high]>=target){ //check if target lies between end half
                    low = mid + 1;
                }else{ //if not then move the unsoted part
                    high = mid-1;
                }
            }
        }

        return false;
    }
}