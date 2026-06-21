class Solution {
    public int maxIceCream(int[] costs, int coins) {

        final int MAX_COST = 100000;
        int[] freq = new int[MAX_COST + 1];
        for (int cost : costs) {
            freq[cost]++;
        }
        int answer = 0;
        for (int cost = 1; cost <= MAX_COST; cost++) {
            if (freq[cost] == 0) {
                continue;
            }
        int canBuy = Math.min(freq[cost], coins / cost);
            answer += canBuy;
            coins -= canBuy * cost;
        }

        return answer;
    }
}

// NOT OPTIMAL SOLUTION

// class Solution {
//     public int maxIceCream(int[] costs, int coins) {
//         int count=0;
//         int sum=0;
//         Arrays.sort(costs);
        
//         for(int cost :costs){
            
//             if(cost<=coins){
               
//                 coins=coins-cost;
//                 count++;
                
//             }
            
//         }
//         return count;
//     }
// }