class Solution {
    public int minimumPushes(String word) {
        Integer freq[]=new Integer[26];
        Arrays.fill(freq,0);
        int ans=0;
        int cost=0;
        int size=word.length();
        for(char ch:word.toCharArray()){
            freq[ch-'a']++;
        }
        Arrays.sort(freq,Collections.reverseOrder());
       for (int i =0; i<26; i++) {
    if (freq[i] == 0) break;

   if(i>=0 && i<=7){
    cost=1;
   }
   if(i>7 && i<=15){
    cost=2;
   }
   if(i>15 && i<=23){
    cost=3;
   }
   if(i>23){
    cost=4;
   }
    ans += freq[i] * cost;
}
return ans;
    }
}
