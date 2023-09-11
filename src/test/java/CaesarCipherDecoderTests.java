import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class CaesarCipherDecoderTests {

    @Test
    public void getProbabilityMapTest() throws IOException {
        CaesarCipherDecoder ccd = CaesarCipherDecoder.getInstance();
        Assert.assertEquals(ccd.getCharProbabilityMap(Paths.get("src/main/resources/russian.txt")),
                ccd.getCharProbabilityMap(Paths.get("src/main/resources/russian.txt")));

        Map<Character, Float> map = ccd.getCharProbabilityMap(Paths.get("src/main/resources/russian.txt"));
        Assert.assertTrue(1f - map.values().stream().reduce(Float::sum).get() < 0.000001);

        Map<Character, Float> map1 = ccd.getCharProbabilityMap(Paths.get("src/test/resources/testText0.txt"));

        map.forEach((character, aFloat) -> System.out.println(character + " " + aFloat + " " + Math.abs(aFloat - map1.get(character)) + " " + aFloat/Math.abs(aFloat - map1.get(character))));
        map.forEach((character, aFloat) -> System.out.println(character + " " + aFloat + " " + Math.abs(aFloat - map1.get(character)) + " " + aFloat/Math.abs(map1.get(character))));

        Map<Character, Float> map2 = ccd.getCharProbabilityMap(Paths.get("src/test/resources/testText1.txt"));

        map.forEach((character, aFloat) -> System.out.println(character + " " + aFloat + " " + Math.abs(aFloat - map2.getOrDefault(character, 0f)) + " " + aFloat/Math.abs(aFloat - map2.getOrDefault(character, 0f))));
        map.forEach((character, aFloat) -> System.out.println(character + " " + aFloat + " " + Math.abs(aFloat - map2.getOrDefault(character, 0f)) + " " + aFloat/Math.abs(map2.getOrDefault(character, 0f))));


        Map<Character, Float> map3 = ccd.getCharProbabilityMap(Paths.get("src/test/resources/testText2.txt"));

        map.forEach((character, aFloat) -> System.out.println(character + " " + aFloat + " " + Math.abs(aFloat - map3.getOrDefault(character, 0f)) + " " + aFloat/Math.abs(aFloat - map3.getOrDefault(character, 0f))));
        map.forEach((character, aFloat) -> System.out.println(character + " " + aFloat + " " + Math.abs(aFloat - map3.getOrDefault(character, 0f)) + " " + aFloat/Math.abs(map3.getOrDefault(character, 0f))));

    }
}
