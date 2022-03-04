class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        unordered_map<int,int> um;
        
        vector<int> ans;
        
        for(int i=0;i<nums.size();i++)
        {
            um[nums[i]] = i;
        }
        
        for(int i=0;i<nums.size();i++)
        {
            int x = target-nums[i];
            
            if(um.find(x)!=um.end())
            {
                if(um[x]!=i)
                {
                    ans.push_back(i);
                    ans.push_back(um[x]);
                    um.erase(nums[i]);
                    um.erase(x);
                }
            }
            
        }
        
        return ans;
        
    }
};