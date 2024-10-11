class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int prevEnd = intervals[0][1];
        int count = 1;

        for (int i=1;i<intervals.length;i++){
            int currStart = intervals[i][0];

            if (currStart>=prevEnd){
                count++;
                prevEnd = intervals[i][1];
            }
        }

        return intervals.length-count;
        
    }

    // class Intervals implements Comparable<Intervals>{
    //     int start;
    //     int end;
        
    //     public Intervals (int start, int end){
    //         this.start=start;
    //         this.end=end;
    //     }

    //     @Override
    //     public int compareTo(Intervals o) {
    //         return this.end-o.end;
    //     }

    // }
}