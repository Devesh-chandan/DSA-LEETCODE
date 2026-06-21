class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int count=0;
        int sum=0;
        Arrays.sort(costs);
        
        for(int cost :costs){
            
            if(cost<=coins){
               
                coins=coins-cost;
                count++;
                
            }
            
        }
        return count;
    }
}
