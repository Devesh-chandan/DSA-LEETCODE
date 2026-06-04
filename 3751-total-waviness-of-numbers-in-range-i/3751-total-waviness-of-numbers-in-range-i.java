class Solution {
    public int totalWaviness(int num1, int num2) {
    
        int count=0;

        for(int i=num1;i<=num2;i++){
          
            String nums=String.valueOf(i);
            for(int j=1;j<nums.length()-1;j++){
                int left=nums.charAt(j-1);
                int middle=nums.charAt(j);
                int right=nums.charAt(j+1);
                if((left>middle && right>middle) || (left<middle && right<middle)){
                    count++;
                }
            }

        
        
        
        }
        return count;
    }
}