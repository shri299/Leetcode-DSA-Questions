class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        ArrayList<Intervals> list = new ArrayList<>();

        for(int i=0;i<len;i++){
            list.add(new Intervals(intervals[i][0],intervals[i][1]));
        }

        Collections.sort(list);

        int prevEnd = list.get(0).end;
        int count = 1;

        for (int i=1;i<list.size();i++){
            int currStart = list.get(i).start;

            if (currStart>=prevEnd){
                count++;
                prevEnd = list.get(i).end;
            }
        }

        return len-count;
        
    }

    class Intervals implements Comparable<Intervals>{
        int start;
        int end;
        
        public Intervals (int start, int end){
            this.start=start;
            this.end=end;
        }

        @Override
        public int compareTo(Intervals o) {
            return this.end-o.end;
        }

    }
}