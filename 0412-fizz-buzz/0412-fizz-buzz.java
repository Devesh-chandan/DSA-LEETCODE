class Solution {
    public List<String> fizzBuzz(int n) {
        int num=1;
        List<String> list=new ArrayList<>();
        while(num<=n){
           
            if(num%3==0 && num%5==0){
                list.add("FizzBuzz");

            }else if(num%3==0){
list.add("Fizz");
            }
            else if(num%5==0){
        list.add("Buzz");
        
            }
            else{
                list.add(String.valueOf(num));
            }
           
           num++;
    }
     return list;
    }

}