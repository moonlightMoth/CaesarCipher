import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CaesarCipherDecoder {

    public CaesarCipherDecoder()
    {

    }



    public Map<Character, Float> getCharProbabilityMap(Path source) throws IOException {

        FileReader fr = new FileReader(source.toFile());
        BufferedReader br = new BufferedReader(fr);
        String readLine = "";
        Map<Character, Integer> separateCharMap = new HashMap<>();
        int charCount = 0;

        while ((readLine = br.readLine()) != null)
        {
            for (char c: readLine.toUpperCase(Locale.ROOT).toCharArray()) {
                if (Utils.russianAlphabetHashSet.contains(c)) {
                    charCount++;
                    separateCharMap.putIfAbsent(c, 0);
                    int i = separateCharMap.get(c);
                    i++;
                    separateCharMap.replace(c, i);
                }
            }
        }

        Map<Character, Float> probabilityMap = new HashMap<>();
        final int finalCharCount = charCount;

        separateCharMap.forEach((c, i) ->
        {probabilityMap.put(c, i.floatValue() / ((float)finalCharCount));});

        return probabilityMap;
    }
}
