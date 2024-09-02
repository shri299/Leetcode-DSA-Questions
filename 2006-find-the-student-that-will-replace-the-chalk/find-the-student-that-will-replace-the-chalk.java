class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int len = chalk.length;
        long sum = 0;
        for (int chalks : chalk) {
            sum += chalks;
        }

        long rem = k % sum;

        for (int i = 0; i < len; i++) {
            if (chalk[i] > rem) {
                return i;
            }
            rem -= chalk[i];
        }
        return 0;
    }
}