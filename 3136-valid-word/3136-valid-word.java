class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3){
            return false;
        }
        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);

            if(!Character.isLetterOrDigit(ch)){
                return false;
            }
            if(Character.isLetter(ch)){
                if(isVowel(ch)){
                    hasVowel = true;
                }else{
                    hasConsonant = true;
                }
            }
        }
        if(!hasVowel){
            return false;
        }
        if(!hasConsonant){
            return false;
        }
        return true;
    }
    private boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch =='u';
    }
}