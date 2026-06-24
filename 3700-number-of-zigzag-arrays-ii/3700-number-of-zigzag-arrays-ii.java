class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) {
            return m;
        }

        int sz = 2 * m;

        long[] base = new long[sz];

        // State for length = 2
        for (int y = 0; y < m; y++) {
            base[y] = y;                 // up[2][y]
            base[m + y] = m - 1 - y;    // down[2][y]
        }

        if (n == 2) {
            long ans = 0;
            for (long v : base) {
                ans = (ans + v) % MOD;
            }
            return (int) ans;
        }

        long[][] trans = new long[sz][sz];

        // up'[j] = sum down[k], k < j
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < j; k++) {
                trans[j][m + k] = 1;
            }
        }

        // down'[j] = sum up[k], k > j
        for (int j = 0; j < m; j++) {
            for (int k = j + 1; k < m; k++) {
                trans[m + j][k] = 1;
            }
        }

        long[][] power = matrixPower(trans, n - 2);

        long[] result = multiply(power, base);

        long ans = 0;
        for (long v : result) {
            ans = (ans + v) % MOD;
        }

        return (int) ans;
    }

    private long[] multiply(long[][] mat, long[] vec) {
        int n = mat.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;

            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    sum = (sum + mat[i][j] * vec[j]) % MOD;
                }
            }

            res[i] = sum;
        }

        return res;
    }

    private long[][] matrixPower(long[][] mat, long exp) {
        int n = mat.length;

        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, mat);
            }

            mat = multiply(mat, mat);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;

        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {

                if (A[i][k] == 0) continue;

                long aik = A[i][k];

                for (int j = 0; j < n; j++) {

                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j] + aik * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }
}