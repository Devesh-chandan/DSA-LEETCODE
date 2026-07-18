class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        int carry=0;
        StringBuilder ans = new StringBuilder();
        while (n1 >= 0 || n2 >= 0) {
            int digit1 = 0;
            int digit2 = 0;

            if (n1 >= 0) {
                digit1 = num1.charAt(n1) - '0';
                n1--;
            }

            if (n2 >= 0) {
                digit2 = num2.charAt(n2) - '0';
                n2--;
            }
            int sum=digit1+digit2+carry;
           ans.append(sum % 10);
            carry = sum / 10;


        }
        if (carry > 0) {
            ans.append(carry);
        }
        return ans.reverse().toString();
       
    }
}
