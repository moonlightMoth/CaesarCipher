import java.util.HashSet;
import java.util.Set;

public class CaesarCipherEncoder {


    public CaesarCipherEncoder()
    {

    }

    public String encode(String input, int offset, String keyWord)
    {
        String preparedKeyword = prepareKeyword(keyWord);
        System.out.println(preparedKeyword);

        char[] alterationArray = getAlterationArray(preparedKeyword, offset);

        for (char c: alterationArray) {
            System.out.print(c + " ");
        }


        return "";
    }

    private char[] getAlterationArray(String keyWord, int offset)
    {
        char[] keyCharset = keyWord.toCharArray();

        char[] alterationArray = new char[Utils.russianAlphabet.length];

        for (int i = 0; i < keyCharset.length; i++) {
            alterationArray[(i+offset) % alterationArray.length] = keyCharset[i];
        }

        Set<Character> keywordCharSet = Utils.arrayToSet(keyCharset);

        int j = 0;
        for (int i = 0; i < alterationArray.length; i++) {
            if (alterationArray[i] == Utils.emptyChar)
            {
                while (keywordCharSet.contains(Utils.russianAlphabet[j]))
                    j++;
                alterationArray[i] = Utils.russianAlphabet[j];
                j++;
            }
        }

        return alterationArray;
    }

    private String prepareKeyword(String initialKeyword)
    {
        Set<Character> russianAlphabetSet = Utils.russianAlphabetHashSet;
        Set<Character> persistentChars = new HashSet<>();
        StringBuilder sb = new StringBuilder("");

        initialKeyword = initialKeyword.toUpperCase();
        char currentChar;

        for (int i = 0; i < initialKeyword.length(); i++) {
            currentChar = initialKeyword.charAt(i);
            if (!persistentChars.contains(currentChar)
                    && russianAlphabetSet.contains(currentChar))
            {
                persistentChars.add(currentChar);
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }

}
