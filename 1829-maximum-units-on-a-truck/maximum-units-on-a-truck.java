class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int maxUnits = 0;

        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

        for(int i=0;i<boxTypes.length;i++){
            if(boxTypes[i][0]<=truckSize){
                truckSize = truckSize - boxTypes[i][0];
                maxUnits = maxUnits + boxTypes[i][0]*boxTypes[i][1];
            }else{
                maxUnits = maxUnits + truckSize*boxTypes[i][1];
                break;
            }
        }

        return maxUnits;
    }
}