class Solution {
    public boolean stoneGameIX(int[] stones) {
        int countone=0;
        int countzero=0;
        int counttwo=0;
        boolean ans=true;
        for(int val:stones){
            if(val%3==0){
                countzero++;
            }
            else if(val%3==1){
                countone++;
            }else{
                counttwo++;
            }
            
if (countzero % 2 == 0){
            ans=countone > 0 && counttwo > 0;
}else{
ans=Math.abs(countone - counttwo) > 2;
}
            
        
        
    }
    return ans;
}
}