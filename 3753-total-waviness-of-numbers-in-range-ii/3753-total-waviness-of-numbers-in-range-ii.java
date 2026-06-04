import java.util.*;

class Solution {

    static class Pair {
        long count;
        long waviness;

        Pair(long count, long waviness) {
            this.count = count;
            this.waviness = waviness;
        }
    }

    private String digits;
    private Map<String, Pair> memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x <= 0) return 0;

        digits = String.valueOf(x);
        memo = new HashMap<>();

        return dfs(0, true, false, 10, 10).waviness;
    }

    private Pair dfs(int pos,
                     boolean tight,
                     boolean started,
                     int prev2,
                     int prev1) {

        if (pos == digits.length()) {
            return new Pair(started ? 1 : 0, 0);
        }

        String key = pos + "|" + prev2 + "|" + prev1 + "|" + started;

        if (!tight && memo.containsKey(key)) {
            return memo.get(key);
        }

        int limit = tight ? digits.charAt(pos) - '0' : 9;

        long totalCount = 0;
        long totalWaviness = 0;

        for (int d = 0; d <= limit; d++) {

            boolean nextTight = tight && (d == limit);

            if (!started && d == 0) {

                Pair child = dfs(
                        pos + 1,
                        nextTight,
                        false,
                        10,
                        10
                );

                totalCount += child.count;
                totalWaviness += child.waviness;

            } else if (!started) {

                Pair child = dfs(
                        pos + 1,
                        nextTight,
                        true,
                        10,
                        d
                );

                totalCount += child.count;
                totalWaviness += child.waviness;

            } else if (prev2 == 10) {

                Pair child = dfs(
                        pos + 1,
                        nextTight,
                        true,
                        prev1,
                        d
                );

                totalCount += child.count;
                totalWaviness += child.waviness;

            } else {

                int add = 0;

                if ((prev2 < prev1 && prev1 > d) ||
                    (prev2 > prev1 && prev1 < d)) {
                    add = 1;
                }

                Pair child = dfs(
                        pos + 1,
                        nextTight,
                        true,
                        prev1,
                        d
                );

                totalCount += child.count;

                totalWaviness += child.waviness
                               + child.count * add;
            }
        }

        Pair ans = new Pair(totalCount, totalWaviness);

        if (!tight) {
            memo.put(key, ans);
        }

        return ans;
    }
}