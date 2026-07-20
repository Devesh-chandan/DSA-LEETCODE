class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
     
        int m = grid.length;
        int n = grid[0].length;
        int size=m*n;
        int temp[]=new int[size];
        int idn=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                temp[idn++]=grid[i][j];

            }
        }

        List<List<Integer>> res = new ArrayList<>();
        idn=0;
        for(int i=0;i<m;i++){
            List<Integer> list=new ArrayList<>();

            for(int j=0;j<n;j++){
                k = k % size;
                 int idx = idn - k;

        if (idx < 0) {
            idx += size;
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