import java.util.HashSet;
import java.util.Set;

public class Utils {
    public static final char[] russianAlphabet = new char[] {
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж',
            'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О',
            'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц',
            'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};
    public static Set<Character> russianAlphabetHashSet = arrayToSet(russianAlphabet);
    public static char emptyChar = (new char[1])[0];

    public static Set<Character> arrayToSet(char[] chars)
    {
        HashSet<Character> res = new HashSet<>();

        for (int i = 0; i < chars.length; i++) {
            res.add(chars[i]);
        }
        return res;
    }
}
