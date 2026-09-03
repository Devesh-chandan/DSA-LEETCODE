class Solution {
    public boolean uniformArray(int[] nums1) {
        int minodd = Integer.MAX_VALUE;
        int mineven = Integer.MAX_VALUE;
        int even = 0;
        int odd = 0;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % 2 == 0) {
                even++;
            } else {
                odd++;

            }
            if (nums1[i] < minodd && nums1[i] % 2 != 0) {
                minodd = nums1[i];
            } else if (nums1[i] < mineven && nums1[i] % 2 == 0) {
                mineven = nums1[i];
            }
        }
        if (even == 0 || odd == 0) {
            return true;
        }

        System.out.println(minodd);
        System.out.println(mineven);

        if (mineven > minodd) {
            return true;
        }
        return false;
    }
}