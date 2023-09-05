import java.util.*;

public class CaesarCipherEncoder {


    public CaesarCipherEncoder()
    {

    }

    public String encode(String input, int offset, String keyWord)
    {
        String preparedKeyword = prepareKeyword(keyWord.toUpperCase(Locale.ROOT));
        Map<Character, Character> alterationMap = getAlterationMap(preparedKeyword, offset);
        return buildEncodedString(input.toUpperCase(Locale.ROOT), alterationMap);
    }

    private String buildEncodedString(String input, Map<Character, Character> alterationMap)
    {
        StringBuilder sb = new StringBuilder("");
        for (char c: input.toCharArray()) {
            sb.append(alterationMap.getOrDefault(c, c));
        }
        return sb.toString();
    }

    private Map<Character, Character> getAlterationMap(String keyWord, int offset)
    {
        char[] keyCharset = keyWord.toCharArray();

        char[] alterationArray = new char[Utils.russianAlphabet.length];

        for (int i = 0; i < keyCharset.length; i++) {
            alterationArray[(i+offset) % alterationArray.length] = keyCharset[i];
        }

        Set<Character> keywordCharSet = Utils.arrayToSet(keyCharset);

        int j = 0;
        for (int i = offset + 1; i < alterationArray.length + offset + 1; i++) {
            if (alterationArray[i % alterationArray.length] == Utils.emptyChar)
            {
                while (keywordCharSet.contains(Utils.russianAlphabet[j]))
                    j++;
                alterationArray[i % alterationArray.length] = Utils.russianAlphabet[j];
                j++;
            }
        }

        Map<Character, Character> alterationMap = new HashMap<>();

        for (int i = 0; i < alterationArray.length; i++) {
            alterationMap.put(Utils.russianAlphabet[i], alterationArray[i]);
        }

        return alterationMap;
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
