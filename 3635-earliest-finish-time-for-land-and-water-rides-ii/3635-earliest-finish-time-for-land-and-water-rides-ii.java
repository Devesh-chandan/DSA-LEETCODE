class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minlandfinish=Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            
            minlandfinish=Math.min(minlandfinish,landStartTime[i]+landDuration[i]);
        }
int minwaterfinish=Integer.MAX_VALUE;
        for(int j=0;j<waterStartTime.length;j++){
            minwaterfinish=Math.min(minwaterfinish,waterStartTime[j]+waterDuration[j]);
        }
        int ans = Integer.MAX_VALUE;

        // Land -> Water
        for (int j = 0; j < waterStartTime.length; j++) {
            ans = Math.min(
                ans,
                Math.max(minlandfinish, waterStartTime[j]) + waterDuration[j]
            );
        }

        // Water -> Land
        for (int i = 0; i < landStartTime.length; i++) {
            ans = Math.min(
                ans,
                Math.max(minwaterfinish, landStartTime[i]) + landDuration[i]
            );
        }

        return ans;
        
    }
}