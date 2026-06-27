class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int ans = 1;

        // Handle 1 separately
        if (freq.containsKey(1)) {
            int c = freq.get(1);
            ans = Math.max(ans, (c % 2 == 0) ? c - 1 : c);
        }

        for (int x : freq.keySet()) {
            if (x == 1) continue;

            long cur = x;
            int len = 0;

            while (cur <= Integer.MAX_VALUE) {
                int cnt = freq.getOrDefault((int) cur, 0);

                if (cnt >= 2) {
                    len += 2;

                    if (cur > Math.sqrt(Integer.MAX_VALUE)) {
                        cur = (long) Integer.MAX_VALUE + 1;
                        break;
                    }

                    cur = cur * cur;
                } else {
                    break;
                }
            }

            if (cur <= Integer.MAX_VALUE &&
                freq.getOrDefault((int) cur, 0) >= 1) {
                len++;
            } else if (len > 0) {
                len--;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}