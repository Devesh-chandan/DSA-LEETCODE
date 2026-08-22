class Solution {
    public boolean checkDivisibility(int n) {
        int pro=1;
        int sum=0;
        int num=n;
        while(num>0){
int digit=num%10;
num=num/10;

                pro *= digit;
            
sum+=digit;

        }
        System.out.println(sum);
        System.out.println(pro);
        if(n % (pro+sum)==0){
            return true;
        }else{
return false;
        }
       
        
    }
}