class Solution {
    public char processStr(String s, long k) {

        int n = s.length();
        long[] len = new long[n + 1];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            len[i + 1] = len[i];

            if (Character.isLetter(ch)) {
                len[i + 1]++;
            } 
            else if (ch == '*') {
                if (len[i + 1] > 0)
                    len[i + 1]--;
            } 
            else if (ch == '#') {
                len[i + 1] *= 2;
            }
            // '%' does not change length
        }

        if (k >= len[n])
            return '.';

        long idx = k;

        for (int i = n - 1; i >= 0; i--) {

            char ch = s.charAt(i);
            long cur = len[i + 1];
            long prev = len[i];

            if (ch == '%') {
                idx = cur - 1 - idx;
            }
            else if (ch == '#') {
                idx %= prev;
            }
            else if (ch == '*') {
                // backward: length increased by 1
                // nothing to do for index
            }
            else { // letter
                if (idx == prev) {
                    return ch;
                }
            }
        }

        return '.';
    }
}