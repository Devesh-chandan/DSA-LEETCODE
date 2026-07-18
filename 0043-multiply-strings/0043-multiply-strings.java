class Solution {
    public String multiply(String num1, String num2) {
        int n1=num1.length();
        int n2=num2.length();
        if(n1==0 || n2==0 ||"0".equals(num1)|| "0".equals(num2)){
            return "0";

        }
        if("1".equals(num1)){
            return num2;
        }
        if("1".equals(num2)){
            return num1;
        }
 int[] result=new int[n1+n2];
 for(int i=n1-1;i>=0;i--){
    for(int j=n2-1;j>=0;j--){
        int product=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
        product+=result[i+j+1];
        result[i+j+1]=product%10;
        result[i+j]+=product/10;


    }
 }
 StringBuilder sb=new StringBuilder();
 for(int r:result){
    if(r==0 && sb.length()==0){
        continue;
    }
    sb.append(r);
 }
      return sb.toString();
    }
}