class Solution {
    public int numberOfSpecialChars(String word) {
        int count=0;
        HashSet<Character> lower=new HashSet<>();
         HashSet<Character> upper=new HashSet<>();
    for(int i=0;i<word.length();i++){
        char ch=word.charAt(i);
        if(Character.isLowerCase(ch)){
            lower.add(ch);
        }
        if(Character.isUpperCase(ch)){
            upper.add(ch);
        }
    }
   for(char ch:lower){
    char uppercase=Character.toUpperCase(ch);
    if(upper.contains(Character.toUpperCase(ch))){
        int loweridx=word.lastIndexOf(ch);
        int upperidx=word.indexOf(uppercase);
        if(loweridx<upperidx){
            count++;
        }
    }

   }
    return count;
    }
}