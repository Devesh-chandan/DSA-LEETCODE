class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long start = 1;
        long end = 9;
        long d = 1;

        while (start <= n) {
            long right = Math.min(end, n);
            long count = right - start + 1;

            long commasPerNumber = (d - 1) / 3;
            ans += count * commasPerNumber;

            start *= 10;
            end = end * 10 + 9;
            d++;
        }

        return ans;
    }
}