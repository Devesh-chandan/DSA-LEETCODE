class Solution {
      public boolean canMakeBalloon(int[] freq) {
        return freq['b' - 'a'] >= 1 &&
               freq['a' - 'a'] >= 1 &&
               freq['l' - 'a'] >= 2 &&
               freq['o' - 'a'] >= 2 &&
               freq['n' - 'a'] >= 1;
    }

    public int maxNumberOfBalloons(String text) {
        int count = 0;
        int[] freq = new int[26];

        // Count frequencies
        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }

        // Brute-force: form balloons one by one
        while (canMakeBalloon(freq)) {
            freq['b' - 'a']--;
            freq['a' - 'a']--;
            freq['l' - 'a'] -= 2;
            freq['o' - 'a'] -= 2;
            freq['n' - 'a']--;

            count++;
        }

        return count;
    }
}