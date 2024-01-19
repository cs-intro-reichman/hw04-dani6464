import java.util.Arrays;

public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    
    String vowels = "aeiouAEIOU";// what is this? a variable outside of a function? what does that mean?
    public static void main(String[] args) {        
    }
    
    public static void testAllIndexOf(String str, char ch, int[] expected) {
        int[] result = allIndexOf(str, ch);
        System.out.println("Test result for \"" + str +
         "\" with char '" + ch + "' is " + 
                           Arrays.toString(result) +
                            ". Expected: " + Arrays.toString(expected) + 
                           " -> " + (Arrays.equals(result, expected)
                            ? "PASS" : "FAIL"));
    }

    public static void testCamelCase(String input, String expected) {
        String result = camelCase(input);
        System.out.println("Test result for \"" + input + "\" is \"" + result +
         "\". Expected: \"" + expected + "\" -> " + 
                           (result.equals(expected) ? "PASS" : "FAIL"));
    }

    public static void testCapVowelsLowRest(String input, String expected) {
        String result = capVowelsLowRest(input);
        System.out.println("Test result for \"" + input + "\" is \"" + result +
         "\". Expected: \"" + expected + "\" -> " + 
                           (result.equals(expected) ? "PASS" : "FAIL"));
    }

    public static String capVowelsLowRest (String string) {
        int strLen = string.length();
        String newString = "";

        for (int i = 0; i < strLen; i++){
            char ch = string.charAt(i);
            if ((ch == 'a') || (ch == 'A') ){
                newString += "A";
            }
            else if ((ch == 'u') || (ch == 'U') ){
                newString += "U";
            }
            else if ((ch == 'e') || (ch == 'E') ){
                newString += "E";
            }
            else if ((ch == 'i') || (ch == 'I') ){
                newString += "I";
            }
            else if ((ch == 'o') || (ch == 'O') ){
                newString += "O";
            }
            else{
            //  if capital letter than convert to lower,
            //  by adding to reach ascii val of lower  
            if (ch >= 'A' && ch <= 'Z'){
                ch = (char) (ch + ('a' - 'A'));
            }
            newString += ch;
        }
        }
        return newString;
    }

    public static String camelCase (String string) {
        int stringLen = string.length();
        int [] spaceIndexesArr = getSpaceIndexes(string, stringLen);
        String newString = "";
        boolean isFirstWord = true;
        int currentStart = 0;

        // start from letter and not space
        while (currentStart < stringLen && string.charAt(currentStart) == ' '){
            currentStart++;
        }

        // we didn't learn foreach
        for (int spaceIndex : spaceIndexesArr){
            // only spaced after words
            if (spaceIndex < currentStart){
                continue;
            }
            // add substring from current start to next space
            //  according to camelCase
            newString += transformWord(string.substring(currentStart,
             spaceIndex), isFirstWord);
            currentStart = spaceIndex + 1;
            isFirstWord = false;

        }
        // if after iterating over all spaces, there are chars left,
        //  then add them
        if (currentStart < stringLen){
                newString += transformWord(string.substring(currentStart),
                 isFirstWord); 
        }
        return newString;
    }

    private static String transformWord(String word, boolean firstWord) {
        if (word.length() == 0){
            return "";
        }

        String transformed = "";

        // first word of the entire variable name should start with lower case
        if(firstWord){
            transformed += toLowerCase(word.charAt(0));
        }
        else{
            transformed += toUpperCase(word.charAt(0));
        }

        // make the rest of letters lowercase
        for (int i = 1; i < word.length(); i++){
            transformed += toLowerCase(word.charAt(i));
        }

        return transformed;
    }

    private static char toUpperCase(char ch) {
        if ('a' <= ch && ch <= 'z'){
            ch = (char)(ch - ('a' - 'A'));
        }
        return ch;
    }

    private static char toLowerCase(char ch) {
        if ('A' <= ch && ch <= 'Z'){
            ch = (char)(ch + ('a' - 'A'));
        }
        return ch;
    }

    private static int[] getSpaceIndexes(String string, int stringLen) {
        // return array where each member is an
        //  index of space in the original string
        int [] tempSpacesArr = new int [stringLen];
        int counter = 0;

        for (int i = 0; i < stringLen; i++){
            if (string.charAt(i) == ' '){
                tempSpacesArr[counter] = i;
                counter++;
            }
        }

        int [] spacesArr = new int [counter];
        
        for (int i = 0; i < counter; i++){
            spacesArr[i] = tempSpacesArr[i];
        }

        return spacesArr;
    }

    public static int[] allIndexOf (String string, char chr) {
        int strLen = string.length();
        int counter = 0;

        for (int i = 0; i < strLen; i++){
            if(string.charAt(i) == chr){
                counter++;
            }
        }

        int [] arrayOfIndexesOf = new int [counter];
        int index = 0;

        for (int i = 0; i < strLen; i++){
            if(string.charAt(i) == chr){
                arrayOfIndexesOf[index] = i;
                index++;
            }
        }

        return arrayOfIndexesOf;
    }
}
