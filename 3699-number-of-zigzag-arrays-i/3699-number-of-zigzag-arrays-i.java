class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int MOD = 1_000_000_007;

        long[][] up = new long[n + 1][m];
        long[][] down = new long[n + 1][m];

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < m; y++) {
                if (x == y) continue;

                if (x < y) {
                    up[2][y] = (up[2][y] + 1) % MOD;
                } else {
                    down[2][y] = (down[2][y] + 1) % MOD;
                }
            }
        }

        for (int i = 3; i <= n; i++) {
            long[] prefixUP = new long[m + 1];
            long[] prefixDOWN = new long[m + 1];

            for (int v = 0; v < m; v++) {
                prefixUP[v + 1] = (prefixUP[v] + up[i - 1][v]) % MOD;
                prefixDOWN[v + 1] = (prefixDOWN[v] + down[i - 1][v]) % MOD;
            }

            for (int y = 0; y < m; y++) {
                up[i][y] = prefixDOWN[y];

                down[i][y] =
                    ((prefixUP[m] - prefixUP[y + 1]) % MOD + MOD) % MOD;
            }
        }

        long ans = 0;

        if (n == 1) {
            ans = m;
        } else {
            for (int y = 0; y < m; y++) {
                ans = (ans + up[n][y] + down[n][y]) % MOD;
            }
        }

        return (int) ans;
    }
}