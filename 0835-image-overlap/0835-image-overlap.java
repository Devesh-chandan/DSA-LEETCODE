class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int max = 0;
        for (int rowshift = -(n - 1); rowshift <= n - 1; rowshift++) {
            for (int colshift = -(n - 1); colshift <= n - 1; colshift++) {

                int count = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {

                        int newI = i + rowshift;
                        int newJ = j + colshift;
                        if (newI >= 0 && newI < n &&
                            newJ >= 0 && newJ < n) {

                            if (img1[i][j] == 1 && img2[newI][newJ] == 1) {
                                count++;
                            }
                        }
                    }
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}