// class Solution {
//     public int maxPalindromes(String s, int k) {
//         int n = s.length(), ans = 0, end = -1;

//         for (int i = 0; i < n; i++) {
//             for (int l0 : new int[]{i - 1, i}) {
//                 int l = l0, r = i;

//                 while(l>=0 && r < n && s.charAt(l) == s.charAt(r)){
//                     if (r - l + 1 >= k && l > end) {
//                         ans++;
//                         end = r;
//                         break;
//                     }

//                     l--;
//                     r++;
//                 }
//             }
//         }

//         return ans;
//     }
// }




//approach 2
class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] palindrome = new boolean[n][n];
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                    (j - i < 2 || palindrome[i + 1][j - 1])) {
                    palindrome[i][j] = true;
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];

            for (int j = 0; j < i; j++) {
                if (i - j >= k && palindrome[j][i - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n];
    }
}