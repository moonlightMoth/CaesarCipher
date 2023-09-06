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
        Assert.assertTrue(1f - map.values().stream().reduce(Float::sum).get() < 0.0000001);


    }
}
