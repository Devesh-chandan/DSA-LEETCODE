class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int size=n*m;
        int temp[]=new int[size];
        int idn=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                temp[idn++]=grid[i][j];

            }
        }
        List<List<Integer>>res=new ArrayList<>();
        idn=0;
        for(int i=0;i<n;i++){
            List<Integer> list=new ArrayList<>();
            
            for(int j=0;j<m;j++){
                k=k%size;
                int idx=idn-k;
                if(idx<0){
                    idx+=size;
                }
                int val=temp[idx];
                list.add(val);
                idn++;

            }
            res.add(list);
        }
        
        return res;
        
    }
}