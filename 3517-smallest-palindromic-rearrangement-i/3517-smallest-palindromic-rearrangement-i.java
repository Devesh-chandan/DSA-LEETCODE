class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        
        int freq[]=new int[26];
     
        StringBuilder left=new StringBuilder();
         String middle="";
            
      

       


        for(char ch:s.toCharArray()){
            
                freq[ch-'a']++;
                
        }

        for(int i=0;i<26;i++){
           for(int j = 0; j < freq[i] / 2; j++) {
    left.append((char)(i+'a'));
}
            if(freq[i]%2==1){
                middle = String.valueOf((char)(i + 'a'));

            }
        }
        String right = new StringBuilder(left).reverse().toString();
          String res=left.toString()+middle+right;
        
        return res;
        
    }
}