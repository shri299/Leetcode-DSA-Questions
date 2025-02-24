class Solution {
    public String getPermutation(int n, int k) {
        List<String> ans = new ArrayList<>();
        boolean[] used = new boolean[n + 1];
        helper(ans, new StringBuilder(), used, n);
        return ans.get(k - 1);
    }

    private void helper(List<String> ans, StringBuilder ds, boolean[] used, int n) {
        if (ds.length() == n) {
            ans.add(ds.toString());
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                ds.append(i);
                helper(ans, ds, used, n);
                ds.deleteCharAt(ds.length() - 1);
                used[i] = false;
            }
        }
    }
}