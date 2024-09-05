class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] check = {};
        int[] ans = new int[n];
        int val = 0;
        for(int i=0;i<rolls.length;i++){
            val = val + (mean - rolls[i]);
        }
        int shortcoming = val + (mean*n);
        if(shortcoming <= 0 ){
            return check;
        }
        int pro = shortcoming/n;
        int rem = shortcoming%n;
        if(pro>6 || pro==0){
            return check;
        }
        if (pro == 6 && rem!=0){
            return check;
        }
        else{
            for(int i=0;i<n;i++){
                ans[i]=pro;
            }
            if(rem==0){
                return ans;
            }
            else{
                for(int i =0;i<rem;i++){
                    ans[i]=ans[i]+1;
                }
            }
            

        }
        return ans;

        
    }
}