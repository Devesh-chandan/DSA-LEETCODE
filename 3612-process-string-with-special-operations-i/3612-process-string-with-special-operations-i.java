class Solution {
    public String processStr(String s) {
        StringBuilder result=new StringBuilder();

        for(char ch :s.toCharArray()){
            if(Character.isLetter(ch)){
                result.append(ch);
            }
            else if(ch=='*'){
                if(result.length()>0){
result.setLength(result.length() - 1);
                }

            }
           else if(ch=='#'){
                result.append(result);


            }
            else if(ch=='%'){
                result.reverse();

            }
            
        }
        String res = result.toString();
        return res;
    }
}